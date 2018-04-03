package com.xiaoyu.suspense.vo;

import com.xiaoyu.suspense.entity.BusiSuspenseStory;
import com.xiaoyu.suspense.util.BaseVO;
import com.xiaoyu.suspense.util.DateUtil;

public class BusiSuspenseStoryVO implements BaseVO {

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
	private String bsssyCdate;

	/**
	*修改日期
	*/
	private String bsssyUdate;

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
	
	/**
	*评论数
	*/
	private Integer countComment;

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

	public void setBsssyCdate(String bsssyCdate) {
		this.bsssyCdate = bsssyCdate;
	}

	public String getBsssyCdate( ) {
		return bsssyCdate;
	}

	public void setBsssyUdate(String bsssyUdate) {
		this.bsssyUdate = bsssyUdate;
	}

	public String getBsssyUdate( ) {
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

	public Integer getCountComment() {
		return countComment;
	}

	public void setCountComment(Integer countComment) {
		this.countComment = countComment;
	}

	public BusiSuspenseStoryVO( ) { 
	}

	@Override
	public void convertPOToVO(Object poObj) {
		if (null == poObj) {
			return;
		}

		BusiSuspenseStory po = (BusiSuspenseStory) poObj;
		this.bsssyUuid = po.getBsssyUuid();
		this.bsssyTitle = po.getBsssyTitle();
		this.bsssyUp = po.getBsssyUp();
		this.bsssyCdate = po.getBsssyCdate()!=null?DateUtil.formatDefaultDate(po.getBsssyCdate()):"";
		this.bsssyUdate = po.getBsssyUdate()!=null?DateUtil.formatDefaultDate(po.getBsssyUdate()):"";
		this.bsssyStatus = po.getBsssyStatus();
		this.bsssyOrd = po.getBsssyOrd();
		if(po.getBsssySummary().length() > 40) {
			this.bsssySummary = po.getBsssySummary().substring(0, 39) + "...";
		}else {
			this.bsssySummary = po.getBsssySummary();
		}
	}
//<=================定制内容开始==============
//==================定制内容结束==============>

}