package com.xiaoyu.suspense.vo;

import com.xiaoyu.suspense.entity.BusiPost;
import com.xiaoyu.suspense.util.BaseVO;
//import com.xiaoyu.suspense.util.DateUtil;

public class BusiPostVO implements BaseVO {

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
	private String bspstTime;

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

	/**
	*发表人昵称
	*/
	private String pushUserCode;
	
	/**
	*发表人头像
	*/
	private String pushUserHead;
	
	/**
	*跟帖数
	*/
	private Integer countFollowPost;
	
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

	public void setBspstTime(String bspstTime) {
		this.bspstTime = bspstTime;
	}

	public String getBspstTime( ) {
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

	public Integer getCountFollowPost() {
		return countFollowPost;
	}

	public void setCountFollowPost(Integer countFollowPost) {
		this.countFollowPost = countFollowPost;
	}

	public BusiPostVO( ) { 
	}

	@Override
	public void convertPOToVO(Object poObj) {
		if (null == poObj) {
			return;
		}

		BusiPost po = (BusiPost) poObj;
		this.bspstUuid = po.getBspstUuid();
		this.bspstUser = po.getBspstUser();
		this.bspstTitle = po.getBspstTitle();
		this.bspstContent = po.getBspstContent();
		this.bspstImage = po.getBspstImage();
		//this.bspstTime = po.getBspstTime()!=null?DateUtil.formatDefaultDate(po.getBspstTime()):"";
		if(po.getBspstTime() != null) {
			this.bspstTime = String.valueOf(System.currentTimeMillis() - po.getBspstTime().getTime());
		}
		this.bspstUp = po.getBspstUp();
		this.bspstStatus = po.getBspstStatus();
		this.bspstOrd = po.getBspstOrd();
		this.bspstType = po.getBspstType();
	}
//<=================定制内容开始==============

	public void convertPOToVOList(Object poObj) {
		if (null == poObj) {
			return;
		}

		BusiPost po = (BusiPost) poObj;
		this.bspstUuid = po.getBspstUuid();
		this.bspstUser = po.getBspstUser();
		this.bspstTitle = po.getBspstTitle();
		if(po.getBspstContent().length() > 40) {
			this.bspstContent = po.getBspstContent().substring(0, 39) + "...";
		}else {
			this.bspstContent = po.getBspstContent();
		}
		this.bspstImage = po.getBspstImage();
		//this.bspstTime = po.getBspstTime()!=null?DateUtil.formatDefaultDate(po.getBspstTime()):"";
		if(po.getBspstTime() != null) {
			long time = System.currentTimeMillis() - po.getBspstTime().getTime();
			int minute = (int)(time/1000/60);
			if(minute <= 5) {
				this.bspstTime = "刚刚";
			}else {
				int hour = minute/60;
				if(hour < 1) {
					this.bspstTime = minute + "分钟前";
				}else {
					int day = hour/24;
					if(day < 1) {
						this.bspstTime = hour + "小时前";
					}else {
						this.bspstTime = day + "天前";
					}
				}
			}
			//this.bspstTime = String.valueOf(System.currentTimeMillis() - po.getBspstTime().getTime());
		}
		this.bspstUp = po.getBspstUp();
		this.bspstStatus = po.getBspstStatus();
		this.bspstOrd = po.getBspstOrd();
		this.bspstType = po.getBspstType();
	}
//==================定制内容结束==============>

}