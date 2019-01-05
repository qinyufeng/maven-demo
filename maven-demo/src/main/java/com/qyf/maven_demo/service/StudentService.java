package com.qyf.maven_demo.service;

import com.qyf.maven_demo.entity.Params;
import com.qyf.maven_demo.model.Parameters;
import com.qyf.maven_demo.model.Student;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author qyf
 * @since 2018-10-16
 */
public interface StudentService extends IService<Student> {
	Object javaEight(Student param);
	void myTask();
	Object insertCommon(Map<String,Object> params);
	Object updateCommon(Map<String,Object> params);
	Object selectCommon(Map<String,Object> params);
	List<Student> StrSortSql(Map<String,Object> params);
	void cycle();
	List<Student> mapperXmlTest(Params params);
	void test();
	List<Student> selectListTest(Parameters param);
}
