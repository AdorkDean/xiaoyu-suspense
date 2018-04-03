package com.xiaoyu.suspense.service.impl;

import java.util.HashMap;
import java.util.Map;

import com.xiaoyu.suspense.service.BusiSuspenseContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xiaoyu.suspense.mybatis.dao.MyBatisDAO;
import com.xiaoyu.suspense.entity.BusiSuspenseContent;

@Service("busiSuspenseContentService")
public class BusiSuspenseContentServiceImpl implements BusiSuspenseContentService {

	@Autowired
	private MyBatisDAO myBatisDAO;

	@Override
	public boolean insertBusiSuspenseContent(BusiSuspenseContent busiSuspenseContent) {
		myBatisDAO.insert(busiSuspenseContent);
		return true;
	}

	@Override
	public boolean updateBusiSuspenseContent(BusiSuspenseContent busiSuspenseContent) {
		myBatisDAO.update(busiSuspenseContent);
		return true;
	}

	@Override
	public boolean deleteBusiSuspenseContent(BusiSuspenseContent busiSuspenseContent) {
		myBatisDAO.delete(busiSuspenseContent);
		return true;
	}

	@Override
	public BusiSuspenseContent getBusiSuspenseContent(BusiSuspenseContent busiSuspenseContent) {
		return (BusiSuspenseContent) myBatisDAO.findForObject(busiSuspenseContent);
	}

//<=================定制内容开始==============
	private static final String GET_BUSI_SUSPENSE_CONTENT_BY_ORD = "getBusiSuspenseContentByOrd";
	private static final String GET_COUNT_CONTENT = "getCountContent";
	
	@Override
	public BusiSuspenseContent getBusiSuspenseContentByOrd(BusiSuspenseContent busiSuspenseContent) {
		return (BusiSuspenseContent) myBatisDAO.findForObject(GET_BUSI_SUSPENSE_CONTENT_BY_ORD, busiSuspenseContent);
	}
	
	@Override
	public int getCountContent(String bssctStory) {
		Map<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("bssctStory", bssctStory);
		Integer count = (Integer) myBatisDAO.findForObject(GET_COUNT_CONTENT, hashMap);
		if(count == null)
			return 0;
		return count;
	}
//==================定制内容结束==============>

}