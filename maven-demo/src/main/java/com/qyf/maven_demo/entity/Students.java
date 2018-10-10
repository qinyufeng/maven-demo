package com.qyf.maven_demo.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import java.io.Serializable;

/**
 * <p>
 * 表
 * </p>
 */
public class Students implements Serializable {

    private static final long serialVersionUID = 1L;

	@TableId(value="ID", type= IdType.AUTO)
	private Integer id;
	@TableField("studentCode")
	private String studentCode;
	@TableField("studentName")
	private String studentName;
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


	public String getStudentCode() {
		return studentCode;
	}


	public void setStudentCode(String studentCode) {
		this.studentCode = studentCode;
	}


	public String getStudentName() {
		return studentName;
	}


	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}


	@Override
	public String toString() {
		return "Students [id=" + id + ", createDate=" + createDate + ", creator=" + creator + ", createId="
				+ createId + ", modifyDate=" + modifyDate + ", modifiId=" + modifiId + ", modifier=" + modifier
				+ "]";
	}

}
