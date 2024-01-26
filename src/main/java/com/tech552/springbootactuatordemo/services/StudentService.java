package com.tech552.springbootactuatordemo.services;

import com.tech552.springbootactuatordemo.models.Student;
import com.tech552.springbootactuatordemo.repos.StudentRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

	private StudentRepository studentRepository;

	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	public void addStudent(Student student) {
		studentRepository.save(student);
	}

	public List<Student> getAllStudents() {
		List<Student> listOfStudents = new ArrayList<>();
		studentRepository.findAll().forEach(listOfStudents::add);
		return listOfStudents;
	}

	public Optional<Student> getStudentById(Long id) {
		return studentRepository.findById(id);
	}

	public void updateStudent(Long id, Student student) {
		studentRepository.save(student);
	}

	public void deleteStudent(Long id) {
		studentRepository.deleteById(id);
	}

}
