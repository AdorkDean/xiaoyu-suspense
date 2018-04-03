package com.xiaoyu.suspense.vo;

import java.util.List;

public class BusiPostListVO {

	private int lastId;
	
	private List<BusiPostVO> voList;

	public int getLastId() {
		return lastId;
	}

	public void setLastId(int lastId) {
		this.lastId = lastId;
	}

	public List<BusiPostVO> getVoList() {
		return voList;
	}

	public void setVoList(List<BusiPostVO> voList) {
		this.voList = voList;
	}

}
