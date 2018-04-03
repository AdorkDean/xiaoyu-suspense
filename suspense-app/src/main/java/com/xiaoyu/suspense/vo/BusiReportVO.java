package com.xiaoyu.suspense.vo;

import com.xiaoyu.suspense.entity.BusiReport;
import com.xiaoyu.suspense.util.BaseVO;
import com.xiaoyu.suspense.util.DateUtil;

public class BusiReportVO implements BaseVO {

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
	*被关注人姓名或关注人姓名
	*/
	private String beAttentionName;
	
	/**
	*创建日期
	*/
	private String bsrptCdate;

	/**
	*排序号
	*/
	private Integer bsrptOrd;

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

	public void setBsrptCdate(String bsrptCdate) {
		this.bsrptCdate = bsrptCdate;
	}

	public String getBsrptCdate( ) {
		return bsrptCdate;
	}

	public void setBsrptOrd(Integer bsrptOrd) {
		this.bsrptOrd = bsrptOrd;
	}

	public Integer getBsrptOrd( ) {
		return bsrptOrd;
	}

	public String getBeAttentionName() {
		return beAttentionName;
	}

	public void setBeAttentionName(String beAttentionName) {
		this.beAttentionName = beAttentionName;
	}

	public BusiReportVO( ) { 
	}

	@Override
	public void convertPOToVO(Object poObj) {
		if (null == poObj) {
			return;
		}

		BusiReport po = (BusiReport) poObj;
		this.bsrptUuid = po.getBsrptUuid();
		this.bsrptAttention = po.getBsrptAttention();
		this.bsrptBeAttention = po.getBsrptBeAttention();
		this.bsrptCdate = po.getBsrptCdate()!=null?DateUtil.formatDefaultDate(po.getBsrptCdate()):"";
		this.bsrptOrd = po.getBsrptOrd();
	}
//<=================定制内容开始==============
//==================定制内容结束==============>

}