package com.xiaoyu.suspense.entity;

import com.xiaoyu.suspense.entity.BaseEntity;

public class BusiSuspenseDay extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	*标识UNID
	*/
	private Integer bssdyUnid;

	/**
	*标识UUID
	*/
	private String bssdyUuid;

	/**
	*悬疑内容
	*/
	private String bssdyContent;

	/**
	*积分
	*/
	private Integer bssdyScore;
	
	/**
	*发布时间(年-月-日)
	*/
	private String bssdyDay;

	/**
	*答案
	*/
	private String bssdyResult;

	/**
	*状态:1启用,0禁用
	*/
	private Integer bssdyStatus;

	/**
	*排序号
	*/
	private Integer bssdyOrd;

	public void setBssdyUnid(Integer bssdyUnid) {
		this.bssdyUnid = bssdyUnid;
	}

	public Integer getBssdyUnid( ) {
		return bssdyUnid;
	}

	public void setBssdyUuid(String bssdyUuid) {
		this.bssdyUuid = bssdyUuid;
	}

	public String getBssdyUuid( ) {
		return bssdyUuid;
	}

	public void setBssdyContent(String bssdyContent) {
		this.bssdyContent = bssdyContent;
	}

	public String getBssdyContent( ) {
		return bssdyContent;
	}

	public Integer getBssdyScore() {
		return bssdyScore;
	}

	public void setBssdyScore(Integer bssdyScore) {
		this.bssdyScore = bssdyScore;
	}

	public void setBssdyDay(String bssdyDay) {
		this.bssdyDay = bssdyDay;
	}

	public String getBssdyDay( ) {
		return bssdyDay;
	}

	public void setBssdyResult(String bssdyResult) {
		this.bssdyResult = bssdyResult;
	}

	public String getBssdyResult( ) {
		return bssdyResult;
	}

	public void setBssdyStatus(Integer bssdyStatus) {
		this.bssdyStatus = bssdyStatus;
	}

	public Integer getBssdyStatus( ) {
		return bssdyStatus;
	}

	public void setBssdyOrd(Integer bssdyOrd) {
		this.bssdyOrd = bssdyOrd;
	}

	public Integer getBssdyOrd( ) {
		return bssdyOrd;
	}

	public BusiSuspenseDay( ) { 
	}

//<=================定制内容开始==============
//==================定制内容结束==============>

}