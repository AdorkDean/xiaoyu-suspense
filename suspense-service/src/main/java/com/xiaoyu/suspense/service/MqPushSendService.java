package com.xiaoyu.suspense.service;

import com.xiaoyu.suspense.entity.push.MqPushMessage;

public interface MqPushSendService {

	/**
	 * 发送mq信息
	 * @param mqMessage
	 */
	void sendMqPush(MqPushMessage mqMessage);
}
