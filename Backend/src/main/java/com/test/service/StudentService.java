package com.test.service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.model.Student;
import com.test.repositary.StudentRepositary;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepositary sr;
	
	public List<Student> getALLStudents(){
		return (List<Student>) sr.findAll();	
	}
	
	
	public Student addStudents(Student student) {
		Student save = sr.save(student);
		return save;
	}


	public Student getStudent(int id) {
		Optional<Student> byId = sr.findById(id);
		Student student = byId.get();
		return student;
	}
	
	
	public Student updateData(Student newstudent, int id) {
	    Optional<Student> optionalStudent = sr.findById(id);
	    if (optionalStudent.isPresent()) {
	        Student studentToUpdate = optionalStudent.get();
	        studentToUpdate.setS_name(newstudent.getS_name());
	        studentToUpdate.setCourse(newstudent.getCourse());
	        studentToUpdate.setFees(newstudent.getFees());
	        return sr.save(studentToUpdate); // Return the updated entity
	    } else {
	        throw new IllegalArgumentException("Student with ID " + id + " not found");
	    }
	}
	
	public String deleteData(int id) {
		sr.deleteById(id);
		return "student " + id + " deleted";
	}



}
