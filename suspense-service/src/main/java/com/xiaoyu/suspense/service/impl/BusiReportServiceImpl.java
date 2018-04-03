package com.xiaoyu.suspense.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.xiaoyu.suspense.service.BusiReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xiaoyu.suspense.mybatis.dao.MyBatisDAO;
import com.xiaoyu.suspense.entity.BusiReport;

@Service("busiReportService")
public class BusiReportServiceImpl implements BusiReportService {

	@Autowired
	private MyBatisDAO myBatisDAO;

	@Override
	public boolean insertBusiReport(BusiReport busiReport) {
		myBatisDAO.insert(busiReport);
		return true;
	}

	@Override
	public boolean updateBusiReport(BusiReport busiReport) {
		myBatisDAO.update(busiReport);
		return true;
	}

	@Override
	public boolean deleteBusiReport(BusiReport busiReport) {
		myBatisDAO.delete(busiReport);
		return true;
	}

	@Override
	public BusiReport getBusiReport(BusiReport busiReport) {
		return (BusiReport) myBatisDAO.findForObject(busiReport);
	}

//<=================定制内容开始==============
	private static final String GET_BUSI_REPORT_BY_USER_AND_USER = "getBusiReportByUserAndUser";
	private static final String DELETE_BUSI_REPORT_BY_USER_AND_USER = "deleteBusiReportByUserAndUser";
	private static final String GET_BUSI_REPORT_BY_REPORT = "getBusiReportByReport";
	
	@Override
	public BusiReport getBusiReportByUserAndUser(BusiReport busiReport) {
		return (BusiReport) myBatisDAO.findForObject(GET_BUSI_REPORT_BY_USER_AND_USER, busiReport);
	}

	@Override
	public boolean deleteBusiReportByUserAndUser(String bsrptAttention,
			String bsrptBeAttention) {
		Map<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("bsrptAttention", bsrptAttention);
		hashMap.put("bsrptBeAttention", bsrptBeAttention);
		myBatisDAO.delete(DELETE_BUSI_REPORT_BY_USER_AND_USER, hashMap);
		return true;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<BusiReport> getBusiReportByReport(String bsrptAttention,
			String bsrptBeAttention, int lastId, int limit) {
		Map<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("bsrptAttention", bsrptAttention);
		hashMap.put("bsrptBeAttention", bsrptBeAttention);
		hashMap.put("lastId", lastId);
		return myBatisDAO.findForList(GET_BUSI_REPORT_BY_REPORT, hashMap, 0, limit);
	}

//==================定制内容结束==============>

}