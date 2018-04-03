package com.xiaoyu.suspense.enums;

/**
 * 业务类型
 * @author Administrator
 */
public enum BusiType {

	/**
	 * 悬疑故事
	 */
	SUSPENSE_STORY,
	/**
	 * 悬疑社区
	 */
	SUSPENSE_COMMUNITY,
	/**
	 * 其它
	 */
	OTHER;

	public String getChineseStr(){
        switch (this){
            case SUSPENSE_STORY:
                return "悬疑故事";
            case SUSPENSE_COMMUNITY:
                return "悬疑社区";
            case OTHER:
                return "其它";
            default:
                return "";
        }
    }
	
}