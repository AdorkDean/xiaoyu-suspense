package com.xiaoyu.suspense.service;

import com.xiaoyu.suspense.entity.BusiTop;

public interface BusiTopService {

	/**
	* 添加
	* @param busiTop
	* @return
	*/
	public boolean insertBusiTop(BusiTop busiTop);

	/**
	* 修改
	* @param busiTop
	* @return
	*/
	public boolean updateBusiTop(BusiTop busiTop);

	/**
	* 删除
	* @param busiTop
	* @return
	*/
	public boolean deleteBusiTop(BusiTop busiTop);

	/**
	* 查询
	* @param busiTop
	* @return
	*/
	public BusiTop getBusiTop(BusiTop busiTop);

//<=================定制内容开始==============
	
	/**
	* 根据用户和业务查询
	* @param busiTop
	* @return
	*/
	public BusiTop getBusiTopByUserAndBusi(BusiTop busiTop);
//==================定制内容结束==============>

}