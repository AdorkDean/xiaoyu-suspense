package com.xiaoyu.suspense.entity;

import com.xiaoyu.suspense.entity.BaseEntity;
import java.util.Date;

public class BusiFollowPost extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	*标识UNID
	*/
	private Integer bsfptUnid;

	/**
	*标识UUID
	*/
	private String bsfptUuid;

	/**
	*发表用户UUID
	*/
	private String bsfptUser;

	/**
	*帖子UUID
	*/
	private String bsfptPost;

	/**
	*发表时间
	*/
	private Date bsfptTime;

	/**
	*跟帖内容
	*/
	private String bsfptContent;

	/**
	*状态:1启用,0禁用
	*/
	private Integer bsfptStatus;

	/**
	*排序号
	*/
	private Integer bsfptOrd;

	public void setBsfptUnid(Integer bsfptUnid) {
		this.bsfptUnid = bsfptUnid;
	}

	public Integer getBsfptUnid( ) {
		return bsfptUnid;
	}

	public void setBsfptUuid(String bsfptUuid) {
		this.bsfptUuid = bsfptUuid;
	}

	public String getBsfptUuid( ) {
		return bsfptUuid;
	}

	public void setBsfptUser(String bsfptUser) {
		this.bsfptUser = bsfptUser;
	}

	public String getBsfptUser( ) {
		return bsfptUser;
	}

	public void setBsfptPost(String bsfptPost) {
		this.bsfptPost = bsfptPost;
	}

	public String getBsfptPost( ) {
		return bsfptPost;
	}

	public void setBsfptTime(Date bsfptTime) {
		this.bsfptTime = bsfptTime;
	}

	public Date getBsfptTime( ) {
		return bsfptTime;
	}

	public void setBsfptContent(String bsfptContent) {
		this.bsfptContent = bsfptContent;
	}

	public String getBsfptContent( ) {
		return bsfptContent;
	}

	public void setBsfptStatus(Integer bsfptStatus) {
		this.bsfptStatus = bsfptStatus;
	}

	public Integer getBsfptStatus( ) {
		return bsfptStatus;
	}

	public void setBsfptOrd(Integer bsfptOrd) {
		this.bsfptOrd = bsfptOrd;
	}

	public Integer getBsfptOrd( ) {
		return bsfptOrd;
	}

	public BusiFollowPost( ) { 
	}

//<=================定制内容开始==============
//==================定制内容结束==============>

}