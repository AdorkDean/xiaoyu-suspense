package com.xiaoyu.suspense.vo;

import com.xiaoyu.suspense.entity.BusiFollowPost;
import com.xiaoyu.suspense.util.BaseVO;
//import com.xiaoyu.suspense.util.DateUtil;

public class BusiFollowPostVO implements BaseVO {

	/**
	*标识UUID
	*/
	private String bsfptUuid;

	/**
	*发表用户UUID
	*/
	private String bsfptUser;

	/**
	*帖子UUID
	*/
	private String bsfptPost;

	/**
	*发表时间
	*/
	private String bsfptTime;

	/**
	*跟帖内容
	*/
	private String bsfptContent;

	/**
	*状态:1启用,0禁用
	*/
	private Integer bsfptStatus;

	/**
	*排序号
	*/
	private Integer bsfptOrd;

	/**
	*发表人昵称
	*/
	private String pushUserCode;
	
	/**
	*发表人头像
	*/
	private String pushUserHead;
	
	public void setBsfptUuid(String bsfptUuid) {
		this.bsfptUuid = bsfptUuid;
	}

	public String getBsfptUuid( ) {
		return bsfptUuid;
	}

	public void setBsfptUser(String bsfptUser) {
		this.bsfptUser = bsfptUser;
	}

	public String getBsfptUser( ) {
		return bsfptUser;
	}

	public void setBsfptPost(String bsfptPost) {
		this.bsfptPost = bsfptPost;
	}

	public String getBsfptPost( ) {
		return bsfptPost;
	}

	public void setBsfptTime(String bsfptTime) {
		this.bsfptTime = bsfptTime;
	}

	public String getBsfptTime( ) {
		return bsfptTime;
	}

	public void setBsfptContent(String bsfptContent) {
		this.bsfptContent = bsfptContent;
	}

	public String getBsfptContent( ) {
		return bsfptContent;
	}

	public void setBsfptStatus(Integer bsfptStatus) {
		this.bsfptStatus = bsfptStatus;
	}

	public Integer getBsfptStatus( ) {
		return bsfptStatus;
	}

	public void setBsfptOrd(Integer bsfptOrd) {
		this.bsfptOrd = bsfptOrd;
	}

	public Integer getBsfptOrd( ) {
		return bsfptOrd;
	}
	
	public String getPushUserCode() {
		return pushUserCode;
	}

	public void setPushUserCode(String pushUserCode) {
		this.pushUserCode = pushUserCode;
	}

	public String getPushUserHead() {
		return pushUserHead;
	}

	public void setPushUserHead(String pushUserHead) {
		this.pushUserHead = pushUserHead;
	}
	
	public BusiFollowPostVO( ) { 
	}

	@Override
	public void convertPOToVO(Object poObj) {
		if (null == poObj) {
			return;
		}

		BusiFollowPost po = (BusiFollowPost) poObj;
		this.bsfptUuid = po.getBsfptUuid();
		this.bsfptUser = po.getBsfptUser();
		this.bsfptPost = po.getBsfptPost();
		//this.bsfptTime = po.getBsfptTime()!=null?DateUtil.formatDefaultDate(po.getBsfptTime()):"";
		if(po.getBsfptTime() != null) {
			long time = System.currentTimeMillis() - po.getBsfptTime().getTime();
			int minute = (int)(time/1000/60);
			if(minute <= 5) {
				this.bsfptTime = "刚刚";
			}else {
				int hour = minute/60;
				if(hour < 1) {
					this.bsfptTime = minute + "分钟前";
				}else {
					int day = hour/24;
					if(day < 1) {
						this.bsfptTime = hour + "小时前";
					}else {
						this.bsfptTime = day + "天前";
					}
				}
			}
			//this.bsfptTime = String.valueOf(System.currentTimeMillis() - po.getBsfptTime().getTime());
		}
		this.bsfptContent = po.getBsfptContent();
		this.bsfptStatus = po.getBsfptStatus();
		this.bsfptOrd = po.getBsfptOrd();
	}
//<=================定制内容开始==============
//==================定制内容结束==============>

}