package com.qyf.maven_demo.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
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
import com.qyf.maven_demo.entity.Params;
import com.qyf.maven_demo.entity.StudentValidate;
import com.qyf.maven_demo.model.Parameters;
import com.qyf.maven_demo.model.Student;
import com.qyf.maven_demo.service.StudentService;

import io.swagger.annotations.ApiParam;

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
	private List<Student> selectList(@PathVariable @ApiParam(value="查询参数",defaultValue="{\"name\":\"qinyufeng\"}") String data){
		Student stuParam=JSON.parseObject(data, Student.class);
		Wrapper<Student> wrapper=new EntityWrapper<>();
		wrapper.like("name", stuParam.getName());
		List<Student> stuList=service.selectList(wrapper);
		return stuList;
	}
	/**
	 * 常用 查询(分页、不分页等）
	 */
	@GetMapping("/getlistTest/{data}")
	private List<Student> selectListTest(@PathVariable String data){
		Parameters params = JSON.parseObject(data, Parameters.class);
		if(ObjectUtils.isEmpty(params))
			params = Parameters.DEFAULT;
		List<Student> stuList=service.selectListTest(params);
		return stuList;
	}
	/************************ 参数校验 *************************************/
	
	/**
	 * Java参数校验工具 @valid 效验 
	 */
	@PostMapping("/valid")
	private StudentValidate valid(@RequestBody @Valid StudentValidate param) {
		return param;
	}
	/**
	 * 自定义注解校验
	 */
	@PostMapping("/customerValid")
	private StudentValidate customerValid(@RequestBody @Valid StudentValidate param) {
		return param;
	}
	/**
	 * 手动校验参数
	 * @throws Exception
	 */
	@PostMapping("/selfValid")
	private StudentValidate selfValid(@RequestBody StudentValidate param) throws Exception{
		StringBuffer msg=new StringBuffer();
		if(ObjectUtils.isEmpty(param.getName())) {
			msg.append("参数姓名不能为空,");
		}
		if(ObjectUtils.isEmpty(param.getCreator())) {
			msg.append("参数创建人不能为空,");
		}
		if(msg.length()>0) {
			throw new Exception(msg.substring(0, msg.length()-1));
		}
		return param;
	}
	/************************ java8新特性的运用demo *************************************/
	/**
	 * @author qyf
     * @since 2018-11-01
	 */
	@PostMapping("/javaEight")
	private Object javaEight(@RequestBody Student param){
		List<Student> list=new ArrayList<>();
		//给每条记录拼上创建人和创建人id字段
		String name="qinyufeng";
		int creatorId=111;
		List<Student> list2=list.stream().map((item ->item.setCreator(name))).collect(Collectors.toList());
		List<Student> list3=list2.stream().map((item ->item.setCreatorId(creatorId))).collect(Collectors.toList());
		return service.javaEight(param);
	}
	
	/************************ 通用的增删改查 ，可以通过所传的参数来控制结果 *************************************/
	/*
	 * 新增插入
	 */
	@PostMapping("/insertCommon")   
	private Object insertCommon(@RequestBody Map<String,Object> params){
		return service.insertCommon(params);
	}
	/*
	 * 修改更新
	 */
	@PostMapping("/updateCommon")   
	private Object updateCommon(@RequestBody Map<String,Object> params){
		return service.updateCommon(params);
	}
	/*
	 * 查询
	 */
	@PostMapping("/selectCommon")   
	private Object selectCommon(@RequestBody Map<String,Object> params){
		return service.selectCommon(params);
	}
	/************************ sql查询中的字符串排序 *************************************/
	@GetMapping("/StrSortSql")
	private List<Student> StrSortSql(@RequestBody Map<String,Object> params){
		return service.StrSortSql(params);
	}
	/************************多种循环方式对比 *************************************/
	@PostMapping("/cycle")   
	private Object cycle(){
		service.cycle();
		return null;
	}
	/************************ xml sql语句    *************************************/
	@GetMapping("/mapperXmlTest")
	private List<Student> mapperXmlTest(){
		Params param=new Params();
		return service.mapperXmlTest(param);
	}
	/************************ test    *************************************/
	@PostMapping("/test")   
	private void test(){
		service.test();
	}
}
