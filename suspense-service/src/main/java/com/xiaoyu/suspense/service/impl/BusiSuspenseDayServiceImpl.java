package com.xiaoyu.suspense.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.xiaoyu.suspense.service.BusiSuspenseDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xiaoyu.suspense.mybatis.dao.MyBatisDAO;
import com.xiaoyu.suspense.entity.BusiSuspenseDay;

@Service("busiSuspenseDayService")
public class BusiSuspenseDayServiceImpl implements BusiSuspenseDayService {

	@Autowired
	private MyBatisDAO myBatisDAO;

	@Override
	public boolean insertBusiSuspenseDay(BusiSuspenseDay busiSuspenseDay) {
		myBatisDAO.insert(busiSuspenseDay);
		return true;
	}

	@Override
	public boolean updateBusiSuspenseDay(BusiSuspenseDay busiSuspenseDay) {
		myBatisDAO.update(busiSuspenseDay);
		return true;
	}

	@Override
	public boolean deleteBusiSuspenseDay(BusiSuspenseDay busiSuspenseDay) {
		myBatisDAO.delete(busiSuspenseDay);
		return true;
	}

	@Override
	public BusiSuspenseDay getBusiSuspenseDay(BusiSuspenseDay busiSuspenseDay) {
		return (BusiSuspenseDay) myBatisDAO.findForObject(busiSuspenseDay);
	}

//<=================定制内容开始==============
	private static final String GET_BUSI_SUSPENSE_DAY_BY_DAY = "getBusiSuspenseDayByDay";
	private static final String GET_SUSPENSE_DAY_BY_DAY = "getSuspenseDayByDay";
	private static final String GET_SUSPENSE_DAY_BY_MY_QUIZ = "getSuspenseDayByMyQuiz";
	private static final String GET_SUSPENSE_DAY_BY_MY_COLLECT = "getSuspenseDayByMyCollect";
	
	@SuppressWarnings("unchecked")
	@Override
	public List<BusiSuspenseDay> getBusiSuspenseDayByDay() {
		return myBatisDAO.findForList(GET_BUSI_SUSPENSE_DAY_BY_DAY, null);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<BusiSuspenseDay> getSuspenseDayByDay(String bssdyDay) {
		Map<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("bssdyDay", bssdyDay);
		return myBatisDAO.findForList(GET_SUSPENSE_DAY_BY_DAY, hashMap);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BusiSuspenseDay> getSuspenseDayByMyQuiz(int lastId, int limit,
			String userUuid) {
		Map<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("lastId", lastId);
		hashMap.put("userUuid", userUuid);
		return myBatisDAO.findForList(GET_SUSPENSE_DAY_BY_MY_QUIZ, hashMap, 0, limit);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BusiSuspenseDay> getSuspenseDayByMyCollect(int lastId,
			int limit, String userUuid) {
		Map<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("lastId", lastId);
		hashMap.put("userUuid", userUuid);
		return myBatisDAO.findForList(GET_SUSPENSE_DAY_BY_MY_COLLECT, hashMap, 0, limit);
	}
//==================定制内容结束==============>

}