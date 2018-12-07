package com.qyf.maven_demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import io.swagger.annotations.Api;

import com.qyf.maven_demo.model.Calculate;
import com.qyf.maven_demo.service.ICalculateService;

/**
 *   控制器
 *
 * @author qyf
 * @since 2018-12-04
 */
@RestController
@RequestMapping("/calculate")
@Api(value = "接口", description = "接口")
public class CalculateController {

	@Autowired
	private ICalculateService service;
	/************************ 常用的计算 及注意事项*************************************/
	@PostMapping("/calculate")
	private Object calculate(@RequestBody Calculate param){
		return service.calculate(param);
	}
	/************************ 常用的计算 使用Java8 的strea计算*************************************/
	@PostMapping("/calculateByStream")
	private Object calculateByStream(@RequestBody Calculate param){
		return service.calculateByStream(param);
	}
}