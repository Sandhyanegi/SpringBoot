package com.app.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.LoginDto;
import com.app.pojos.Student;
import com.app.repository.StudentRepository;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository studRepo;

//	@Autowired
//	private ModelMapper mapper;
	
//	@PostConstruct
//	public void init()
//	{
//		System.out.println("in init "+mapper);
//	}

//-------------------------------------New--------------------------------------
	@Override
	public Student addNewStudent(Student stud) {
		return studRepo.save(stud);
	}

//--------------------------------------Get-------------------------------------
	@Override
	public List<Student> getAllStudentsDetails() {
		return studRepo.findAll();
	}


//------------------------------------Delete---------------------------------------
	@Override
	public String deleteStudent(Long rollNo) {
		
		if (studRepo.existsById(rollNo)) 
		{
			studRepo.deleteById(rollNo);
			return "Details deleted ....";
		}
		return "Deletion Failed !!!!!!!!!!!";
	}
	
//-------------------------Update----------------------------------------------
	@Override
	public Student updateStudentDetails(Student stud) throws Exception 
	{
		if (studRepo.existsById(stud.getRollNo())) {
			return studRepo.save(stud);
		}
		throw new Exception("Updation Failed!!!!!!!!");
	}
	
//------------------------------get by rollno---------------------------------
	@Override
	public Student fetchStudentDetailsByRollNo(Long empId) throws Exception 
	{
		return studRepo.findById(empId).orElseThrow(() -> new Exception("Invalid!!!!!"));
	}
	
	
	
//-----------------------------------validation-------------------------------
	
	@Override
	public Student authenticateStudent(LoginDto dto) throws Exception {
		// TODO Auto-generated method stub
		return studRepo.findByEmailAndPassword(dto.getEmail(), dto.getPassword())
				.orElseThrow(() -> new Exception("Bad Credentials !!!!!"));
	}
	

}
