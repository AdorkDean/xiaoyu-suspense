package com.xiaoyu.suspense.entity;

import com.xiaoyu.suspense.entity.BaseEntity;
import java.util.Date;

public class BusiSuspenseStory extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	*标识UNID
	*/
	private Integer bsssyUnid;

	/**
	*标识UUID
	*/
	private String bsssyUuid;

	/**
	*标题
	*/
	private String bsssyTitle;

	/**
	*顶
	*/
	private Integer bsssyUp;

	/**
	*创建日期
	*/
	private Date bsssyCdate;

	/**
	*修改日期
	*/
	private Date bsssyUdate;

	/**
	*状态:1启用,0禁用
	*/
	private Integer bsssyStatus;

	/**
	*排序号
	*/
	private Integer bsssyOrd;

	/**
	*故事简介
	*/
	private String bsssySummary;

	public void setBsssyUnid(Integer bsssyUnid) {
		this.bsssyUnid = bsssyUnid;
	}

	public Integer getBsssyUnid( ) {
		return bsssyUnid;
	}

	public void setBsssyUuid(String bsssyUuid) {
		this.bsssyUuid = bsssyUuid;
	}

	public String getBsssyUuid( ) {
		return bsssyUuid;
	}

	public void setBsssyTitle(String bsssyTitle) {
		this.bsssyTitle = bsssyTitle;
	}

	public String getBsssyTitle( ) {
		return bsssyTitle;
	}

	public void setBsssyUp(Integer bsssyUp) {
		this.bsssyUp = bsssyUp;
	}

	public Integer getBsssyUp( ) {
		return bsssyUp;
	}

	public void setBsssyCdate(Date bsssyCdate) {
		this.bsssyCdate = bsssyCdate;
	}

	public Date getBsssyCdate( ) {
		return bsssyCdate;
	}

	public void setBsssyUdate(Date bsssyUdate) {
		this.bsssyUdate = bsssyUdate;
	}

	public Date getBsssyUdate( ) {
		return bsssyUdate;
	}

	public void setBsssyStatus(Integer bsssyStatus) {
		this.bsssyStatus = bsssyStatus;
	}

	public Integer getBsssyStatus( ) {
		return bsssyStatus;
	}

	public void setBsssyOrd(Integer bsssyOrd) {
		this.bsssyOrd = bsssyOrd;
	}

	public Integer getBsssyOrd( ) {
		return bsssyOrd;
	}

	public void setBsssySummary(String bsssySummary) {
		this.bsssySummary = bsssySummary;
	}

	public String getBsssySummary( ) {
		return bsssySummary;
	}

	public BusiSuspenseStory( ) { 
	}

//<=================定制内容开始==============
//==================定制内容结束==============>

}