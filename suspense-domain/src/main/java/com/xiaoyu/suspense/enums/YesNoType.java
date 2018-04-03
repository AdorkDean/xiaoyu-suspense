package com.xiaoyu.suspense.enums;

public enum YesNoType {
	YES, NO;
	
	public String getChineseStr() {
		if (YES.equals(this))
			return "是";
		else if (NO.equals(this))
			return "否";
		else
			return "未知";
	}
}
