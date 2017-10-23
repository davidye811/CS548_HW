package ydw.domain;

import java.util.List;

public class Course {
	String name;
	String departmentName;
	boolean isGraduatelevel;
	int numberOfUnit;
	public Course(String name, String departmentName, boolean isGraduatelevel, int numberOfUnit, int numberOfStudent,
			List<Student> studentsEnrolledIn) {
		super();
		this.name = name;
		this.departmentName = departmentName;
		this.isGraduatelevel = isGraduatelevel;
		this.numberOfUnit = numberOfUnit;
		this.numberOfStudent = numberOfStudent;
		this.studentsEnrolledIn = studentsEnrolledIn;
	}
	int numberOfStudent;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public boolean isGraduatelevel() {
		return isGraduatelevel;
	}
	public void setGraduatelevel(boolean isGraduatelevel) {
		this.isGraduatelevel = isGraduatelevel;
	}
	public int getNumberOfUnit() {
		return numberOfUnit;
	}
	public void setNumberOfUnit(int numberOfUnit) {
		this.numberOfUnit = numberOfUnit;
	}
	public int getNumberOfStudent() {
		return numberOfStudent;
	}
	public void setNumberOfStudent(int numberOfStudent) {
		this.numberOfStudent = numberOfStudent;
	}
	public List<Student> getStudentsEnrolledIn() {
		return studentsEnrolledIn;
	}
	public void setStudentsEnrolledIn(List<Student> studentsEnrolledIn) {
		this.studentsEnrolledIn = studentsEnrolledIn;
	}
	List<Student> studentsEnrolledIn;
}
