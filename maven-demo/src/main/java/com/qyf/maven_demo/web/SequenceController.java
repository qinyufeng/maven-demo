package com.qyf.maven_demo.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;

import com.qyf.maven_demo.service.ISequenceService;

/**
 *   控制器
 *
 * @author qyf
 * @since 2018-12-05
 */
@RestController
@RequestMapping("/sequence")
@Api(value = "接口", description = "接口")
public class SequenceController {

	@Autowired
	private ISequenceService service;
	
	
}