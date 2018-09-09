package com.qyf.maven_demo.model.RequestModel;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value="RequestMaterialStock",description="请求参数")
public class RequestMaterialStock implements Serializable{
	private static final long serialVersionUID = 1L;
    /**
     * 仓位类型
     */
	@JsonProperty("WHTCode")
	@ApiModelProperty(value="仓位类型",example = "101")
    private String WHTCode;
	
    /**
     * 仓位编码
     */
	@JsonProperty("WHCode")
	@ApiModelProperty(value="仓位编码",example = "")
    private String WHCode;
    /**
     * 物料编码
     */
	@ApiModelProperty(value="物料编码",example = "8030050161")
    private String[] matCode;
    /**
     * 物料描述
     */
	@ApiModelProperty(value="物料描述",example = "PVC不弯电线管(C管)蓝色 dn20 3M")
    private String matName;
	
    /**
     * 当前页
     */
	@ApiModelProperty(value="当前页",example = "1")
    private int current;
	
    /**
     * 每页显示条数
     */
	@ApiModelProperty(value="每页显示条数",example = "10")
    private int size;
	
	/********************************************************************************************/
    /**
     * 仓位类型
     */
	@JsonIgnore
	public void setWHTCode(String wHTCode) {
		WHTCode = wHTCode;
	}
    /**
     * 仓位类型
     */
	@JsonIgnore
	public String getWHTCode() {
		return WHTCode;
	}
    /**
     * 物料编码
     */
    public String[] getMatCode() {
		return matCode;
	}
    /**
     * 物料编码
     */
	public void setMatCode(String[] matCode) {
		this.matCode = matCode;
	}
    /**
     * 物料描述
     */
	public String getMatName() {
		return matName;
	}

	/**
     * 物料描述
     */
	public void setMatName(String matName) {
		this.matName = matName;
	}
    /**
     * 当前页
     */
	public int getCurrent() {
		return current;
	}
    /**
     * 当前页
     */
	public void setCurrent(int current) {
		this.current = current;
	}
    /**
     * 每页显示条数
     */
	public int getSize() {
		return size;
	}
    /**
     * 每页显示条数
     */
	public void setSize(int size) {
		this.size = size;
	}
    /**
     * 仓位编码
     */
	@JsonIgnore
	public String getWHCode() {
		return WHCode;
	}
    /**
     * 仓位编码
     */
	@JsonIgnore
	public void setWHCode(String wHCode) {
		WHCode = wHCode;
	}	
	
}
