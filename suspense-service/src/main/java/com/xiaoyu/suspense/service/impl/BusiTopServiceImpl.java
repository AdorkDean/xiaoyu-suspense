package com.xiaoyu.suspense.service.impl;

import com.xiaoyu.suspense.service.BusiTopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xiaoyu.suspense.mybatis.dao.MyBatisDAO;
import com.xiaoyu.suspense.entity.BusiTop;

@Service("busiTopService")
public class BusiTopServiceImpl implements BusiTopService {

	@Autowired
	private MyBatisDAO myBatisDAO;

	@Override
	public boolean insertBusiTop(BusiTop busiTop) {
		myBatisDAO.insert(busiTop);
		return true;
	}

	@Override
	public boolean updateBusiTop(BusiTop busiTop) {
		myBatisDAO.update(busiTop);
		return true;
	}

	@Override
	public boolean deleteBusiTop(BusiTop busiTop) {
		myBatisDAO.delete(busiTop);
		return true;
	}

	@Override
	public BusiTop getBusiTop(BusiTop busiTop) {
		return (BusiTop) myBatisDAO.findForObject(busiTop);
	}

//<=================定制内容开始==============
	private static final String GET_BUSI_TOP_BY_USER_AND_BUSI = "getBusiTopByUserAndBusi";
	
	@Override
	public BusiTop getBusiTopByUserAndBusi(BusiTop busiTop) {
		return (BusiTop) myBatisDAO.findForObject(GET_BUSI_TOP_BY_USER_AND_BUSI, busiTop);
	}
//==================定制内容结束==============>

}