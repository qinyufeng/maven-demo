package com.qyf.maven_demo.serviceImpl;

import org.springframework.stereotype.Service;

import com.qyf.maven_demo.service.TestService;

@Service
public class TestServiceImpl implements TestService{

	@Override
	public void test() {
		System.out.println("hello");
	
	}

}
