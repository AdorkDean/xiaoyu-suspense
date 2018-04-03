package com.xiaoyu.suspense.service.impl;

import com.xiaoyu.suspense.service.CoreLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xiaoyu.suspense.mybatis.dao.MyBatisDAO;
import com.xiaoyu.suspense.entity.CoreLink;

@Service("coreLinkService")
public class CoreLinkServiceImpl implements CoreLinkService {

	@Autowired
	private MyBatisDAO myBatisDAO;

	@Override
	public boolean insertCoreLink(CoreLink coreLink) {
		myBatisDAO.insert(coreLink);
		return true;
	}

	@Override
	public boolean updateCoreLink(CoreLink coreLink) {
		myBatisDAO.update(coreLink);
		return true;
	}

	@Override
	public boolean deleteCoreLink(CoreLink coreLink) {
		myBatisDAO.delete(coreLink);
		return true;
	}

	@Override
	public CoreLink getCoreLink(CoreLink coreLink) {
		return (CoreLink) myBatisDAO.findForObject(coreLink);
	}

//<=================定制内容开始==============
//==================定制内容结束==============>

}