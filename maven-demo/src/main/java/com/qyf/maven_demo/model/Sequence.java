package com.qyf.maven_demo.model;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotations.*;
import com.fasterxml.jackson.annotation.*;

/**
 *   实体类
 *
 * @author qyf
 * @since 2018-12-05
 */
@TableName("sequence")
public class Sequence implements Serializable {

	private static final long serialVersionUID = 1L;

    @TableField("name")
	@JsonProperty("name")
	private String name;
	
    @TableField("seqType")
	@JsonProperty("seqType")
	private Integer seqType;
	
    @TableField("prefix")
	@JsonProperty("prefix")
	private String prefix;
	
    @TableField("digits")
	@JsonProperty("digits")
	private int digits;
	
    @TableField("num")
	@JsonProperty("num")
	private Integer num;
	
    @TableField("currenDate")
	@JsonProperty("currenDate")
	private String currenDate;
	
	@JsonIgnore
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@JsonIgnore
	public Integer getSeqType() {
		return seqType;
	}

	public void setSeqType(Integer seqType) {
		this.seqType = seqType;
	}
	
	@JsonIgnore
	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	
	public int getDigits() {
		return digits;
	}

	public void setDigits(int digits) {
		this.digits = digits;
	}

	@JsonIgnore
	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}
	
	@JsonIgnore
	public String getCurrenDate() {
		return currenDate;
	}

	public void setCurrenDate(String value) {
		this.currenDate = value;
	}
	

}
