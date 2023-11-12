package com.postgresql.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.postgresql.entity.Course;
import com.postgresql.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {
	@Autowired
	private CourseRepository repo;

	@Override
	public String upsert(Course course) {
		repo.save(course);// based on PK it will insert and update the record
		return "success";
	}

	@Override
	public Course getById(Integer id) {
		Optional<Course> findById = repo.findById(id);
		if (findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	@Override
	public List<Course> getAllCourses() {
		return repo.findAll();
	}

	@Override
	public String deleteById(Integer id) {
		if (repo.existsById(id)) {
			repo.deleteById(id);
			return "Delete Success";
		} else {
			return "No Record Found!";
		}

	}

}
