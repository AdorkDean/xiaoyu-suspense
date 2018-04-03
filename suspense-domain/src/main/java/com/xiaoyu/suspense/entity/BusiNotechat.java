package com.xiaoyu.suspense.entity;

import com.xiaoyu.suspense.entity.BaseEntity;
import java.util.Date;

public class BusiNotechat extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	*标识UNID
	*/
	private Integer bsnctUnid;

	/**
	*标识UUID
	*/
	private String bsnctUuid;

	/**
	*关注UUID
	*/
	private String bsnctReport;

	/**
	*内容
	*/
	private String bsnctContent;

	/**
	*发送人
	*/
	private String bsnctUser;

	/**
	*类型:1文字,2图片,3语音
	*/
	private Integer bsnctType;

	/**
	*发送时间
	*/
	private Date bsnctSebdTime;

	/**
	*排序号
	*/
	private Integer bsnctOrd;

	public void setBsnctUnid(Integer bsnctUnid) {
		this.bsnctUnid = bsnctUnid;
	}

	public Integer getBsnctUnid( ) {
		return bsnctUnid;
	}

	public void setBsnctUuid(String bsnctUuid) {
		this.bsnctUuid = bsnctUuid;
	}

	public String getBsnctUuid( ) {
		return bsnctUuid;
	}

	public void setBsnctReport(String bsnctReport) {
		this.bsnctReport = bsnctReport;
	}

	public String getBsnctReport( ) {
		return bsnctReport;
	}

	public void setBsnctContent(String bsnctContent) {
		this.bsnctContent = bsnctContent;
	}

	public String getBsnctContent( ) {
		return bsnctContent;
	}

	public void setBsnctUser(String bsnctUser) {
		this.bsnctUser = bsnctUser;
	}

	public String getBsnctUser( ) {
		return bsnctUser;
	}

	public void setBsnctType(Integer bsnctType) {
		this.bsnctType = bsnctType;
	}

	public Integer getBsnctType( ) {
		return bsnctType;
	}

	public void setBsnctSebdTime(Date bsnctSebdTime) {
		this.bsnctSebdTime = bsnctSebdTime;
	}

	public Date getBsnctSebdTime( ) {
		return bsnctSebdTime;
	}

	public void setBsnctOrd(Integer bsnctOrd) {
		this.bsnctOrd = bsnctOrd;
	}

	public Integer getBsnctOrd( ) {
		return bsnctOrd;
	}

	public BusiNotechat( ) { 
	}

//<=================定制内容开始==============
//==================定制内容结束==============>

}