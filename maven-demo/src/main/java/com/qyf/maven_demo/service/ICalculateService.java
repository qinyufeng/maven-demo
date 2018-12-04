package com.qyf.maven_demo.service;

import com.baomidou.mybatisplus.service.IService;
import com.qyf.maven_demo.model.Calculate;
import com.qyf.maven_demo.model.Student;

/**
 *   服务类
 * 
 * @author qyf
 * @since 2018-12-04
 */
public interface ICalculateService extends IService<Calculate> {
	Object calculate(Calculate param);
}
