package com.qyf.maven_demo.model;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author qyf
 * @since 2018-10-16
 */
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
	@TableField("stuId")
	private String stuId;
	@TableField("stuClass")
	private String stuClass;
	private String name;
	private Integer age;
	private String phone;
	private String qq;
	private String wechat;
	private String address;
	private Double height;
	private Double weight;
	private String father;
	private String mother;


	public Integer getId() {
		return id;
	}

	public Student setId(Integer id) {
		this.id = id;
		return this;
	}

	public String getStuId() {
		return stuId;
	}

	public Student setStuId(String stuId) {
		this.stuId = stuId;
		return this;
	}

	public String getStuClass() {
		return stuClass;
	}

	public Student setStuClass(String stuClass) {
		this.stuClass = stuClass;
		return this;
	}

	public String getName() {
		return name;
	}

	public Student setName(String name) {
		this.name = name;
		return this;
	}

	public Integer getAge() {
		return age;
	}

	public Student setAge(Integer age) {
		this.age = age;
		return this;
	}

	public String getPhone() {
		return phone;
	}

	public Student setPhone(String phone) {
		this.phone = phone;
		return this;
	}

	public String getQq() {
		return qq;
	}

	public Student setQq(String qq) {
		this.qq = qq;
		return this;
	}

	public String getWechat() {
		return wechat;
	}

	public Student setWechat(String wechat) {
		this.wechat = wechat;
		return this;
	}

	public String getAddress() {
		return address;
	}

	public Student setAddress(String address) {
		this.address = address;
		return this;
	}

	public Double getHeight() {
		return height;
	}

	public Student setHeight(Double height) {
		this.height = height;
		return this;
	}

	public Double getWeight() {
		return weight;
	}

	public Student setWeight(Double weight) {
		this.weight = weight;
		return this;
	}

	public String getFather() {
		return father;
	}

	public Student setFather(String father) {
		this.father = father;
		return this;
	}

	public String getMother() {
		return mother;
	}

	public Student setMother(String mother) {
		this.mother = mother;
		return this;
	}

	@Override
	public String toString() {
		return "Student{" +
			", id=" + id +
			", stuId=" + stuId +
			", stuClass=" + stuClass +
			", name=" + name +
			", age=" + age +
			", phone=" + phone +
			", qq=" + qq +
			", wechat=" + wechat +
			", address=" + address +
			", height=" + height +
			", weight=" + weight +
			", father=" + father +
			", mother=" + mother +
			"}";
	}
}
