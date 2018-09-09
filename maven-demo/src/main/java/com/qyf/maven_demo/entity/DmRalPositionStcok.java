package com.qyf.maven_demo.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.math.BigDecimal;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import java.io.Serializable;

/**
 * <p>
 * 位置库存表
 * </p>
 */
public class DmRalPositionStcok implements Serializable {

    private static final long serialVersionUID = 1L;

	@TableId(value="ID", type= IdType.AUTO)
	private Integer id;
	@TableField("matCode")
	private String matCode;
	@TableField("posCode")
	private String posCode;
	@TableField("stockDate")
	private Date stockDate;
	private BigDecimal stock;
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
	@TableField("batch")
	private String batch;
	@TableField("repUnit")
	private String repUnit;
	@TableField(exist=false)
	private String matName;
	@TableField(exist=false)
	private String posName;
	@TableField(exist=false)
	private String adrName;
	@TableField(exist=false)
	private String detUnit;

	public Integer getId() {
		return id;
	}

	public DmRalPositionStcok setId(Integer id) {
		this.id = id;
		return this;
	}

	public String getMatCode() {
		return matCode;
	}

	public DmRalPositionStcok setMatCode(String matCode) {
		this.matCode = matCode;
		return this;
	}

	public String getPosCode() {
		return posCode;
	}

	public DmRalPositionStcok setPosCode(String posCode) {
		this.posCode = posCode;
		return this;
	}

	public Date getStockDate() {
		return stockDate;
	}

	public DmRalPositionStcok setStockDate(Date stockDate) {
		this.stockDate = stockDate;
		return this;
	}

	public BigDecimal getStock() {
		return stock;
	}

	public DmRalPositionStcok setStock(BigDecimal stock) {
		this.stock = stock;
		return this;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public DmRalPositionStcok setCreateDate(Date createDate) {
		this.createDate = createDate;
		return this;
	}

	public String getCreator() {
		return creator;
	}

	public DmRalPositionStcok setCreator(String creator) {
		this.creator = creator;
		return this;
	}

	public Integer getCreateId() {
		return createId;
	}

	public DmRalPositionStcok setCreateId(Integer createId) {
		this.createId = createId;
		return this;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public DmRalPositionStcok setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
		return this;
	}

	public Integer getModifiId() {
		return modifiId;
	}

	public DmRalPositionStcok setModifiId(Integer modifiId) {
		this.modifiId = modifiId;
		return this;
	}

	public String getModifier() {
		return modifier;
	}

	public DmRalPositionStcok setModifier(String modifier) {
		this.modifier = modifier;
		return this;
	}

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	public String getRepUnit() {
		return repUnit;
	}

	public void setRepUnit(String repUnit) {
		this.repUnit = repUnit;
	}
	
	public String getMatName() {
		return matName;
	}

	public void setMatName(String matName) {
		this.matName = matName;
	}

	public String getPosName() {
		return posName;
	}

	public void setPosName(String posName) {
		this.posName = posName;
	}

	public String getAdrName() {
		return adrName;
	}

	public void setAdrName(String adrName) {
		this.adrName = adrName;
	}

	public String getDetUnit() {
		return detUnit;
	}

	public void setDetUnit(String detUnit) {
		this.detUnit = detUnit;
	}

	@Override
	public String toString() {
		return "DmRalPositionStcok [id=" + id + ", matCode=" + matCode + ", posCode=" + posCode + ", stockDate="
				+ stockDate + ", stock=" + stock + ", createDate=" + createDate + ", creator=" + creator + ", createId="
				+ createId + ", modifyDate=" + modifyDate + ", modifiId=" + modifiId + ", modifier=" + modifier
				+ ", batch=" + batch + ", repUnit=" + repUnit + ", matName=" + matName + ", posName=" + posName
				+ ", adrName=" + adrName + ", detUnit=" + detUnit + "]";
	}

}
