package com.xiaoyu.suspense.service;

import com.xiaoyu.suspense.entity.BusiSuspenseContent;

public interface BusiSuspenseContentService {

	/**
	* 添加
	* @param busiSuspenseContent
	* @return
	*/
	public boolean insertBusiSuspenseContent(BusiSuspenseContent busiSuspenseContent);

	/**
	* 修改
	* @param busiSuspenseContent
	* @return
	*/
	public boolean updateBusiSuspenseContent(BusiSuspenseContent busiSuspenseContent);

	/**
	* 删除
	* @param busiSuspenseContent
	* @return
	*/
	public boolean deleteBusiSuspenseContent(BusiSuspenseContent busiSuspenseContent);

	/**
	* 查询
	* @param busiSuspenseContent
	* @return
	*/
	public BusiSuspenseContent getBusiSuspenseContent(BusiSuspenseContent busiSuspenseContent);

//<=================定制内容开始==============	
	/**
	* 悬疑故事详情
	* @param busiSuspenseContent
	* @return
	*/
	public BusiSuspenseContent getBusiSuspenseContentByOrd(BusiSuspenseContent busiSuspenseContent);
	
	/**
	* 总页数
	* @param
	* @return
	*/
	public int getCountContent(String bssctStory);
//==================定制内容结束==============>

}