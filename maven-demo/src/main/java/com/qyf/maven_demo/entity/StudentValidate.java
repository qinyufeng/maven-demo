package com.qyf.maven_demo.entity;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author qyf
 * @since 2018-10-31
 */
public class StudentValidate implements Serializable {

    private static final long serialVersionUID = 1L;
    @NotEmpty(message="学号不能为空")
	private String stuId;
    
    @NotEmpty(message="姓名不能为空")
	private String name;
    
    @NotEmpty(message="phone不能为空")
	private String phone;
    
	@NotEmpty(message="creator不能为空")
	private String creator;
	
	@NotNull(message = "年龄不能为空！")
	@Max(value = 100, message = "年龄不能大于100岁！")
	private Integer age;
	
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getStuId() {
		return stuId;
	}
	public void setStuId(String stuId) {
		this.stuId = stuId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}

	
}
