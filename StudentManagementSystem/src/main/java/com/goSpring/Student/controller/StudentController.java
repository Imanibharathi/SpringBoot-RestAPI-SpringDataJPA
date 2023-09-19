package com.goSpring.Student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.goSpring.Student.entity.StudentDetails;
import com.goSpring.Student.repository.StudentRepository;

@RestController
public class StudentController {
	
	@Autowired
	StudentRepository repo;
	
	@GetMapping("/students/{id}")
	public StudentDetails getStudentDetails(@PathVariable("id") int id) {
		StudentDetails std = repo.findById(id).get();
		return std;
	}
	
	@GetMapping("/students/all")
	public List<StudentDetails> getAllStudentDetails() {
		List<StudentDetails> std = repo.findAll();
		return std;
	}
	
	@PostMapping("/students/add")
	public String postStudentDetails(@RequestBody StudentDetails studentDetails) {
		repo.save(studentDetails);
		return "Data posted successfully";
	}
	
	@PutMapping("/students/update/{id}")
	public String putStudentDetails(@PathVariable("id") int id) {
		StudentDetails std = repo.findById(id).get();
		std.setName("Jo");std.setBranch("Cinema");std.setPerc(89.98);
		repo.save(std);
		return "Data updated successfully";
	}
	
	@DeleteMapping("/students/delete/{id}")
	public String deleteStudentDetails(@PathVariable("id") int id) {
		
		StudentDetails std = repo.findById(id).get();
		repo.delete(std);
		return "Data Deleted successfully";
	}

}
