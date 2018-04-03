package com.xiaoyu.suspense.job;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.quartz.QuartzJobBean;
import com.xiaoyu.suspense.entity.BusiSuspenseContent;
import com.xiaoyu.suspense.entity.BusiSuspenseStory;
import com.xiaoyu.suspense.service.BusiSuspenseContentService;
import com.xiaoyu.suspense.service.BusiSuspenseStoryService;
import com.xiaoyu.suspense.util.GetSuspenseWebUtil;
import com.xiaoyu.suspense.util.RandomUtil;

public class GetSuspenseWebJob extends QuartzJobBean{

	private final Logger logger = LoggerFactory.getLogger("BASE_LOGGER");
	
	private BusiSuspenseStoryService  busiSuspenseStoryService;
	
	private BusiSuspenseContentService  busiSuspenseContentService;
	
	private RedisTemplate<Object,Object> redisTemplate;

	public void setBusiSuspenseStoryService(
			BusiSuspenseStoryService busiSuspenseStoryService) {
		this.busiSuspenseStoryService = busiSuspenseStoryService;
	}

	public void setBusiSuspenseContentService(
			BusiSuspenseContentService busiSuspenseContentService) {
		this.busiSuspenseContentService = busiSuspenseContentService;
	}

	public void setRedisTemplate(RedisTemplate<Object, Object> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}
	
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		//悬疑故事：http://www.gushijiuba.com/chuanqigushi/xuanyigushi/list_18_84.html
		Object item = redisTemplate.opsForValue().get("XUANYI_ITEM");
		if (item == null) {
			item = 84;
		}
		if((int)item == 0) {
			return;
		}
		Map<String, List<String>> hashMap = GetSuspenseWebUtil.getSuspenseUrl("http://www.gushijiuba.com/chuanqigushi/xuanyigushi/list_18_"+ item +".html");
		List<String> strUrlList = hashMap.get("strUrlList");
		List<String> strTitleList = hashMap.get("strTitleList");
		List<String> strDescList = hashMap.get("strDescList");
		List<String> strContentList = new ArrayList<>();
		for(int i = 0; i < strUrlList.size(); i++) {
			//添加标题和描述到悬疑故事表
			BusiSuspenseStory busiSuspenseStory = new BusiSuspenseStory();
			busiSuspenseStory.setBsssyCdate(new Date());
			busiSuspenseStory.setBsssySummary(strDescList.get(i));
			String title = strTitleList.get(i);
			busiSuspenseStory.setBsssyTitle(title);
			busiSuspenseStory.setBsssyUp(0);
			String storyUuid = RandomUtil.generateUpperString(32);
			busiSuspenseStory.setBsssyUuid(storyUuid);
			busiSuspenseStoryService.insertBusiSuspenseStory(busiSuspenseStory);
			logger.info("[GetSuspenseWebJob: " + title);
			
			strContentList = new ArrayList<>();
			strContentList = GetSuspenseWebUtil.getSuspenseContent(strUrlList.get(i));
			BusiSuspenseContent busiSuspenseContent = new BusiSuspenseContent();
			int j = 1;
			for(String strContent : strContentList) {
				//添加内容到悬疑故事内容表
				busiSuspenseContent = new BusiSuspenseContent();
				busiSuspenseContent.setBssctContent(strContent);
				busiSuspenseContent.setBssctOrd(j);
				busiSuspenseContent.setBssctStory(storyUuid);
				busiSuspenseContent.setBssctUuid(RandomUtil.generateUpperString(32));
				busiSuspenseContentService.insertBusiSuspenseContent(busiSuspenseContent);
				logger.info("[GetSuspenseWebJob:" + title + "_第" + j + "页");
				j++;
			}			
		}	
		redisTemplate.opsForValue().set("XUANYI_ITEM", (int)item - 1);
	}
	
}