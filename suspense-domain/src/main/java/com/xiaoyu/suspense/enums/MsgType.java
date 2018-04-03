package com.xiaoyu.suspense.enums;

/**
 * 消息类型
 */
public enum MsgType {

	/**
	 * 每日悬疑推送消息
	 */
	SUSPENSE_PUSH_INFO,
	/**
	 * 其它推送
	 */
	OTHER;

	public String getChineseStr(){
        switch (this){
            case SUSPENSE_PUSH_INFO:
                return "每日悬疑推送消息";
            case OTHER:
                return "其它推送";
            default:
                return "";
        }
    }
}
