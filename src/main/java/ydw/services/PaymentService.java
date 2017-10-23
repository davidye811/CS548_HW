package ydw.services;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;

import ydw.accountapp.exception.CreditCardFormatVialationException;
import ydw.accountapp.exception.UnknownTableEntryException;
import ydw.accountapp.exception.authorizationFailureException;
import ydw.domain.*;

public interface PaymentService {
	public void produceInvoice(Student student);
	public void makepayment(Student student,String creditcardnumber,double amount) throws CreditCardFormatVialationException, InvocationTargetException,authorizationFailureException, UnknownTableEntryException, ParseException;
}
