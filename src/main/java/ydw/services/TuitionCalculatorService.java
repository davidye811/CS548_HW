package ydw.services;

import java.util.List;

import ydw.domain.Course;
import ydw.domain.Student;

public interface TuitionCalculatorService {
	public double computeTutition(Student student,List<Course> courses);
}
