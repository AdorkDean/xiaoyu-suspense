package com.xiaoyu.suspense.service.impl;

import com.xiaoyu.suspense.service.CoreLlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xiaoyu.suspense.mybatis.dao.MyBatisDAO;
import com.xiaoyu.suspense.entity.CoreLlog;

@Service("coreLlogService")
public class CoreLlogServiceImpl implements CoreLlogService {

	@Autowired
	private MyBatisDAO myBatisDAO;

	@Override
	public boolean insertCoreLlog(CoreLlog coreLlog) {
		myBatisDAO.insert(coreLlog);
		return true;
	}

	@Override
	public boolean updateCoreLlog(CoreLlog coreLlog) {
		myBatisDAO.update(coreLlog);
		return true;
	}

	@Override
	public boolean deleteCoreLlog(CoreLlog coreLlog) {
		myBatisDAO.delete(coreLlog);
		return true;
	}

	@Override
	public CoreLlog getCoreLlog(CoreLlog coreLlog) {
		return (CoreLlog) myBatisDAO.findForObject(coreLlog);
	}

//<=================定制内容开始==============
//==================定制内容结束==============>

}