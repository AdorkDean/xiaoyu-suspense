package com.xiaoyu.suspense.vo;

import java.util.List;

public class BusiNotechatListVO {

	private int lastId;
	
	private List<BusiNotechatVO> voList;

	public int getLastId() {
		return lastId;
	}

	public void setLastId(int lastId) {
		this.lastId = lastId;
	}

	public List<BusiNotechatVO> getVoList() {
		return voList;
	}

	public void setVoList(List<BusiNotechatVO> voList) {
		this.voList = voList;
	}

}