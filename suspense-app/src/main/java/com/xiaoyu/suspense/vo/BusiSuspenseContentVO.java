package com.xiaoyu.suspense.vo;

import com.xiaoyu.suspense.entity.BusiSuspenseContent;
import com.xiaoyu.suspense.util.BaseVO;

public class BusiSuspenseContentVO implements BaseVO {

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

	/**
	*总页数
	*/
	private Integer pageSize;
	
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

	public BusiSuspenseContentVO( ) { 
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	@Override
	public void convertPOToVO(Object poObj) {
		if (null == poObj) {
			return;
		}

		BusiSuspenseContent po = (BusiSuspenseContent) poObj;
		this.bssctUuid = po.getBssctUuid();
		this.bssctStory = po.getBssctStory();
		this.bssctContent = po.getBssctContent();
		this.bssctOrd = po.getBssctOrd();
	}
//<=================定制内容开始==============
//==================定制内容结束==============>

}