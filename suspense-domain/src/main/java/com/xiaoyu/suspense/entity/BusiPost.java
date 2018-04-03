package com.xiaoyu.suspense.entity;

import com.xiaoyu.suspense.entity.BaseEntity;
import java.util.Date;

public class BusiPost extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	*标识UNID
	*/
	private Integer bspstUnid;

	/**
	*标识UUID
	*/
	private String bspstUuid;

	/**
	*发表用户UUID
	*/
	private String bspstUser;

	/**
	*帖子标题
	*/
	private String bspstTitle;

	/**
	*帖子内容
	*/
	private String bspstContent;

	/**
	*图片URL
	*/
	private String bspstImage;

	/**
	*发表时间
	*/
	private Date bspstTime;

	/**
	*顶
	*/
	private Integer bspstUp;

	/**
	*状态:1启用,0禁用
	*/
	private Integer bspstStatus;

	/**
	*排序号
	*/
	private Integer bspstOrd;

	/**
	*类型:0普通帖,1上期答案表,2上期答对名单表,3答题排行表
	*/
	private Integer bspstType;

	public void setBspstUnid(Integer bspstUnid) {
		this.bspstUnid = bspstUnid;
	}

	public Integer getBspstUnid( ) {
		return bspstUnid;
	}

	public void setBspstUuid(String bspstUuid) {
		this.bspstUuid = bspstUuid;
	}

	public String getBspstUuid( ) {
		return bspstUuid;
	}

	public void setBspstUser(String bspstUser) {
		this.bspstUser = bspstUser;
	}

	public String getBspstUser( ) {
		return bspstUser;
	}

	public void setBspstTitle(String bspstTitle) {
		this.bspstTitle = bspstTitle;
	}

	public String getBspstTitle( ) {
		return bspstTitle;
	}

	public void setBspstContent(String bspstContent) {
		this.bspstContent = bspstContent;
	}

	public String getBspstContent( ) {
		return bspstContent;
	}

	public void setBspstImage(String bspstImage) {
		this.bspstImage = bspstImage;
	}

	public String getBspstImage( ) {
		return bspstImage;
	}

	public void setBspstTime(Date bspstTime) {
		this.bspstTime = bspstTime;
	}

	public Date getBspstTime( ) {
		return bspstTime;
	}

	public void setBspstUp(Integer bspstUp) {
		this.bspstUp = bspstUp;
	}

	public Integer getBspstUp( ) {
		return bspstUp;
	}

	public void setBspstStatus(Integer bspstStatus) {
		this.bspstStatus = bspstStatus;
	}

	public Integer getBspstStatus( ) {
		return bspstStatus;
	}

	public void setBspstOrd(Integer bspstOrd) {
		this.bspstOrd = bspstOrd;
	}

	public Integer getBspstOrd( ) {
		return bspstOrd;
	}

	public void setBspstType(Integer bspstType) {
		this.bspstType = bspstType;
	}

	public Integer getBspstType( ) {
		return bspstType;
	}

	public BusiPost( ) { 
	}

//<=================定制内容开始==============
//==================定制内容结束==============>

}