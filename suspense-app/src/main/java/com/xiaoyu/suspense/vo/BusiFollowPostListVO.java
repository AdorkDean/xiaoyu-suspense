package com.xiaoyu.suspense.vo;

import java.util.List;

public class BusiFollowPostListVO {

	private int lastId;
	
	private List<BusiFollowPostVO> voList;

	public int getLastId() {
		return lastId;
	}

	public void setLastId(int lastId) {
		this.lastId = lastId;
	}

	public List<BusiFollowPostVO> getVoList() {
		return voList;
	}

	public void setVoList(List<BusiFollowPostVO> voList) {
		this.voList = voList;
	}

}
