package com.xiaoyu.suspense.service;

import com.xiaoyu.suspense.entity.CoreSuggest;

public interface CoreSuggestService {

	/**
	* 添加
	* @param coreSuggest
	* @return
	*/
	public boolean insertCoreSuggest(CoreSuggest coreSuggest);

	/**
	* 修改
	* @param coreSuggest
	* @return
	*/
	public boolean updateCoreSuggest(CoreSuggest coreSuggest);

	/**
	* 删除
	* @param coreSuggest
	* @return
	*/
	public boolean deleteCoreSuggest(CoreSuggest coreSuggest);

	/**
	* 查询
	* @param coreSuggest
	* @return
	*/
	public CoreSuggest getCoreSuggest(CoreSuggest coreSuggest);

//<=================定制内容开始==============
//==================定制内容结束==============>

}