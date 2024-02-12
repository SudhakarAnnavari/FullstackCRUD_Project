package com.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.model.Student;
import com.test.service.StudentService;

@RestController
@CrossOrigin("http://localhost:3000")
public class MainController {
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/student")
	public List<Student> getAllStudents(){
		return studentService.getALLStudents();
	}
	
	
    @PostMapping("/student")
    public Student add(@RequestBody Student student) {
    	
		return studentService.addStudents(student);
    	
    }
    
    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable int id) {
    	
		return studentService.getStudent(id);
    	
    }
    
    @PutMapping("/student/{id}")
    public Student updateData(@RequestBody Student newstudent, @PathVariable int id) {
    	return studentService.updateData(newstudent,id);
    }
    
    
    @DeleteMapping("/student/{id}")
    public String deleteData(@PathVariable int id) {
    	return studentService.deleteData(id);
    }


	

}
