package ydw.services;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.regex.Pattern;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import ydw.accountapp.exception.*;

import org.aspectj.lang.annotation.After;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import ydw.accountapp.dao.AccountDao;
import ydw.domain.*;
@Component("PaypalinvoiceGenerator")
public class PaymentServicePaypalImpl implements PaymentService {
	
	@Value("${invoice.companyName_paypal}")
	private String companyName;
	@Autowired
	@Qualifier("accountDaoMock")
	private AccountDao AccountDAO;
	public NumberFormat getDlrFormatter() {
		return dlrFormatter;
	}
	public void setDlrFormatter(NumberFormat dlrFormatter) {
		this.dlrFormatter = dlrFormatter;
	}
	public AccountDao getAccountDAO() {
		return AccountDAO;
	}
	public void setAccountDAO(AccountDao accountDAO) {
		AccountDAO = accountDAO;
	}
	public String getCompanyName() {
		return companyName;
	}



	private NumberFormat dlrFormatter = NumberFormat.getCurrencyInstance();
	// Uncomment this to try constructor injection instead of setter injection
	/*
	public InvoiceGeneratorImpl(String companyName, int companyId,
			double salesTax, ShippingChargeCalculator shippingCalculator)
	{
		this.companyName = companyName;
		this.companyId = companyId;
		this.salesTax = salesTax;
		this.shippingCalculator = shippingCalculator;
	}
	*/
	@PostConstruct
	public void initIvnGen(){
		System.out.println("Initializing the Invoice Generator");
	}
	@PreDestroy
	public void shutdownIvnGen(){
		System.out.println("shutting down the Invoice Generator");
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	
	
	public void produceInvoice(Student student) {
		System.out.println("Using the "+companyName+" credit card "+
		"processor to process credit card number "+student.getCardnumber()+" for"+student.getName()+". Payment of "+dlrFormatter.format(student.getTuitionAmount()));
	}
	public void makepayment(Student student, String creditcardnumber, double amount) throws CreditCardFormatVialationException, authorizationFailureException, UnknownTableEntryException, ParseException {
		// TODO Auto-generated method stub
		double balance=0.0;
			try {
				AccountDAO.createAccountForStudent(student.getId());
			} catch (DuplicateTableEntryException e) {
				// TODO Auto-generated catch block
				balance=AccountDAO.retrieveBalance(student.getId());
			} 
		if(!Pattern.matches("^\\d{15}$", creditcardnumber)) {
			throw new CreditCardFormatVialationException("Invalid credit card number:"+creditcardnumber);
		}else if(creditcardnumber.charAt(0)=='5') {
				throw new authorizationFailureException("Payment authorization failed:"+creditcardnumber);
			}else {
				AccountDAO.addAmountToCurrentBalance(student.getId(), amount);
				System.out.println("Student ID:"+student.getId()+"\nDue Balance:"+AccountDAO.retrieveBalance(student.getId()));
			}
		
	
	}
	
	

}
