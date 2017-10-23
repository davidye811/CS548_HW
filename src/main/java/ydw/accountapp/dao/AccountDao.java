package ydw.accountapp.dao;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ydw.accountapp.exception.DuplicateTableEntryException;
import ydw.accountapp.exception.UnknownTableEntryException;
import ydw.domain.Account;
import ydw.domain.Student;

public interface AccountDao {
	public void createAccountForStudent(int  studentId) throws DuplicateTableEntryException, ParseException;
	public double retrieveBalance(int accountId) throws UnknownTableEntryException;
	public void addAmountToCurrentBalance(int accountId,double amount) throws UnknownTableEntryException;
	public List<Integer> overdueBalance(Date dueDate);
}
