package com.qyf.maven_demo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotations.*;
import com.fasterxml.jackson.annotation.*;

/**
 *   实体类
 *
 * @author qyf
 * @since 2018-12-04
 */
@TableName("calculate")
public class Calculate implements Serializable {

	private static final long serialVersionUID = 1L;

    @TableField("id")
	@JsonProperty("id")
	private Integer id;
    
    @TableField("NO")
	@JsonProperty("NO")
	private String NO;
    @TableField("price")
	@JsonProperty("price")
	private BigDecimal price;
	
    @TableField("calNum")
	@JsonProperty("calNum")
	private BigDecimal calNum;
	
    @TableField("nums")
	@JsonProperty("nums")
	private BigDecimal nums;
	
    @TableField("doubB")
	@JsonProperty("doubB")
	private Double doubB;
	
    @TableField("doubA")
	@JsonProperty("doubA")
	private Double doubA;
	
    @TableField("doubC")
	@JsonProperty("doubC")
	private Double doubC;
	
    @TableField("floatA")
	@JsonProperty("floatA")
	private Float floatA;
	
    @TableField("floatB")
	@JsonProperty("floatB")
	private Float floatB;
	
    @TableField("floatC")
	@JsonProperty("floatC")
	private Float floatC;
	
	@JsonIgnore
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	@JsonIgnore
	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	@JsonIgnore
	public BigDecimal getCalNum() {
		return calNum;
	}

	public void setCalNum(BigDecimal calNum) {
		this.calNum = calNum;
	}
	
	@JsonIgnore
	public BigDecimal getNums() {
		return nums;
	}

	public void setNums(BigDecimal nums) {
		this.nums = nums;
	}
	
	@JsonIgnore
	public Double getDoubB() {
		return doubB;
	}

	public void setDoubB(Double doubB) {
		this.doubB = doubB;
	}
	
	@JsonIgnore
	public Double getDoubA() {
		return doubA;
	}

	public void setDoubA(Double doubA) {
		this.doubA = doubA;
	}
	
	@JsonIgnore
	public Double getDoubC() {
		return doubC;
	}

	public void setDoubC(Double doubC) {
		this.doubC = doubC;
	}
	
	@JsonIgnore
	public Float getFloatA() {
		return floatA;
	}

	public void setFloatA(Float floatA) {
		this.floatA = floatA;
	}
	
	@JsonIgnore
	public Float getFloatB() {
		return floatB;
	}

	public void setFloatB(Float floatB) {
		this.floatB = floatB;
	}
	
	@JsonIgnore
	public Float getFloatC() {
		return floatC;
	}

	public void setFloatC(Float floatC) {
		this.floatC = floatC;
	}

	public String getNO() {
		return NO;
	}

	public void setNO(String nO) {
		NO = nO;
	}

}
