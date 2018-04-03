package com.xiaoyu.suspense.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.xiaoyu.suspense.service.BusiFollowPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xiaoyu.suspense.mybatis.dao.MyBatisDAO;
import com.xiaoyu.suspense.entity.BusiFollowPost;

@Service("busiFollowPostService")
public class BusiFollowPostServiceImpl implements BusiFollowPostService {

	@Autowired
	private MyBatisDAO myBatisDAO;

	@Override
	public boolean insertBusiFollowPost(BusiFollowPost busiFollowPost) {
		myBatisDAO.insert(busiFollowPost);
		return true;
	}

	@Override
	public boolean updateBusiFollowPost(BusiFollowPost busiFollowPost) {
		myBatisDAO.update(busiFollowPost);
		return true;
	}

	@Override
	public boolean deleteBusiFollowPost(BusiFollowPost busiFollowPost) {
		myBatisDAO.delete(busiFollowPost);
		return true;
	}

	@Override
	public BusiFollowPost getBusiFollowPost(BusiFollowPost busiFollowPost) {
		return (BusiFollowPost) myBatisDAO.findForObject(busiFollowPost);
	}

//<=================定制内容开始==============
	private static final String GET_BUSI_FOLLOW_POST_BY_POST = "getBusiFollowPostByPost";
	private static final String GET_COUNT_FOLLOW_POSTT = "getCountFollowPost";
	
	@SuppressWarnings("unchecked")
	@Override
	public List<BusiFollowPost> getBusiFollowPostByPost(String bsfptPost,
			int lastId, int limit) {
		Map<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("lastId", lastId);
		hashMap.put("bsfptPost", bsfptPost);
		return myBatisDAO.findForList(GET_BUSI_FOLLOW_POST_BY_POST, hashMap, 0, limit);
	}
	
	@Override
	public Integer getCountFollowPost(String bsfptPost) {
		Map<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("bsfptPost", bsfptPost);
		Integer count = (Integer) myBatisDAO.findForObject(GET_COUNT_FOLLOW_POSTT, hashMap);
		if(count == null)
			return 0;
		return count;
	}
//==================定制内容结束==============>

}