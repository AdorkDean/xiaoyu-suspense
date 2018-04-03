package com.xiaoyu.suspense.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.xiaoyu.suspense.service.BusiNotechatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xiaoyu.suspense.mybatis.dao.MyBatisDAO;
import com.xiaoyu.suspense.entity.BusiNotechat;

@Service("busiNotechatService")
public class BusiNotechatServiceImpl implements BusiNotechatService {

	@Autowired
	private MyBatisDAO myBatisDAO;

	@Override
	public boolean insertBusiNotechat(BusiNotechat busiNotechat) {
		myBatisDAO.insert(busiNotechat);
		return true;
	}

	@Override
	public boolean updateBusiNotechat(BusiNotechat busiNotechat) {
		myBatisDAO.update(busiNotechat);
		return true;
	}

	@Override
	public boolean deleteBusiNotechat(BusiNotechat busiNotechat) {
		myBatisDAO.delete(busiNotechat);
		return true;
	}

	@Override
	public BusiNotechat getBusiNotechat(BusiNotechat busiNotechat) {
		return (BusiNotechat) myBatisDAO.findForObject(busiNotechat);
	}

//<=================定制内容开始==============
	private static final String GET_BUSI_NOTE_CHAT_BY_REPORT = "getBusiNotechatByReport";
	
	@SuppressWarnings("unchecked")
	@Override
	public List<BusiNotechat> getBusiNotechatByReport(String bsnctReport,
			int lastId, int limit) {
		Map<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("lastId", lastId);
		hashMap.put("bsnctReport", bsnctReport);
		return myBatisDAO.findForList(GET_BUSI_NOTE_CHAT_BY_REPORT, hashMap, 0, limit);
	}
//==================定制内容结束==============>

}