package com.xiaoyu.suspense.service;

import com.xiaoyu.suspense.entity.BusiCollect;

public interface BusiCollectService {

	/**
	* 添加
	* @param busiCollect
	* @return
	*/
	public boolean insertBusiCollect(BusiCollect busiCollect);

	/**
	* 修改
	* @param busiCollect
	* @return
	*/
	public boolean updateBusiCollect(BusiCollect busiCollect);

	/**
	* 删除
	* @param busiCollect
	* @return
	*/
	public boolean deleteBusiCollect(BusiCollect busiCollect);

	/**
	* 查询
	* @param busiCollect
	* @return
	*/
	public BusiCollect getBusiCollect(BusiCollect busiCollect);

//<=================定制内容开始==============
	/**
	* 根据用户和每日悬疑查询
	* @param busiCollect
	* @return
	*/
	public BusiCollect getBusiCollectByUserAndSuspense(BusiCollect busiCollect);
	
	/**
	* 根据每日悬疑和用户删除收藏
	* @param busiSuspense
	* @param bscltUser
	* @return
	*/
	public boolean deleteBusiCollectBySuspenseAndUser(String busiSuspense, String bscltUser);
	
	/**
	 * 我的收藏数
	 * @param userUuid
	 * @return
	 */
	public Integer getCountBusiCollectByMy(String userUuid);
//==================定制内容结束==============>

}