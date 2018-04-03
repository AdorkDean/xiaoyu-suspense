package com.xiaoyu.suspense.service;

import java.util.List;
import com.xiaoyu.suspense.entity.BusiSuspenseStory;

public interface BusiSuspenseStoryService {

	/**
	* 添加
	* @param busiSuspenseStory
	* @return
	*/
	public boolean insertBusiSuspenseStory(BusiSuspenseStory busiSuspenseStory);

	/**
	* 修改
	* @param busiSuspenseStory
	* @return
	*/
	public boolean updateBusiSuspenseStory(BusiSuspenseStory busiSuspenseStory);

	/**
	* 删除
	* @param busiSuspenseStory
	* @return
	*/
	public boolean deleteBusiSuspenseStory(BusiSuspenseStory busiSuspenseStory);

	/**
	* 查询
	* @param busiSuspenseStory
	* @return
	*/
	public BusiSuspenseStory getBusiSuspenseStory(BusiSuspenseStory busiSuspenseStory);

//<=================定制内容开始==============
	/**
	* 悬疑故事列表
	* @param lastId
	* @param limit
	* @return
	*/
	public List<BusiSuspenseStory> getBusiSuspenseStoryByLastId(int lastId, int limit);
	
	/**
	* 顶
	* @param bsssyUuid
	* @return
	*/
	public boolean updateBusiSuspenseStoryGood(String bsssyUuid);
//==================定制内容结束==============>

}