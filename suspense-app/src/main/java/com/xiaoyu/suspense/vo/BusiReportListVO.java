package com.xiaoyu.suspense.vo;

import java.util.List;

public class BusiReportListVO {

	private int lastId;
	
	private List<BusiReportVO> voList;

	public int getLastId() {
		return lastId;
	}

	public void setLastId(int lastId) {
		this.lastId = lastId;
	}

	public List<BusiReportVO> getVoList() {
		return voList;
	}

	public void setVoList(List<BusiReportVO> voList) {
		this.voList = voList;
	}

}