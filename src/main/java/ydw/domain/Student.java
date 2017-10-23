package ydw.domain;

public class Student {
	String Name;
	int Id;
	boolean isInternational;
	boolean isGradute;
	String cardnumber;
	double tuitionAmount;
	public String getCardnumber() {
		return cardnumber;
	}
	public void setCardnumber(String cardnumber) {
		this.cardnumber = cardnumber;
	}
	public double getTuitionAmount() {
		return tuitionAmount;
	}
	public void setTuitionAmount(double tuitionAmount) {
		this.tuitionAmount = tuitionAmount;
	}
	public Student(int studentId) {
		this.Id=studentId;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public boolean isInternational() {
		return isInternational;
	}
	public void setInternational(boolean isInternational) {
		this.isInternational = isInternational;
	}
	public boolean isGradute() {
		return isGradute;
	}
	public void setGradute(boolean isGradute) {
		this.isGradute = isGradute;
	}
	
}
