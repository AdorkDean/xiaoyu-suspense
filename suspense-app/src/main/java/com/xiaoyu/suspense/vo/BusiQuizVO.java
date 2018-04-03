package com.xiaoyu.suspense.vo;

import com.xiaoyu.suspense.entity.BusiQuiz;
import com.xiaoyu.suspense.util.BaseVO;
import com.xiaoyu.suspense.util.DateUtil;

public class BusiQuizVO implements BaseVO {

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
	private String bsqizTime;

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

	public void setBsqizTime(String bsqizTime) {
		this.bsqizTime = bsqizTime;
	}

	public String getBsqizTime( ) {
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

	public BusiQuizVO( ) { 
	}

	@Override
	public void convertPOToVO(Object poObj) {
		if (null == poObj) {
			return;
		}

		BusiQuiz po = (BusiQuiz) poObj;
		this.bsqizUuid = po.getBsqizUuid();
		this.bsqizUser = po.getBsqizUser();
		this.bsqizSuspense = po.getBsqizSuspense();
		this.bsqizTime = po.getBsqizTime()!=null?DateUtil.formatDefaultDate(po.getBsqizTime()):"";
		this.bsqizAnswer = po.getBsqizAnswer();
		this.bsqizResult = po.getBsqizResult();
		this.bsqizScore = po.getBsqizScore();
	}
//<=================定制内容开始==============
//==================定制内容结束==============>

}