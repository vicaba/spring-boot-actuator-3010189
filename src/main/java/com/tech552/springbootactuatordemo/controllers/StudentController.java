package com.tech552.springbootactuatordemo.controllers;

import com.tech552.springbootactuatordemo.models.Student;
import com.tech552.springbootactuatordemo.services.StudentService;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1")
public class StudentController {

	private Counter hitCounter;

	private StudentService studentService;

	public StudentController(MeterRegistry meterRegistry, StudentService studentService) {
		hitCounter = Counter.builder("hit_counter").description("Number of hits").register(meterRegistry);
		this.studentService = studentService;
	}

	@PostMapping("/student")
	public void addStudent(@RequestBody Student student) {
		studentService.addStudent(student);
	}

	@GetMapping("/student")
	public List<Student> getAllStudents() {
		hitCounter.increment();
		return studentService.getAllStudents();
	}

	@GetMapping("/student/{id}")
	public Optional<Student> getStudentById(@PathVariable Long id) {
		return studentService.getStudentById(id);
	}

	@PutMapping("/student/{id}")
	public void updateStudent(@PathVariable Long id, @RequestBody Student student) {
		studentService.updateStudent(id, student);
	}

	@DeleteMapping("/student/{id}")
	public void deleteStudent(@PathVariable Long id) {
		studentService.deleteStudent(id);
	}

}
