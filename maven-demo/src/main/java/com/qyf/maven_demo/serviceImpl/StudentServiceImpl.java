package com.qyf.maven_demo.serviceImpl;

import com.qyf.maven_demo.model.Student;
import com.qyf.maven_demo.mapper.StudentMapper;
import com.qyf.maven_demo.service.StudentService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author qyf
 * @since 2018-10-16
 */
@Component
@Service()
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {
	@Autowired
	private StudentMapper mapper;
}
