package com.xiaoyu.suspense.service;

import com.xiaoyu.suspense.entity.BusiQuiz;

public interface BusiQuizService {

	/**
	* 添加
	* @param busiQuiz
	* @return
	*/
	public boolean insertBusiQuiz(BusiQuiz busiQuiz);

	/**
	* 修改
	* @param busiQuiz
	* @return
	*/
	public boolean updateBusiQuiz(BusiQuiz busiQuiz);

	/**
	* 删除
	* @param busiQuiz
	* @return
	*/
	public boolean deleteBusiQuiz(BusiQuiz busiQuiz);

	/**
	* 查询
	* @param busiQuiz
	* @return
	*/
	public BusiQuiz getBusiQuiz(BusiQuiz busiQuiz);

//<=================定制内容开始==============
	/**
	 * 我的竞猜数
	 * @param userUuid
	 * @return
	 */
	public Integer getCountBusiQuizByMy(String userUuid);
	
	/**
	* 根据用户和每日悬疑查询
	* @param bsqizUser
	* @param bsqizSuspense
	* @return
	*/
	public BusiQuiz getBusiQuizByUserAndSuspense(String bsqizUser, String bsqizSuspense);
//==================定制内容结束==============>

}