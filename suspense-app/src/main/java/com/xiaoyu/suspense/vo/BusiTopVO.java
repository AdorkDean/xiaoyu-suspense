package com.xiaoyu.suspense.vo;

import com.xiaoyu.suspense.entity.BusiTop;
import com.xiaoyu.suspense.enums.BusiType;
import com.xiaoyu.suspense.util.BaseVO;
import com.xiaoyu.suspense.util.DateUtil;

public class BusiTopVO implements BaseVO {

	/**
	*标识UUID
	*/
	private String bstopUuid;

	/**
	*业务UUID
	*/
	private String bstopBusi;

	/**
	*业务类型
	*/
	private BusiType bstopBusiType;

	/**
	*顶时间
	*/
	private String bstopTime;

	/**
	*排序号
	*/
	private Integer bstopOrd;

	/**
	*用户人UUID
	*/
	private String bstopUser;

	public void setBstopUuid(String bstopUuid) {
		this.bstopUuid = bstopUuid;
	}

	public String getBstopUuid( ) {
		return bstopUuid;
	}

	public void setBstopBusi(String bstopBusi) {
		this.bstopBusi = bstopBusi;
	}

	public String getBstopBusi( ) {
		return bstopBusi;
	}

	public void setBstopBusiType(BusiType bstopBusiType) {
		this.bstopBusiType = bstopBusiType;
	}

	public BusiType getBstopBusiType( ) {
		return bstopBusiType;
	}

	public void setBstopTime(String bstopTime) {
		this.bstopTime = bstopTime;
	}

	public String getBstopTime( ) {
		return bstopTime;
	}

	public void setBstopOrd(Integer bstopOrd) {
		this.bstopOrd = bstopOrd;
	}

	public Integer getBstopOrd( ) {
		return bstopOrd;
	}

	public void setBstopUser(String bstopUser) {
		this.bstopUser = bstopUser;
	}

	public String getBstopUser( ) {
		return bstopUser;
	}

	public BusiTopVO( ) { 
	}

	@Override
	public void convertPOToVO(Object poObj) {
		if (null == poObj) {
			return;
		}

		BusiTop po = (BusiTop) poObj;
		this.bstopUuid = po.getBstopUuid();
		this.bstopBusi = po.getBstopBusi();
		this.bstopBusiType = po.getBstopBusiType();
		this.bstopTime = po.getBstopTime()!=null?DateUtil.formatDefaultDate(po.getBstopTime()):"";
		this.bstopOrd = po.getBstopOrd();
		this.bstopUser = po.getBstopUser();
	}
//<=================定制内容开始==============
//==================定制内容结束==============>

}