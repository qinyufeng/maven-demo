package com.qyf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.qyf.maven_demo")
//@MapperScan({"com.qyf.maven_demo.utils.base","com.qyf.maven_demo.mapper"})//扫描多个包
@MapperScan("com.qyf.maven_demo.mapper")//扫描单个包
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
