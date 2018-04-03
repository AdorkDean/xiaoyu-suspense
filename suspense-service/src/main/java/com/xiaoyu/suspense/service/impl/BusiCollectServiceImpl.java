package com.xiaoyu.suspense.service.impl;

import java.util.HashMap;
import java.util.Map;
import com.xiaoyu.suspense.service.BusiCollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xiaoyu.suspense.mybatis.dao.MyBatisDAO;
import com.xiaoyu.suspense.entity.BusiCollect;

@Service("busiCollectService")
public class BusiCollectServiceImpl implements BusiCollectService {

	@Autowired
	private MyBatisDAO myBatisDAO;

	@Override
	public boolean insertBusiCollect(BusiCollect busiCollect) {
		myBatisDAO.insert(busiCollect);
		return true;
	}

	@Override
	public boolean updateBusiCollect(BusiCollect busiCollect) {
		myBatisDAO.update(busiCollect);
		return true;
	}

	@Override
	public boolean deleteBusiCollect(BusiCollect busiCollect) {
		myBatisDAO.delete(busiCollect);
		return true;
	}

	@Override
	public BusiCollect getBusiCollect(BusiCollect busiCollect) {
		return (BusiCollect) myBatisDAO.findForObject(busiCollect);
	}
//<=================定制内容开始==============	
	private static final String GET_BUSI_COLLECT_BY_USER_AND_SUSPENSE = "getBusiCollectByUserAndSuspense";
	private static final String DELETE_BUSI_COLLECT_BY_SUSPENSE_AND_USER = "deleteBusiCollectBySuspenseAndUser";
	private static final String GET_COUNT_BUSI_COLLECT_BY_MY = "getCountBusiCollectByMy";
	
	@Override
	public BusiCollect getBusiCollectByUserAndSuspense(BusiCollect busiCollect) {
		return (BusiCollect) myBatisDAO.findForObject(GET_BUSI_COLLECT_BY_USER_AND_SUSPENSE, busiCollect);
	}
	
	@Override
	public boolean deleteBusiCollectBySuspenseAndUser(String bscltSuspense,
			String bscltUser) {
		Map<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("bscltSuspense", bscltSuspense);
		hashMap.put("bscltUser", bscltUser);
		myBatisDAO.delete(DELETE_BUSI_COLLECT_BY_SUSPENSE_AND_USER, hashMap);
		return true;
	}
	
	@Override
	public Integer getCountBusiCollectByMy(String userUuid) {
		Map<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("userUuid", userUuid);
		return (Integer) myBatisDAO.findForObject(GET_COUNT_BUSI_COLLECT_BY_MY, hashMap);
	}
//==================定制内容结束==============>

}