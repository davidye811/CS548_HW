package ydw.services;
import java.util.List;

import org.springframework.stereotype.Component;

import ydw.domain.Course;
import ydw.domain.Student;
import ydw.services.TuitionCalculatorService;
@Component("TuitionCalculatorNational")
public class TuitionCalculatorNationalImpl implements TuitionCalculatorService {
	double totalPrices;
	int totalUnits;
	public double getTotalPrices() {
		return totalPrices;
	}

	public void setTotalPrices(double totalPrices) {
		this.totalPrices = totalPrices;
	}

	public int getTotalUnits() {
		return totalUnits;
	}

	public void setTotalUnits(int totalUnits) {
		this.totalUnits = totalUnits;
	}

	public int getChemicalUnits() {
		return chemicalUnits;
	}

	public void setChemicalUnits(int chemicalUnits) {
		this.chemicalUnits = chemicalUnits;
	}

	int chemicalUnits;
		
	public double computeTutition(Student student, List<Course> courses) {
		// TODO Auto-generated method stub
		totalPrices=0.0;
		totalUnits = 0;
		chemicalUnits=0;
		for(Course course:courses){
			if(course.getDepartmentName()=="Chemistry"){
				chemicalUnits+=course.getNumberOfUnit();
			}
			totalUnits+=course.getNumberOfUnit();
		}
		totalPrices+=chemicalUnits*50.0;
		if(student.isInternational()){
			return totalPrices+totalUnits*500.0;
		}else{
			return totalPrices+totalUnits*230.0;
		}
	}
	

}
