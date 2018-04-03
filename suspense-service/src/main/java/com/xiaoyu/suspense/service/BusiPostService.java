package com.xiaoyu.suspense.service;

import java.util.List;
import com.xiaoyu.suspense.entity.BusiPost;

public interface BusiPostService {

	/**
	* 添加
	* @param busiPost
	* @return
	*/
	public boolean insertBusiPost(BusiPost busiPost);

	/**
	* 修改
	* @param busiPost
	* @return
	*/
	public boolean updateBusiPost(BusiPost busiPost);

	/**
	* 删除
	* @param busiPost
	* @return
	*/
	public boolean deleteBusiPost(BusiPost busiPost);

	/**
	* 查询
	* @param busiPost
	* @return
	*/
	public BusiPost getBusiPost(BusiPost busiPost);

//<=================定制内容开始==============
	/**
	 * 我的帖子数
	 * @param userUuid
	 * @return
	 */
	public Integer getCountBusiPostByMy(String userUuid);
	
	/**
	* 帖子列表和我的帖子
	* @param userUuid
	* @param lastId
	* @param limit
	* @return
	*/
	public List<BusiPost> getBusiPostByMy(String userUuid, int lastId, int limit);
	
	/**
	* 顶
	* @param bspstUuid
	* @return
	*/
	public boolean updateBusiPostGood(String bspstUuid);
//==================定制内容结束==============>

}