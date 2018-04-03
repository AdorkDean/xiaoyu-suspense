package com.xiaoyu.suspense.service;

import java.util.List;
import com.xiaoyu.suspense.entity.BusiFollowPost;

public interface BusiFollowPostService {

	/**
	* 添加
	* @param busiFollowPost
	* @return
	*/
	public boolean insertBusiFollowPost(BusiFollowPost busiFollowPost);

	/**
	* 修改
	* @param busiFollowPost
	* @return
	*/
	public boolean updateBusiFollowPost(BusiFollowPost busiFollowPost);

	/**
	* 删除
	* @param busiFollowPost
	* @return
	*/
	public boolean deleteBusiFollowPost(BusiFollowPost busiFollowPost);

	/**
	* 查询
	* @param busiFollowPost
	* @return
	*/
	public BusiFollowPost getBusiFollowPost(BusiFollowPost busiFollowPost);

//<=================定制内容开始==============
	/**
	* 跟帖列表
	* @param bsfptPost
	* @param lastId
	* @param limit
	* @return
	*/
	public List<BusiFollowPost> getBusiFollowPostByPost(String bsfptPost, int lastId, int limit);
	
	/**
	* 跟帖量
	* @param bsfptPost
	* @return
	*/
	public Integer getCountFollowPost(String bsfptPost);
//==================定制内容结束==============>

}