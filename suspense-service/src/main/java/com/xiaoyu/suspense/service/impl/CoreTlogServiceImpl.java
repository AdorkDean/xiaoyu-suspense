package com.xiaoyu.suspense.service.impl;

import com.xiaoyu.suspense.service.CoreTlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xiaoyu.suspense.mybatis.dao.MyBatisDAO;
import com.xiaoyu.suspense.entity.CoreTlog;

@Service("coreTlogService")
public class CoreTlogServiceImpl implements CoreTlogService {

	@Autowired
	private MyBatisDAO myBatisDAO;

	@Override
	public boolean insertCoreTlog(CoreTlog coreTlog) {
		myBatisDAO.insert(coreTlog);
		return true;
	}

	@Override
	public boolean updateCoreTlog(CoreTlog coreTlog) {
		myBatisDAO.update(coreTlog);
		return true;
	}

	@Override
	public boolean deleteCoreTlog(CoreTlog coreTlog) {
		myBatisDAO.delete(coreTlog);
		return true;
	}

	@Override
	public CoreTlog getCoreTlog(CoreTlog coreTlog) {
		return (CoreTlog) myBatisDAO.findForObject(coreTlog);
	}

//<=================定制内容开始==============
//==================定制内容结束==============>

}