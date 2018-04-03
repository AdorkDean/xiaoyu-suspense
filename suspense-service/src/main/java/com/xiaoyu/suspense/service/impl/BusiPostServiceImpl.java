package com.xiaoyu.suspense.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.xiaoyu.suspense.service.BusiPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xiaoyu.suspense.mybatis.dao.MyBatisDAO;
import com.xiaoyu.suspense.entity.BusiPost;

@Service("busiPostService")
public class BusiPostServiceImpl implements BusiPostService {

	@Autowired
	private MyBatisDAO myBatisDAO;

	@Override
	public boolean insertBusiPost(BusiPost busiPost) {
		myBatisDAO.insert(busiPost);
		return true;
	}

	@Override
	public boolean updateBusiPost(BusiPost busiPost) {
		myBatisDAO.update(busiPost);
		return true;
	}

	@Override
	public boolean deleteBusiPost(BusiPost busiPost) {
		myBatisDAO.delete(busiPost);
		return true;
	}

	@Override
	public BusiPost getBusiPost(BusiPost busiPost) {
		return (BusiPost) myBatisDAO.findForObject(busiPost);
	}

//<=================定制内容开始==============
	private static final String GET_COUNT_BUSI_POST_BY_MY = "getCountBusiPostByMy";
	private static final String GET_BUSI_POST_BY_MY = "getBusiPostByMy";
	private static final String UPDATE_BUSI_POST_GOOD = "updateBusiPostGood";
	
	@Override
	public Integer getCountBusiPostByMy(String userUuid) {
		Map<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("userUuid", userUuid);
		return (Integer) myBatisDAO.findForObject(GET_COUNT_BUSI_POST_BY_MY, hashMap);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<BusiPost> getBusiPostByMy(String userUuid, int lastId, int limit) {
		Map<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("lastId", lastId);
		hashMap.put("userUuid", userUuid);
		return myBatisDAO.findForList(GET_BUSI_POST_BY_MY, hashMap, 0, limit);
	}
	
	@Override
	public boolean updateBusiPostGood(String bspstUuid) {
		Map<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("bspstUuid", bspstUuid);
		myBatisDAO.update(UPDATE_BUSI_POST_GOOD, hashMap);
		return true;
	}
//==================定制内容结束==============>

}