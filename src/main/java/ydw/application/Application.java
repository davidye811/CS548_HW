package ydw.application;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ydw.accountapp.exception.authorizationFailureException;
import ydw.domain.Course;
import ydw.domain.Student;
import ydw.services.StudentCheckoutService;
import ydw.services.TuitionCalculatorService;

public class Application {
	public static void main(String []argv) throws ReflectiveOperationException, authorizationFailureException, ParseException, Exception {
		ApplicationContext container=new ClassPathXmlApplicationContext("/META-INF/spring/app-context.xml");
		StudentCheckoutService studentcheckoutservice=
					(StudentCheckoutService)container.getBean("StuCheckService");
		
		studentcheckoutservice.checkOut(createStudent(), courses(), "423212432123421");
		
	}
	
	static Student createStudent() {
		Student a = new Student(9999);
		a.setInternational(true);
		a.setName("HHHHHan");
	
		return new Student(9999);
	}
	static List<Course> courses(){
		Course[] courseArrays=new Course[3];
		courseArrays[0]=new Course("Advanced Math","Math", false, 3, 0, new ArrayList<Student>());
		courseArrays[1]=new Course("Advanced Java","Computer Science", true, 5, 0, new ArrayList<Student>());
		courseArrays[2]=new Course("Advanced DataBase","Computer Science", false, 4, 0, new ArrayList<Student>());
		
		List<Course> courses=new ArrayList<Course>();
		for(Course course:courseArrays) {
			courses.add(course);
		}
		return courses;
	}
}	
