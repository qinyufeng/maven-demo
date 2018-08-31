package com.qyf.maven_demo.model;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

public class RespModel implements Serializable{
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value="账号",example="114")
	private String name;
	@ApiModelProperty(value="年龄",example="22")
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

}
