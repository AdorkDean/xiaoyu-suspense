package com.xiaoyu.suspense.entity;

import com.xiaoyu.suspense.entity.BaseEntity;
import java.util.Date;

public class BusiCollect extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	*标识UNID
	*/
	private Integer bscltUnid;

	/**
	*标识UUID
	*/
	private String bscltUuid;

	/**
	*每日悬疑UUID
	*/
	private String bscltSuspense;

	/**
	*收藏时间
	*/
	private Date bscltTime;

	/**
	*排序号
	*/
	private Integer bscltOrd;

	/**
	*收藏人UUID
	*/
	private String bscltUser;

	public void setBscltUnid(Integer bscltUnid) {
		this.bscltUnid = bscltUnid;
	}

	public Integer getBscltUnid( ) {
		return bscltUnid;
	}

	public void setBscltUuid(String bscltUuid) {
		this.bscltUuid = bscltUuid;
	}

	public String getBscltUuid( ) {
		return bscltUuid;
	}

	public void setBscltSuspense(String bscltSuspense) {
		this.bscltSuspense = bscltSuspense;
	}

	public String getBscltSuspense( ) {
		return bscltSuspense;
	}

	public void setBscltTime(Date bscltTime) {
		this.bscltTime = bscltTime;
	}

	public Date getBscltTime( ) {
		return bscltTime;
	}

	public void setBscltOrd(Integer bscltOrd) {
		this.bscltOrd = bscltOrd;
	}

	public Integer getBscltOrd( ) {
		return bscltOrd;
	}

	public void setBscltUser(String bscltUser) {
		this.bscltUser = bscltUser;
	}

	public String getBscltUser( ) {
		return bscltUser;
	}

	public BusiCollect( ) { 
	}

//<=================定制内容开始==============
//==================定制内容结束==============>

}