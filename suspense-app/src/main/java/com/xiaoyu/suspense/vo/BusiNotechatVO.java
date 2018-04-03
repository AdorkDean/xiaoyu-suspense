package com.xiaoyu.suspense.vo;

import com.xiaoyu.suspense.entity.BusiNotechat;
import com.xiaoyu.suspense.util.BaseVO;
import com.xiaoyu.suspense.util.DateUtil;

public class BusiNotechatVO implements BaseVO {

	/**
	*标识UNID
	*/
	private Integer bsnctUnid;
	
	/**
	*标识UUID
	*/
	private String bsnctUuid;

	/**
	*关注UUID
	*/
	private String bsnctReport;

	/**
	*内容
	*/
	private String bsnctContent;

	/**
	*发送人
	*/
	private String bsnctUser;
	
	/**
	*发送人头像
	*/
	private String userHead;

	/**
	*类型:1文字,2图片,3语音
	*/
	private Integer bsnctType;

	/**
	*发送时间
	*/
	private String bsnctSebdTime;

	/**
	*排序号
	*/
	private Integer bsnctOrd;

	public void setBsnctUuid(String bsnctUuid) {
		this.bsnctUuid = bsnctUuid;
	}

	public String getBsnctUuid( ) {
		return bsnctUuid;
	}

	public void setBsnctReport(String bsnctReport) {
		this.bsnctReport = bsnctReport;
	}

	public String getBsnctReport( ) {
		return bsnctReport;
	}

	public void setBsnctContent(String bsnctContent) {
		this.bsnctContent = bsnctContent;
	}

	public String getBsnctContent( ) {
		return bsnctContent;
	}

	public void setBsnctUser(String bsnctUser) {
		this.bsnctUser = bsnctUser;
	}

	public String getBsnctUser( ) {
		return bsnctUser;
	}

	public void setBsnctType(Integer bsnctType) {
		this.bsnctType = bsnctType;
	}

	public Integer getBsnctType( ) {
		return bsnctType;
	}

	public void setBsnctSebdTime(String bsnctSebdTime) {
		this.bsnctSebdTime = bsnctSebdTime;
	}

	public String getBsnctSebdTime( ) {
		return bsnctSebdTime;
	}

	public void setBsnctOrd(Integer bsnctOrd) {
		this.bsnctOrd = bsnctOrd;
	}

	public Integer getBsnctOrd( ) {
		return bsnctOrd;
	}

	public String getUserHead() {
		return userHead;
	}

	public void setUserHead(String userHead) {
		this.userHead = userHead;
	}

	public Integer getBsnctUnid() {
		return bsnctUnid;
	}

	public void setBsnctUnid(Integer bsnctUnid) {
		this.bsnctUnid = bsnctUnid;
	}

	public BusiNotechatVO( ) { 
	}

	@Override
	public void convertPOToVO(Object poObj) {
		if (null == poObj) {
			return;
		}

		BusiNotechat po = (BusiNotechat) poObj;
		this.bsnctUnid = po.getBsnctUnid();
		this.bsnctUuid = po.getBsnctUuid();
		this.bsnctReport = po.getBsnctReport();
		this.bsnctContent = po.getBsnctContent();
		this.bsnctUser = po.getBsnctUser();
		this.bsnctType = po.getBsnctType();
		this.bsnctSebdTime = po.getBsnctSebdTime()!=null?DateUtil.formatDate("yyyy-MM-dd HH:mm:ss", po.getBsnctSebdTime()):"";
		this.bsnctOrd = po.getBsnctOrd();
	}
//<=================定制内容开始==============
	public void convertPOToVO(Object poObj, String userUuid) {
		if (null == poObj) {
			return;
		}

		BusiNotechat po = (BusiNotechat) poObj;
		this.bsnctUnid = po.getBsnctUnid();
		this.bsnctUuid = po.getBsnctUuid();
		this.bsnctReport = po.getBsnctReport();
		this.bsnctContent = po.getBsnctContent();
		this.bsnctUser = po.getBsnctUser();
		if(userUuid.equals(po.getBsnctUser())) {
			if(po.getBsnctType() == 1) {
				this.bsnctType = 0;
			}
			if(po.getBsnctType() == 2) {
				this.bsnctType = 1;
			}
			if(po.getBsnctType() == 3) {
				this.bsnctType = 2;
			}
		}else {
			if(po.getBsnctType() == 1) {
				this.bsnctType = 3;
			}
			if(po.getBsnctType() == 2) {
				this.bsnctType = 4;
			}
			if(po.getBsnctType() == 3) {
				this.bsnctType = 5;
			}
		}
		this.bsnctSebdTime = po.getBsnctSebdTime()!=null?DateUtil.formatDate("yyyy-MM-dd HH:mm:ss", po.getBsnctSebdTime()):"";
		this.bsnctOrd = po.getBsnctOrd();
	}
//==================定制内容结束==============>

}