package com.qyf.maven_demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qyf.maven_demo.model.Student;
import com.qyf.maven_demo.service.StudentService;

/**
 * <p>
 *  前端控制器
 * </p>
 * @author qyf
 * @since 2018-10-16
 */
@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentService service;
	
	@PostMapping
	private Student insert(Student stu) {
		service.insert(stu);
		return stu;
	}
	@PutMapping
	private Student modify(Student stu) {
		service.updateById(stu);
		return stu;
	}
	@GetMapping
	private Student selectById(int id) {
		return service.selectById(id);
	}
	@DeleteMapping
	private boolean delete(int id) {
		return service.deleteById(id);
	}
}
