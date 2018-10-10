package com.qyf.maven_demo.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

public class Course implements Serializable{
    private static final long serialVersionUID = 1L;

	@TableId(value="ID", type= IdType.AUTO)
	private Integer id;
	@TableField("courseCode")
	private String courseCode;
	@TableField("courseName")
	private String courseName;
    /**
     * 创建日期
     */
	@TableField("createDate")
	private Date createDate;
    /**
     * 创建者
     */
	private String creator;
    /**
     * 创建者ID
     */
	@TableField("createId")
	private Integer createId;
    /**
     * 修改时间
     */
	@TableField("modifyDate")
	private Date modifyDate;
    /**
     * 修改者ID
     */
	@TableField("modifiId")
	private Integer modifiId;
    /**
     * 修改者
     */
	private String modifier;

	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}

	public String getCourseCode() {
		return courseCode;
	}


	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}


	public String getCourseName() {
		return courseName;
	}


	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}


	@Override
	public String toString() {
		return "Students [id=" + id + ", createDate=" + createDate + ", creator=" + creator + ", createId="
				+ createId + ", modifyDate=" + modifyDate + ", modifiId=" + modifiId + ", modifier=" + modifier
				+ "]";
	}
}
