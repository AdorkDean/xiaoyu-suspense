package com.xiaoyu.suspense.entity;

import com.xiaoyu.suspense.entity.BaseEntity;
import java.util.Date;

public class BusiQuiz extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	*标识UNID
	*/
	private Integer bsqizUnid;

	/**
	*标识UUID
	*/
	private String bsqizUuid;

	/**
	*竞猜用户UUID
	*/
	private String bsqizUser;

	/**
	*每日悬疑UUID
	*/
	private String bsqizSuspense;

	/**
	*竞猜时间
	*/
	private Date bsqizTime;

	/**
	*竞猜答案
	*/
	private String bsqizAnswer;

	/**
	*竞猜结果:0未处理,1成功,2失败
	*/
	private Integer bsqizResult;

	/**
	*竞猜积分
	*/
	private Integer bsqizScore;

	public void setBsqizUnid(Integer bsqizUnid) {
		this.bsqizUnid = bsqizUnid;
	}

	public Integer getBsqizUnid( ) {
		return bsqizUnid;
	}

	public void setBsqizUuid(String bsqizUuid) {
		this.bsqizUuid = bsqizUuid;
	}

	public String getBsqizUuid( ) {
		return bsqizUuid;
	}

	public void setBsqizUser(String bsqizUser) {
		this.bsqizUser = bsqizUser;
	}

	public String getBsqizUser( ) {
		return bsqizUser;
	}

	public void setBsqizSuspense(String bsqizSuspense) {
		this.bsqizSuspense = bsqizSuspense;
	}

	public String getBsqizSuspense( ) {
		return bsqizSuspense;
	}

	public void setBsqizTime(Date bsqizTime) {
		this.bsqizTime = bsqizTime;
	}

	public Date getBsqizTime( ) {
		return bsqizTime;
	}

	public void setBsqizAnswer(String bsqizAnswer) {
		this.bsqizAnswer = bsqizAnswer;
	}

	public String getBsqizAnswer( ) {
		return bsqizAnswer;
	}

	public void setBsqizResult(Integer bsqizResult) {
		this.bsqizResult = bsqizResult;
	}

	public Integer getBsqizResult( ) {
		return bsqizResult;
	}

	public void setBsqizScore(Integer bsqizScore) {
		this.bsqizScore = bsqizScore;
	}

	public Integer getBsqizScore( ) {
		return bsqizScore;
	}

	public BusiQuiz( ) { 
	}

//<=================定制内容开始==============
//==================定制内容结束==============>

}