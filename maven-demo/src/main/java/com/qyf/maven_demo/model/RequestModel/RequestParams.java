package com.qyf.maven_demo.model.RequestModel;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel()
public class RequestParams implements Serializable{
	private static final long serialVersionUID = 1L;
	@NotBlank(message="名字不能为空")//参数校验判空，适用于字符串
	@ApiModelProperty(value="账号",example="114")
	private String name;
	@NotNull(message="年龄必传")
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
