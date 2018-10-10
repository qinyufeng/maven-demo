package com.qyf.maven_demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qyf.maven_demo.service.TestServiceDelete;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/TestDelete")
@Api(value = "测试", description = "test")
public class TestControllerDelete {
	@Autowired
	private TestServiceDelete serviceDelete;
	@DeleteMapping
	@ApiOperation(value = "test")
	public Object del(@RequestParam(required=true) String id) {
		serviceDelete.deleteById(id);
		return "删除成功";
	}
	
}
