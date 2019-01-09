package com.qyf.maven_demo.serviceImpl;

import org.springframework.stereotype.Service;

import com.qyf.maven_demo.service.TestService;
import com.qyf.maven_demo.tests.RabbitMqTest;

@Service()
public class TestServiceImpl implements TestService{

	@Override
	public void mqTest(String message) {
		RabbitMqTest mq=new RabbitMqTest();
		//发送消息
		//mq.sendMsgToMq("topic.queue1", message);
		//接收消息
		mq.receiveMessage1(message);
	}

}
