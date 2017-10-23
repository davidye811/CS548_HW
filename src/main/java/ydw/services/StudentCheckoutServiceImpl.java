package ydw.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.List;
import java.util.Properties;

import javax.annotation.Resource;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import ydw.accountapp.exception.CreditCardFormatVialationException;
import ydw.accountapp.exception.UnknownTableEntryException;
import ydw.accountapp.exception.authorizationFailureException;
import ydw.domain.Course;
import ydw.domain.Student;
@Service("StuCheckService")
public class StudentCheckoutServiceImpl implements StudentCheckoutService {
	 @Before
	    public void before() {
	        System.out.println("Wellcome");
	    }
	 @After(value = "")
	 	public void after() {
		 System.out.println("See you");
	 }
	 @Around(value = "")
	 	public void error() {
		 System.out.println("encounter some error");
	 }
	@Value("${invoice.typeOfPaymentMethod}")
	private String paymentMethod;
	@Value("${invoice.typeOfTuitionCalculater}")
	private String checkOutMethod;
	@Value("${invoice.typeOfTuitionCalculater}")
	private String universityType;
	public String getUniversityType() {
		return universityType;
	}

	public void setUniversityType(String universityType) {
		this.universityType = universityType;
	}



	
	private TuitionCalculatorService tuitioncalculatorservice;

	
	

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getCheckOutMethod() {
		return checkOutMethod;
	}

	public void setCheckOutMethod(String checkOutMethod) {
		this.checkOutMethod = checkOutMethod;
	}

	

	public TuitionCalculatorService getTuitioncalculatorservice() {
		return tuitioncalculatorservice;
	}

	public void setTuitioncalculatorservice(TuitionCalculatorService tuitioncalculatorservice) {
		this.tuitioncalculatorservice = tuitioncalculatorservice;
	}




	
	public void checkOut(Student student, List<Course> courses, String cardnumber) throws ReflectiveOperationException, Exception, authorizationFailureException, Exception, ParseException {
		ApplicationContext container=new ClassPathXmlApplicationContext("/META-INF/spring/app-context.xml");
		TuitionCalculatorService tuitioncalculatorservice=
					(TuitionCalculatorService)container.getBean(universityType);
		
		PaymentService invoicegenerator=
		(PaymentService)container.getBean(paymentMethod);
	
		double totalTuition=tuitioncalculatorservice.computeTutition(student, courses);
		student.setTuitionAmount(totalTuition);
		student.setCardnumber(cardnumber);
		invoicegenerator.produceInvoice(student);
		invoicegenerator.makepayment(student, cardnumber, totalTuition);
		for(Course course:courses){
			course.setNumberOfStudent(course.getNumberOfStudent()+1);
			List<Student> students=course.getStudentsEnrolledIn();
			students.add(student);
			course.setStudentsEnrolledIn(students);
		}
	}

}
