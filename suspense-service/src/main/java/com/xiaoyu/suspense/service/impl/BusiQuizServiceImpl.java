package com.xiaoyu.suspense.service.impl;

import java.util.HashMap;
import java.util.Map;
import com.xiaoyu.suspense.service.BusiQuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xiaoyu.suspense.mybatis.dao.MyBatisDAO;
import com.xiaoyu.suspense.entity.BusiQuiz;

@Service("busiQuizService")
public class BusiQuizServiceImpl implements BusiQuizService {

	@Autowired
	private MyBatisDAO myBatisDAO;

	@Override
	public boolean insertBusiQuiz(BusiQuiz busiQuiz) {
		myBatisDAO.insert(busiQuiz);
		return true;
	}

	@Override
	public boolean updateBusiQuiz(BusiQuiz busiQuiz) {
		myBatisDAO.update(busiQuiz);
		return true;
	}

	@Override
	public boolean deleteBusiQuiz(BusiQuiz busiQuiz) {
		myBatisDAO.delete(busiQuiz);
		return true;
	}

	@Override
	public BusiQuiz getBusiQuiz(BusiQuiz busiQuiz) {
		return (BusiQuiz) myBatisDAO.findForObject(busiQuiz);
	}

//<=================定制内容开始==============
	private static final String GET_COUNT_BUSI_QUIZ_BY_MY = "getCountBusiQuizByMy";
	private static final String GET_BUSI_QUIZ_BY_USER_AND_SUSPENSE = "getBusiQuizByUserAndSuspense";
	
	@Override
	public Integer getCountBusiQuizByMy(String userUuid) {
		Map<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("userUuid", userUuid);
		return (Integer) myBatisDAO.findForObject(GET_COUNT_BUSI_QUIZ_BY_MY, hashMap);
	}
	
	@Override
	public BusiQuiz getBusiQuizByUserAndSuspense(String bsqizUser,
			String bsqizSuspense) {
		Map<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("bsqizUser", bsqizUser);
		hashMap.put("bsqizSuspense", bsqizSuspense);
		return (BusiQuiz) myBatisDAO.findForObject(GET_BUSI_QUIZ_BY_USER_AND_SUSPENSE, hashMap);
	}
//==================定制内容结束==============>

}