package com.qyf.maven_demo.service;

import com.qyf.maven_demo.model.Student;

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
}
