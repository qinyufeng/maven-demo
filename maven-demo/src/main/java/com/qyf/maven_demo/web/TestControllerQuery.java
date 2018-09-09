package com.qyf.maven_demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.qyf.maven_demo.service.TestServiceQuery;
@RestController
public class TestControllerQuery {
	@Autowired
	private TestServiceQuery serviceQuery;
	/***********************使用mybatis方式构造查询条件************************/
	/**单表
	 * @author qyf
	 */
	
	/**多表
	 * @author qyf
	 */
	

}
