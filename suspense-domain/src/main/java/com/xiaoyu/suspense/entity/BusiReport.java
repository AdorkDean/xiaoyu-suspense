package com.xiaoyu.suspense.entity;

import com.xiaoyu.suspense.entity.BaseEntity;
import java.util.Date;

public class BusiReport extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	*标识UNID
	*/
	private Integer bsrptUnid;

	/**
	*标识UUID
	*/
	private String bsrptUuid;

	/**
	*关注人UUID
	*/
	private String bsrptAttention;

	/**
	*被关注人UUID
	*/
	private String bsrptBeAttention;

	/**
	*创建日期
	*/
	private Date bsrptCdate;

	/**
	*排序号
	*/
	private Integer bsrptOrd;

	public void setBsrptUnid(Integer bsrptUnid) {
		this.bsrptUnid = bsrptUnid;
	}

	public Integer getBsrptUnid( ) {
		return bsrptUnid;
	}

	public void setBsrptUuid(String bsrptUuid) {
		this.bsrptUuid = bsrptUuid;
	}

	public String getBsrptUuid( ) {
		return bsrptUuid;
	}

	public void setBsrptAttention(String bsrptAttention) {
		this.bsrptAttention = bsrptAttention;
	}

	public String getBsrptAttention( ) {
		return bsrptAttention;
	}

	public void setBsrptBeAttention(String bsrptBeAttention) {
		this.bsrptBeAttention = bsrptBeAttention;
	}

	public String getBsrptBeAttention( ) {
		return bsrptBeAttention;
	}

	public void setBsrptCdate(Date bsrptCdate) {
		this.bsrptCdate = bsrptCdate;
	}

	public Date getBsrptCdate( ) {
		return bsrptCdate;
	}

	public void setBsrptOrd(Integer bsrptOrd) {
		this.bsrptOrd = bsrptOrd;
	}

	public Integer getBsrptOrd( ) {
		return bsrptOrd;
	}

	public BusiReport( ) { 
	}

//<=================定制内容开始==============
//==================定制内容结束==============>

}