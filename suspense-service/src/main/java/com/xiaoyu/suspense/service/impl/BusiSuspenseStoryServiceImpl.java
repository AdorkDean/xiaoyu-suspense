package com.xiaoyu.suspense.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.xiaoyu.suspense.service.BusiSuspenseStoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xiaoyu.suspense.mybatis.dao.MyBatisDAO;
import com.xiaoyu.suspense.entity.BusiSuspenseStory;

@Service("busiSuspenseStoryService")
public class BusiSuspenseStoryServiceImpl implements BusiSuspenseStoryService {

	@Autowired
	private MyBatisDAO myBatisDAO;

	@Override
	public boolean insertBusiSuspenseStory(BusiSuspenseStory busiSuspenseStory) {
		myBatisDAO.insert(busiSuspenseStory);
		return true;
	}

	@Override
	public boolean updateBusiSuspenseStory(BusiSuspenseStory busiSuspenseStory) {
		myBatisDAO.update(busiSuspenseStory);
		return true;
	}

	@Override
	public boolean deleteBusiSuspenseStory(BusiSuspenseStory busiSuspenseStory) {
		myBatisDAO.delete(busiSuspenseStory);
		return true;
	}

	@Override
	public BusiSuspenseStory getBusiSuspenseStory(BusiSuspenseStory busiSuspenseStory) {
		return (BusiSuspenseStory) myBatisDAO.findForObject(busiSuspenseStory);
	}

//<=================定制内容开始==============
	private static final String GET_BUSI_SUSPENSE_STORY_BY_LAST_ID = "getBusiSuspenseStoryByLastId";
	private static final String UPDATE_BUSI_SUSPENSE_STORY_GOOD = "updateBusiSuspenseStoryGood";
	
	@SuppressWarnings("unchecked")
	@Override
	public List<BusiSuspenseStory> getBusiSuspenseStoryByLastId(int lastId,
			int limit) {
		Map<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("lastId", lastId);
		return myBatisDAO.findForList(GET_BUSI_SUSPENSE_STORY_BY_LAST_ID, hashMap, 0, limit);
	}

	@Override
	public boolean updateBusiSuspenseStoryGood(String bsssyUuid) {
		Map<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("bsssyUuid", bsssyUuid);
		myBatisDAO.update(UPDATE_BUSI_SUSPENSE_STORY_GOOD, hashMap);
		return true;
	}
//==================定制内容结束==============>

}