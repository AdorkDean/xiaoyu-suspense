package com.xiaoyu.suspense.vo;

import com.xiaoyu.suspense.entity.BusiSuspenseDay;
import com.xiaoyu.suspense.enums.YesNoType;
import com.xiaoyu.suspense.util.BaseVO;

public class BusiSuspenseDayVO implements BaseVO {

	/**
	*标识UUID
	*/
	private String bssdyUuid;

	/**
	*悬疑内容
	*/
	private String bssdyContent;

	/**
	*积分
	*/
	private Integer bssdyScore;
	
	/**
	*发布时间(年-月-日)
	*/
	private String bssdyDay;

	/**
	*答案
	*/
	private String bssdyResult;

	/**
	*状态:1启用,0禁用
	*/
	private Integer bssdyStatus;

	/**
	*排序号
	*/
	private Integer bssdyOrd;

	/**
	 * 是否已被竞猜
	 */
	private YesNoType isCollect;
	
	public void setBssdyUuid(String bssdyUuid) {
		this.bssdyUuid = bssdyUuid;
	}

	public String getBssdyUuid( ) {
		return bssdyUuid;
	}

	public void setBssdyContent(String bssdyContent) {
		this.bssdyContent = bssdyContent;
	}

	public String getBssdyContent( ) {
		return bssdyContent;
	}

	public Integer getBssdyScore() {
		return bssdyScore;
	}

	public void setBssdyScore(Integer bssdyScore) {
		this.bssdyScore = bssdyScore;
	}

	public void setBssdyDay(String bssdyDay) {
		this.bssdyDay = bssdyDay;
	}

	public String getBssdyDay( ) {
		return bssdyDay;
	}

	public void setBssdyResult(String bssdyResult) {
		this.bssdyResult = bssdyResult;
	}

	public String getBssdyResult( ) {
		return bssdyResult;
	}

	public void setBssdyStatus(Integer bssdyStatus) {
		this.bssdyStatus = bssdyStatus;
	}

	public Integer getBssdyStatus( ) {
		return bssdyStatus;
	}

	public void setBssdyOrd(Integer bssdyOrd) {
		this.bssdyOrd = bssdyOrd;
	}

	public Integer getBssdyOrd( ) {
		return bssdyOrd;
	}

	public YesNoType getIsCollect() {
		return isCollect;
	}

	public void setIsCollect(YesNoType isCollect) {
		this.isCollect = isCollect;
	}

	public BusiSuspenseDayVO( ) { 
	}

	@Override
	public void convertPOToVO(Object poObj) {
		if (null == poObj) {
			return;
		}

		BusiSuspenseDay po = (BusiSuspenseDay) poObj;
		this.bssdyUuid = po.getBssdyUuid();
		this.bssdyContent = po.getBssdyContent();
		this.bssdyScore = po.getBssdyScore();
		this.bssdyDay = po.getBssdyDay();
		this.bssdyResult = po.getBssdyResult();
		this.bssdyStatus = po.getBssdyStatus();
		this.bssdyOrd = po.getBssdyOrd();
	}
//<=================定制内容开始==============
//==================定制内容结束==============>

}