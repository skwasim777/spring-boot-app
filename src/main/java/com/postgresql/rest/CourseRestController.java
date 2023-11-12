package com.postgresql.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.postgresql.entity.Course;
import com.postgresql.service.CourseService;

@RestController
public class CourseRestController {
	@Autowired
	private CourseService service;

	@PostMapping("/course")
	public ResponseEntity<String> createCourse(@RequestBody Course course) {
	    String status = service.upsert(course);
	    return new ResponseEntity<>(status, HttpStatus.CREATED);
	}

	@GetMapping("/course/{id}")
	public ResponseEntity<Course> getCourse(@PathVariable Integer id) {
		Course course = service.getById(id);
		return new ResponseEntity<>(course, HttpStatus.OK);
	}

	@GetMapping("/courses")
	public ResponseEntity<List<Course>> getAllCourses() {
		List<Course> list = service.getAllCourses();
		return new ResponseEntity<List<Course>>(list, HttpStatus.OK);
	}

	@PutMapping("/course")
	public ResponseEntity<String> updateCourse(@RequestBody Course course) {
		String status = service.upsert(course);
		return new ResponseEntity<>(status, HttpStatus.OK);
	}

	@DeleteMapping("/course/{id}")
	public ResponseEntity<String> deleteCourse(@PathVariable Integer id) {
		String status = service.deleteById(id);
		return new ResponseEntity<>(status, HttpStatus.OK);
	}

}
