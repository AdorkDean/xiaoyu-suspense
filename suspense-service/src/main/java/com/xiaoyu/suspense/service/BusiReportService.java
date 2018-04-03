package com.xiaoyu.suspense.service;

import java.util.List;
import com.xiaoyu.suspense.entity.BusiReport;

public interface BusiReportService {

	/**
	* 添加
	* @param busiReport
	* @return
	*/
	public boolean insertBusiReport(BusiReport busiReport);

	/**
	* 修改
	* @param busiReport
	* @return
	*/
	public boolean updateBusiReport(BusiReport busiReport);

	/**
	* 删除
	* @param busiReport
	* @return
	*/
	public boolean deleteBusiReport(BusiReport busiReport);

	/**
	* 查询
	* @param busiReport
	* @return
	*/
	public BusiReport getBusiReport(BusiReport busiReport);

//<=================定制内容开始==============
	/**
	* 用户是否关注
	* @param busiReport
	* @return
	*/
	public BusiReport getBusiReportByUserAndUser(BusiReport busiReport);
	
	/**
	* 取消关注
	* @param bsrptAttention
	* @param bsrptBeAttention
	* @return
	*/
	public boolean deleteBusiReportByUserAndUser(String bsrptAttention, String bsrptBeAttention);
	
	/**
	* 我关注的人和关注我的人
	* @param bsrptAttention
	* @param bsrptBeAttention
	* @param lastId
	* @param limit
	* @return
	*/
	public List<BusiReport> getBusiReportByReport(String bsrptAttention, String bsrptBeAttention, int lastId, int limit);
//==================定制内容结束==============>

}