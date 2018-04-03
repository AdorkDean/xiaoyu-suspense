package com.xiaoyu.suspense.service;

import java.util.List;
import com.xiaoyu.suspense.entity.BusiNotechat;

public interface BusiNotechatService {

	/**
	* 添加
	* @param busiNotechat
	* @return
	*/
	public boolean insertBusiNotechat(BusiNotechat busiNotechat);

	/**
	* 修改
	* @param busiNotechat
	* @return
	*/
	public boolean updateBusiNotechat(BusiNotechat busiNotechat);

	/**
	* 删除
	* @param busiNotechat
	* @return
	*/
	public boolean deleteBusiNotechat(BusiNotechat busiNotechat);

	/**
	* 查询
	* @param busiNotechat
	* @return
	*/
	public BusiNotechat getBusiNotechat(BusiNotechat busiNotechat);

//<=================定制内容开始==============
	/**
	* 聊天详情
	* @param bsnctReport
	* @param lastId
	* @param limit
	* @return
	*/
	public List<BusiNotechat> getBusiNotechatByReport(String bsnctReport, int lastId, int limit);
//==================定制内容结束==============>

}