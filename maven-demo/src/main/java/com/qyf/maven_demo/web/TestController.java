package com.qyf.maven_demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qyf.maven_demo.service.TestService;

@RestController
@RequestMapping("test")
public class TestController {
	@Autowired
	private TestService serviceTest;
	
}
