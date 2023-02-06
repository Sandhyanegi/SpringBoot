package com.app.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.app.dto.LoginDto;
import com.app.pojos.Student;
import com.app.service.StudentService;

@RestController 
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentService studService; 

	public StudentController() {
		System.out.println("In default constructor of --" + getClass());
	}

	
//--------------------------Add--------------------------------------------------
	@PostMapping
	public Student saveStudentDetails(@RequestBody Student stud)
	{
		return studService.addNewStudent(stud);
		
	}
	
	
//------------------------------------GET-------------------------------------------------
	@GetMapping
	public List<Student> getAllStudents() 
	{
		return studService.getAllStudentsDetails();
	}

//------------------------------------delete---------------------------------------------
	@DeleteMapping("/{rollNo}")
	public String deleteStudentDetails(@PathVariable Long rollNo)
	{
		return new String(studService.deleteStudent(rollNo));
	}
	
	
//------------------------------------update--------------------------------------------
	@PutMapping
	public Student updateStudentDetails(@RequestBody Student detachedEmp) throws Exception
	{
		return studService.updateStudentDetails(detachedEmp);
	}
	
//---------------------------------get by rollno-----------------------------
	
	@GetMapping("/{rollNo}")
	public Student getStudentDetails(@PathVariable Long rollNo) throws Exception
	{
		return studService.fetchStudentDetailsByRollNo(rollNo);
	}
	
//------------------------------------validation-------------------------------

	@PostMapping("/signin")
	public Student validateStudent(@RequestBody LoginDto dto) throws Exception
	{
		return studService.authenticateStudent(dto);
	}

	
}
