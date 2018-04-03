package com.xiaoyu.suspense.service.impl;

import com.xiaoyu.suspense.service.BusiFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xiaoyu.suspense.mybatis.dao.MyBatisDAO;
import com.xiaoyu.suspense.entity.BusiFeedback;

@Service("busiFeedbackService")
public class BusiFeedbackServiceImpl implements BusiFeedbackService {

	@Autowired
	private MyBatisDAO myBatisDAO;

	@Override
	public boolean insertBusiFeedback(BusiFeedback busiFeedback) {
		myBatisDAO.insert(busiFeedback);
		return true;
	}

	@Override
	public boolean updateBusiFeedback(BusiFeedback busiFeedback) {
		myBatisDAO.update(busiFeedback);
		return true;
	}

	@Override
	public boolean deleteBusiFeedback(BusiFeedback busiFeedback) {
		myBatisDAO.delete(busiFeedback);
		return true;
	}

	@Override
	public BusiFeedback getBusiFeedback(BusiFeedback busiFeedback) {
		return (BusiFeedback) myBatisDAO.findForObject(busiFeedback);
	}

//<=================定制内容开始==============
//==================定制内容结束==============>

}