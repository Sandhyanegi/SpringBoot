package com.app.service;

import java.time.LocalDate;
import java.util.List;

import com.app.dto.LoginDto;
import com.app.pojos.Student;

public interface StudentService {

	Student addNewStudent(Student stud);	

	List<Student> getAllStudentsDetails();

	String deleteStudent(Long rollNo);
	
	Student updateStudentDetails(Student stud)throws Exception ;
	
	Student fetchStudentDetailsByRollNo(Long rollNo)throws Exception ;	

	Student authenticateStudent(LoginDto dto) throws Exception;
	
}
