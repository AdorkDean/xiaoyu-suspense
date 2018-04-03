package com.xiaoyu.suspense.job;

import java.util.List;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;
import com.xiaoyu.suspense.entity.BusiSuspenseDay;
import com.xiaoyu.suspense.enums.MsgType;
import com.xiaoyu.suspense.service.BusiSuspenseDayService;
import com.xiaoyu.suspense.service.MqPushService;
//import com.xiaoyu.suspense.util.BaiduYunPushUtil;

public class PushSuspenseJob extends QuartzJobBean{

	private final Logger logger = LoggerFactory.getLogger("PUSH_LOGGER");
	
	private BusiSuspenseDayService busiSuspenseDayService;
	
	private MqPushService mqPushService;

	public void setBusiSuspenseDayService(
			BusiSuspenseDayService busiSuspenseDayService) {
		this.busiSuspenseDayService = busiSuspenseDayService;
	}

	public void setMqPushService(MqPushService mqPushService) {
		this.mqPushService = mqPushService;
	}

	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		
		List<BusiSuspenseDay> list = busiSuspenseDayService.getBusiSuspenseDayByDay();
		if(list != null && list.size() > 0) {
			for (BusiSuspenseDay busiSuspenseDay : list) {				
				//每日悬疑推送加入MQ,推送
				String content = busiSuspenseDay.getBssdyContent();
				if(content.length() >= 20) {
					content = content.substring(0, 17) +"...";
				}
				logger.info("begin to push BusiSuspenseDay BssdyUuid:" + busiSuspenseDay.getBssdyUuid() +" content:" + content);
				mqPushService.addMqMessage(1, busiSuspenseDay.getBssdyUuid(), content, "", "", MsgType.SUSPENSE_PUSH_INFO);
				//BaiduYunPushUtil.androidPushBroadcast(BaiduYunPushUtil.generateAndroidPushContent(busiSuspenseDay.getBssdyUuid(), content, BaiduYunPushUtil.psTypeMap.get(MsgType.SUSPENSE_PUSH_INFO)));
				//BaiduYunPushUtil.iosPushBroadcast(BaiduYunPushUtil.generateIosPushContent(busiSuspenseDay.getBssdyUuid(), content, BaiduYunPushUtil.psTypeMap.get(MsgType.SUSPENSE_PUSH_INFO)));
				logger.info("finish to push BusiSuspenseDay BssdyUuid:" + busiSuspenseDay.getBssdyUuid() +" content:" + content);
			}
		}
	}

}