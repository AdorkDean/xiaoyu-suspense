package com.xiaoyu.suspense.entity;

import com.xiaoyu.suspense.entity.BaseEntity;

public class BusiSuspenseContent extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	*标识UNID
	*/
	private Integer bssctUnid;

	/**
	*标识UUID
	*/
	private String bssctUuid;

	/**
	*悬疑故事UUID
	*/
	private String bssctStory;

	/**
	*内容
	*/
	private String bssctContent;

	/**
	*排序号
	*/
	private Integer bssctOrd;

	public void setBssctUnid(Integer bssctUnid) {
		this.bssctUnid = bssctUnid;
	}

	public Integer getBssctUnid( ) {
		return bssctUnid;
	}

	public void setBssctUuid(String bssctUuid) {
		this.bssctUuid = bssctUuid;
	}

	public String getBssctUuid( ) {
		return bssctUuid;
	}

	public void setBssctStory(String bssctStory) {
		this.bssctStory = bssctStory;
	}

	public String getBssctStory( ) {
		return bssctStory;
	}

	public void setBssctContent(String bssctContent) {
		this.bssctContent = bssctContent;
	}

	public String getBssctContent( ) {
		return bssctContent;
	}

	public void setBssctOrd(Integer bssctOrd) {
		this.bssctOrd = bssctOrd;
	}

	public Integer getBssctOrd( ) {
		return bssctOrd;
	}

	public BusiSuspenseContent( ) { 
	}

//<=================定制内容开始==============
//==================定制内容结束==============>

}