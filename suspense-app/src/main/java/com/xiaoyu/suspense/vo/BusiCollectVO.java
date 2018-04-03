package com.xiaoyu.suspense.vo;

import com.xiaoyu.suspense.entity.BusiCollect;
import com.xiaoyu.suspense.util.BaseVO;
import com.xiaoyu.suspense.util.DateUtil;

public class BusiCollectVO implements BaseVO {

	/**
	*标识UUID
	*/
	private String bscltUuid;

	/**
	*每次悬疑UUID
	*/
	private String bscltSuspense;

	/**
	*收藏时间
	*/
	private String bscltTime;

	/**
	*排序号
	*/
	private Integer bscltOrd;

	/**
	*收藏人UUID
	*/
	private String bscltUser;

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

	public void setBscltTime(String bscltTime) {
		this.bscltTime = bscltTime;
	}

	public String getBscltTime( ) {
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

	public BusiCollectVO( ) { 
	}

	@Override
	public void convertPOToVO(Object poObj) {
		if (null == poObj) {
			return;
		}

		BusiCollect po = (BusiCollect) poObj;
		this.bscltUuid = po.getBscltUuid();
		this.bscltSuspense = po.getBscltSuspense();
		this.bscltTime = po.getBscltTime()!=null?DateUtil.formatDefaultDate(po.getBscltTime()):"";
		this.bscltOrd = po.getBscltOrd();
		this.bscltUser = po.getBscltUser();
	}
//<=================定制内容开始==============
//==================定制内容结束==============>

}