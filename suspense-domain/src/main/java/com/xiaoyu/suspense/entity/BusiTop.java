package com.xiaoyu.suspense.entity;

import com.xiaoyu.suspense.entity.BaseEntity;
import com.xiaoyu.suspense.enums.BusiType;

import java.util.Date;

public class BusiTop extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	*标识UNID
	*/
	private Integer bstopUnid;

	/**
	*标识UUID
	*/
	private String bstopUuid;

	/**
	*业务UUID
	*/
	private String bstopBusi;

	/**
	*业务类型
	*/
	private BusiType bstopBusiType;

	/**
	*顶时间
	*/
	private Date bstopTime;

	/**
	*排序号
	*/
	private Integer bstopOrd;

	/**
	*用户人UUID
	*/
	private String bstopUser;

	public void setBstopUnid(Integer bstopUnid) {
		this.bstopUnid = bstopUnid;
	}

	public Integer getBstopUnid( ) {
		return bstopUnid;
	}

	public void setBstopUuid(String bstopUuid) {
		this.bstopUuid = bstopUuid;
	}

	public String getBstopUuid( ) {
		return bstopUuid;
	}

	public void setBstopBusi(String bstopBusi) {
		this.bstopBusi = bstopBusi;
	}

	public String getBstopBusi( ) {
		return bstopBusi;
	}

	public void setBstopBusiType(BusiType bstopBusiType) {
		this.bstopBusiType = bstopBusiType;
	}

	public BusiType getBstopBusiType( ) {
		return bstopBusiType;
	}

	public void setBstopTime(Date bstopTime) {
		this.bstopTime = bstopTime;
	}

	public Date getBstopTime( ) {
		return bstopTime;
	}

	public void setBstopOrd(Integer bstopOrd) {
		this.bstopOrd = bstopOrd;
	}

	public Integer getBstopOrd( ) {
		return bstopOrd;
	}

	public void setBstopUser(String bstopUser) {
		this.bstopUser = bstopUser;
	}

	public String getBstopUser( ) {
		return bstopUser;
	}

	public BusiTop( ) { 
	}

//<=================定制内容开始==============
//==================定制内容结束==============>

}