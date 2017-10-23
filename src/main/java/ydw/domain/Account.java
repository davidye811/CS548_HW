package ydw.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Account {
	public Account(int studentId, double balanceDue) throws ParseException {
		this.accountId=studentId;
		this.balanceDue=balanceDue;
		this.dateDue=new SimpleDateFormat("mm/dd/yyyy").parse("06/27/2007");
	}
	int accountId;
	public Account(int accountId, double balanceDue, Date dateDue) {
		super();
		this.accountId = accountId;
		this.balanceDue = balanceDue;
		this.dateDue = dateDue;
	}
	double balanceDue;
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public double getBalanceDue() {
		return balanceDue;
	}
	public void setBalanceDue(double balanceDue) {
		this.balanceDue = balanceDue;
	}
	public Date getDateDue() {
		return dateDue;
	}
	public void setDateDue(Date dateDue) {
		this.dateDue = dateDue;
	}
	Date dateDue;
}
