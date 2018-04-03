package com.xiaoyu.suspense.vo;

import java.util.List;

public class BusiSuspenseStoryListVO {

	private int lastId;
	
	private List<BusiSuspenseStoryVO> voList;

	public int getLastId() {
		return lastId;
	}

	public void setLastId(int lastId) {
		this.lastId = lastId;
	}

	public List<BusiSuspenseStoryVO> getVoList() {
		return voList;
	}

	public void setVoList(List<BusiSuspenseStoryVO> voList) {
		this.voList = voList;
	}

}