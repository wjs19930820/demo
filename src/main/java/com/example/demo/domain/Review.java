package com.example.demo.domain;


import java.util.Date;

/**
 * 的Domain
 * 
 * @author zsp
 * @date 2018-5-15
 */
public class Review {
	
	/**
	 * 盘点单ID
	 */
	private Long reviewId;
	/**
	 * 盘点单编码
	 */
	private String reviewCode;
	/**
	 * 盘点方式: 1-按库位，2-按sku
	 */
	private Integer reviewType;
	/**
	 * 仓库ID
	 */
	private Long warehouseId;
	/**
	 * 状态: 100-待盘点、200-盘点中、300-待确认、400-已完成、500-已取消
	 */
	private Integer status;
	/**
	 * 备注
	 */
	private String memo;
	/**
	 * 创建人ID
	 */
	private Long createUserId;
	/**
	 * 创建人姓名
	 */
	private String createUserName;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 完成人ID（取消或确认盘点）
	 */
	private Long completeUserId;
	/**
	 * 完成人姓名（取消或确认盘点）
	 */
	private String completeUserName;
	/**
	 * 完成时间（取消或确认盘点）
	 */
	private Date completeTime;
	/**
	 * 是否有差异：0-无，1-有
	 */
	private Boolean isDifference;
	/**
	 * 是否删除：0-否，1-是
	 */
	private Boolean isDeleted;

	/**
	 * 设置盘点单ID
	 */
	public void setReviewId(Long value) {
		this.reviewId = value;
	}
	/**
	 * 获取盘点单ID
	 */
	public Long getReviewId() {
		return this.reviewId;
	}
	/**
	 * 设置盘点单编码
	 */
	public void setReviewCode(String value) {
		this.reviewCode = value;
	}
	/**
	 * 获取盘点单编码
	 */
	public String getReviewCode() {
		return this.reviewCode;
	}
	/**
	 * 设置盘点方式: 1-按库位，2-按sku
	 */
	public void setReviewType(Integer value) {
		this.reviewType = value;
	}
	/**
	 * 获取盘点方式: 1-按库位，2-按sku
	 */
	public Integer getReviewType() {
		return this.reviewType;
	}
	/**
	 * 设置仓库ID
	 */
	public void setWarehouseId(Long value) {
		this.warehouseId = value;
	}
	/**
	 * 获取仓库ID
	 */
	public Long getWarehouseId() {
		return this.warehouseId;
	}
	/**
	 * 设置状态: 100-待盘点、200-盘点中、300-待确认、400-已完成、500-已取消
	 */
	public void setStatus(Integer value) {
		this.status = value;
	}
	/**
	 * 获取状态: 100-待盘点、200-盘点中、300-待确认、400-已完成、500-已取消
	 */
	public Integer getStatus() {
		return this.status;
	}
	/**
	 * 设置备注
	 */
	public void setMemo(String value) {
		this.memo = value;
	}
	/**
	 * 获取备注
	 */
	public String getMemo() {
		return this.memo;
	}
	/**
	 * 设置创建人ID
	 */
	public void setCreateUserId(Long value) {
		this.createUserId = value;
	}
	/**
	 * 获取创建人ID
	 */
	public Long getCreateUserId() {
		return this.createUserId;
	}
	/**
	 * 设置创建人姓名
	 */
	public void setCreateUserName(String value) {
		this.createUserName = value;
	}
	/**
	 * 获取创建人姓名
	 */
	public String getCreateUserName() {
		return this.createUserName;
	}
	/**
	 * 设置创建时间
	 */
	public void setCreateTime(Date value) {
		this.createTime = value;
	}
	/**
	 * 获取创建时间
	 */
	public Date getCreateTime() {
		return this.createTime;
	}
	/**
	 * 设置完成人ID（取消或确认盘点）
	 */
	public void setCompleteUserId(Long value) {
		this.completeUserId = value;
	}
	/**
	 * 获取完成人ID（取消或确认盘点）
	 */
	public Long getCompleteUserId() {
		return this.completeUserId;
	}
	/**
	 * 设置完成人姓名（取消或确认盘点）
	 */
	public void setCompleteUserName(String value) {
		this.completeUserName = value;
	}
	/**
	 * 获取完成人姓名（取消或确认盘点）
	 */
	public String getCompleteUserName() {
		return this.completeUserName;
	}
	/**
	 * 设置完成时间（取消或确认盘点）
	 */
	public void setCompleteTime(Date value) {
		this.completeTime = value;
	}
	/**
	 * 获取完成时间（取消或确认盘点）
	 */
	public Date getCompleteTime() {
		return this.completeTime;
	}
	/**
	 * 设置是否有差异：0-无，1-有
	 */
	public void setIsDifference(Boolean value) {
		this.isDifference = value;
	}
	/**
	 * 获取是否有差异：0-无，1-有
	 */
	public Boolean getIsDifference() {
		return this.isDifference;
	}
	/**
	 * 设置是否删除：0-否，1-是
	 */
	public void setIsDeleted(Boolean value) {
		this.isDeleted = value;
	}
	/**
	 * 获取是否删除：0-否，1-是
	 */
	public Boolean getIsDeleted() {
		return this.isDeleted;
	}

}

