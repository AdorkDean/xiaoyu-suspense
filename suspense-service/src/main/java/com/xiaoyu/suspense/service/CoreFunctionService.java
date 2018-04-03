package com.xiaoyu.suspense.service;

import com.xiaoyu.suspense.entity.CoreFunction;

public interface CoreFunctionService {

	/**
	* 添加
	* @param coreFunction
	* @return
	*/
	public boolean insertCoreFunction(CoreFunction coreFunction);

	/**
	* 修改
	* @param coreFunction
	* @return
	*/
	public boolean updateCoreFunction(CoreFunction coreFunction);

	/**
	* 删除
	* @param coreFunction
	* @return
	*/
	public boolean deleteCoreFunction(CoreFunction coreFunction);

	/**
	* 查询
	* @param coreFunction
	* @return
	*/
	public CoreFunction getCoreFunction(CoreFunction coreFunction);

//<=================定制内容开始==============
//==================定制内容结束==============>

}