package com.qyf.maven_demo.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.qyf.maven_demo.entity.StudentValidate;
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
	/************************* 单表 常用的基本的增删改查 ***************************/
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
	/************************ 批量增删改查 *************************************/
	/**
	 * 批量插入
	 */
	@PostMapping("/insertList")
	private List<Student> insertList(@RequestBody List<Student> paramList){
		service.insertBatch(paramList);
		return paramList;
	}
	/**
	 * 批量插入更新，存在就更新，不存在就插入
	 */
	@PostMapping("insertOrUpdateList")
	private List<Student> insertOrUpdateList(@RequestBody List<Student> paramList){
		service.insertOrUpdateBatch(paramList);
		return paramList;
	}
	/**
	 * 批量更新
	 */
	@PutMapping("updateList")
	private List<Student> updateList(@RequestBody List<Student> paramList){
		service.updateBatchById(paramList);
		return paramList;
	}
	/**
	 * 查询
	 */
	@GetMapping("/getlist/{data}")
	private List<Student> selectList(@PathVariable String data){
		Student stuParam=JSON.parseObject(data, Student.class);
		Wrapper<Student> wrapper=new EntityWrapper<>();
		wrapper.like("name", stuParam.getName());
		List<Student> stuList=service.selectList(wrapper);
		return stuList;
	}
	
	
	/************************ 参数校验 *************************************/
	
	/**
	 * Java参数校验工具 @valid 效验 
	 */
	@PostMapping("/insertValidate")
	private StudentValidate insertValidate(@RequestBody @Valid StudentValidate param) {
		return param;
	}
	/**
	 * 自定义注解校验
	 */
	@PostMapping("/customerValid")
	private StudentValidate test(@RequestBody @Valid StudentValidate param) {
		return param;
	}
	
}
