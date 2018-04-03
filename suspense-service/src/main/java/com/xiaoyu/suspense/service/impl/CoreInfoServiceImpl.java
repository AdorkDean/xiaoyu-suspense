package com.xiaoyu.suspense.service.impl;

import com.xiaoyu.suspense.service.CoreInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xiaoyu.suspense.mybatis.dao.MyBatisDAO;
import com.xiaoyu.suspense.entity.CoreInfo;

@Service("coreInfoService")
public class CoreInfoServiceImpl implements CoreInfoService {

	@Autowired
	private MyBatisDAO myBatisDAO;

	@Override
	public boolean insertCoreInfo(CoreInfo coreInfo) {
		myBatisDAO.insert(coreInfo);
		return true;
	}

	@Override
	public boolean updateCoreInfo(CoreInfo coreInfo) {
		myBatisDAO.update(coreInfo);
		return true;
	}

	@Override
	public boolean deleteCoreInfo(CoreInfo coreInfo) {
		myBatisDAO.delete(coreInfo);
		return true;
	}

	@Override
	public CoreInfo getCoreInfo(CoreInfo coreInfo) {
		return (CoreInfo) myBatisDAO.findForObject(coreInfo);
	}

//<=================定制内容开始==============
//==================定制内容结束==============>

}