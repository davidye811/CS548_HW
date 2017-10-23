package com.ydw.accountapp.test;

import java.text.ParseException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ydw.accountapp.exception.CreditCardFormatVialationException;
import ydw.accountapp.exception.UnknownTableEntryException;
import ydw.accountapp.exception.authorizationFailureException;
import ydw.domain.Student;
import ydw.services.*;

@ContextConfiguration("classpath:coursedao-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class PaymentServiceTest {
	@Autowired
	@Qualifier("PaypalinvoiceGenerator")
	private PaymentService paymentservice;

	
	@Test(expected=authorizationFailureException.class)
	public void testauthorizationFailureException() throws Exception{
		Student setupstudent= new Student(1111);
		paymentservice.makepayment(setupstudent, "532123223223223", 500.0);
	}
	@Test(expected=CreditCardFormatVialationException.class)
	public void testCreditCardFormatVialationException() throws Exception{
		Student setupstudent= new Student(1111);
		paymentservice.makepayment(setupstudent, "3532123223223223", 500.0);
	}
}
