package com.xiaoyu.suspense.service.impl;

import com.xiaoyu.suspense.service.CoreRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xiaoyu.suspense.mybatis.dao.MyBatisDAO;
import com.xiaoyu.suspense.entity.CoreRole;

@Service("coreRoleService")
public class CoreRoleServiceImpl implements CoreRoleService {

	@Autowired
	private MyBatisDAO myBatisDAO;

	@Override
	public boolean insertCoreRole(CoreRole coreRole) {
		myBatisDAO.insert(coreRole);
		return true;
	}

	@Override
	public boolean updateCoreRole(CoreRole coreRole) {
		myBatisDAO.update(coreRole);
		return true;
	}

	@Override
	public boolean deleteCoreRole(CoreRole coreRole) {
		myBatisDAO.delete(coreRole);
		return true;
	}

	@Override
	public CoreRole getCoreRole(CoreRole coreRole) {
		return (CoreRole) myBatisDAO.findForObject(coreRole);
	}

//<=================定制内容开始==============
//==================定制内容结束==============>

}