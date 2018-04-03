package com.xiaoyu.suspense.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.xiaoyu.suspense.service.BusiCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xiaoyu.suspense.mybatis.dao.MyBatisDAO;
import com.xiaoyu.suspense.entity.BusiComment;

@Service("busiCommentService")
public class BusiCommentServiceImpl implements BusiCommentService {

	@Autowired
	private MyBatisDAO myBatisDAO;

	@Override
	public boolean insertBusiComment(BusiComment busiComment) {
		myBatisDAO.insert(busiComment);
		return true;
	}

	@Override
	public boolean updateBusiComment(BusiComment busiComment) {
		myBatisDAO.update(busiComment);
		return true;
	}

	@Override
	public boolean deleteBusiComment(BusiComment busiComment) {
		myBatisDAO.delete(busiComment);
		return true;
	}

	@Override
	public BusiComment getBusiComment(BusiComment busiComment) {
		return (BusiComment) myBatisDAO.findForObject(busiComment);
	}

//<=================定制内容开始==============
	private static final String GET_BUSI_COMMENT_BY_STORY = "getBusiCommentByStory";
	private static final String GET_COUNT_COMMENT = "getCountComment";

	public int getCountComment(String bscotStory) {
		Map<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("bscotStory", bscotStory);
		Integer count = (Integer) myBatisDAO.findForObject(GET_COUNT_COMMENT, hashMap);
		if(count == null)
			return 0;
		return count;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<BusiComment> getBusiCommentByStory(int lastId, int limit,
			String bscotStory) {
		Map<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("lastId", lastId);
		hashMap.put("bscotStory", bscotStory);
		return myBatisDAO.findForList(GET_BUSI_COMMENT_BY_STORY, hashMap, 0, limit);
	}
//==================定制内容结束==============>

}