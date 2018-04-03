package com.xiaoyu.suspense.service;

import java.util.List;
import com.xiaoyu.suspense.entity.BusiSuspenseDay;

public interface BusiSuspenseDayService {

	/**
	* 添加
	* @param busiSuspenseDay
	* @return
	*/
	public boolean insertBusiSuspenseDay(BusiSuspenseDay busiSuspenseDay);

	/**
	* 修改
	* @param busiSuspenseDay
	* @return
	*/
	public boolean updateBusiSuspenseDay(BusiSuspenseDay busiSuspenseDay);

	/**
	* 删除
	* @param busiSuspenseDay
	* @return
	*/
	public boolean deleteBusiSuspenseDay(BusiSuspenseDay busiSuspenseDay);

	/**
	* 查询
	* @param busiSuspenseDay
	* @return
	*/
	public BusiSuspenseDay getBusiSuspenseDay(BusiSuspenseDay busiSuspenseDay);	

//<=================定制内容开始==============	
	/**
	* 查询每日悬疑
	* @param
	* @return
	*/
	public List<BusiSuspenseDay> getBusiSuspenseDayByDay();
	
	/**
	* 竞猜列表
	* @param bssdyDay
	* @return
	*/
	public List<BusiSuspenseDay> getSuspenseDayByDay(String bssdyDay);
	
	/**
	* 我的竞猜列表
	* @param lastId
	* @param limit
	* @param userUuid
	* @return
	*/
	public List<BusiSuspenseDay> getSuspenseDayByMyQuiz(int lastId, int limit, String userUuid);
	
	/**
	* 我的收藏列表
	* @param lastId
	* @param limit
	* @param userUuid
	* @return
	*/
	public List<BusiSuspenseDay> getSuspenseDayByMyCollect(int lastId, int limit, String userUuid);
//==================定制内容结束==============>

}