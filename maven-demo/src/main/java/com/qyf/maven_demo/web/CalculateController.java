package com.qyf.maven_demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import io.swagger.annotations.Api;

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
	
}