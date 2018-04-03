package com.xiaoyu.suspense.vo;

import java.util.List;

public class BusiSuspenseDayListVO {

	private int lastId;
	
	private List<BusiSuspenseDayVO> voList;

	public int getLastId() {
		return lastId;
	}

	public void setLastId(int lastId) {
		this.lastId = lastId;
	}

	public List<BusiSuspenseDayVO> getVoList() {
		return voList;
	}

	public void setVoList(List<BusiSuspenseDayVO> voList) {
		this.voList = voList;
	}

}