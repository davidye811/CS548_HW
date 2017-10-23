package ydw.accountapp.dao.mock;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import ydw.accountapp.dao.AccountDao;
import ydw.accountapp.exception.DuplicateTableEntryException;
import ydw.accountapp.exception.UnknownTableEntryException;
import ydw.domain.Account;
@Repository("accountDaoMock")
public class AccountDaoMockImpl implements AccountDao {
	private static long idGenerator=0;
	private ArrayList<Account> accList;
	@PostConstruct
	public void init() throws ParseException {
		accList=new ArrayList<Account>();
		accList.add(new Account(9999,9999.00));
		accList.add(new Account(9998,9999.00,new SimpleDateFormat("mm/dd/yyyy").parse("06/27/2005")));
	}
	public void createAccountForStudent(int studentId) throws DuplicateTableEntryException, ParseException {
		for(Account i:accList) {
			if(i.getAccountId()==studentId) {
				throw new DuplicateTableEntryException("Duplicate Id:"+studentId);
			}
		}
		accList.add(new Account(studentId,0.0));
	}

	public static long getIdGenerator() {
		return idGenerator;
	}

	public static void setIdGenerator(long idGenerator) {
		AccountDaoMockImpl.idGenerator = idGenerator;
	}

	public ArrayList<Account> getAccList() {
		return accList;
	}

	public void setAccList(ArrayList<Account> accList) {
		this.accList = accList;
	}

	public double retrieveBalance(int accountId) throws UnknownTableEntryException {
		for(Account i:accList) {
			if(i.getAccountId()==accountId) {
				return i.getBalanceDue();
			}
		}
		throw new UnknownTableEntryException(accountId + " not found in the database");
	}

	public void addAmountToCurrentBalance(int accountId, double amount) throws UnknownTableEntryException {
		for(Account i:accList) {
			if(i.getAccountId()==accountId) {
				i.setBalanceDue(i.getBalanceDue()+amount);
				return ;
			}
		}
		throw new UnknownTableEntryException(accountId + " not found in the database");
	
	}

	public List<Integer> overdueBalance(Date dueDate) {
		List<Integer> overdueBalance=new ArrayList<Integer>();
		for(Account i:accList) {
			if(i.getBalanceDue()>0.0&&i.getDateDue().after(dueDate));
				overdueBalance.add(i.getAccountId());
		}
		return overdueBalance;
	}

	

}
