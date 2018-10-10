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
public class Teachers implements Serializable {

    private static final long serialVersionUID = 1L;

	@TableId(value="ID", type= IdType.AUTO)
	private Integer id;
	@TableField("teacherCode")
	private String teacherCode;
	@TableField("teacherName")
	private String teacherName;
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



	public String getTeacherCode() {
		return teacherCode;
	}


	public void setTeacherCode(String teacherCode) {
		this.teacherCode = teacherCode;
	}


	public String getTeacherName() {
		return teacherName;
	}


	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	@Override
	public String toString() {
		return "Students [id=" + id + ", createDate=" + createDate + ", creator=" + creator + ", createId="
				+ createId + ", modifyDate=" + modifyDate + ", modifiId=" + modifiId + ", modifier=" + modifier
				+ "]";
	}

}
