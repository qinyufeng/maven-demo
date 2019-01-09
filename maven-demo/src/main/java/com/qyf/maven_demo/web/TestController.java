package com.qyf.maven_demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qyf.maven_demo.service.TestService;

/**
 * <p>
 *  前端控制器
 * </p>
 * @author qyf
 * @since 2018-10-16
 */
@RestController
@RequestMapping("/test")
public class TestController {
	@Autowired
	private TestService service;
	/**
	 * rabbitMq 消息发送
	 */
	@PostMapping("/mqTest")
	private void mqTest(@RequestBody String message){
		service.mqTest(message);
	}

}
