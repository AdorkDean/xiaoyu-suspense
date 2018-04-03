package com.xiaoyu.suspense.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.xiaoyu.suspense.controller.BaseController;
import com.xiaoyu.suspense.entity.BusiSuspenseStory;
import com.xiaoyu.suspense.entity.BusiTop;
import com.xiaoyu.suspense.enums.BusiType;
import com.xiaoyu.suspense.service.BusiCommentService;
import com.xiaoyu.suspense.service.BusiSuspenseStoryService;
import com.xiaoyu.suspense.service.BusiTopService;
import com.xiaoyu.suspense.util.RandomUtil;
import com.xiaoyu.suspense.util.ResultMessageBuilder;
import com.xiaoyu.suspense.util.StringUtil;
import com.xiaoyu.suspense.vo.BusiSuspenseStoryListVO;
import com.xiaoyu.suspense.vo.BusiSuspenseStoryVO;

@Controller
@RequestMapping(value="/busiSuspenseStory")
public class BusiSuspenseStoryController extends BaseController {

//<=================定制内容开始==============	
	@Autowired
	private BusiSuspenseStoryService  busiSuspenseStoryService;
	
	@Autowired
	private BusiCommentService  busiCommentService;
	
	@Autowired
	private BusiTopService busiTopService;
	
	/**
	 * 悬疑故事列表
	 * @param lastId
	 * @param limit
	 * @return
	 */
	@RequestMapping(value="/suspense/story/list", method=RequestMethod.POST)
	public void findSuspenseStoryList(Integer lastId, int limit, HttpServletResponse response) {
		logger.info("[BusiSuspenseStoryController.findSuspenseStoryList]:findSuspenseStoryList begin");
		if(lastId == null) {
			lastId = Integer.MAX_VALUE;
		}

		BusiSuspenseStoryListVO busiSuspenseStoryListVO = new BusiSuspenseStoryListVO();
		List<BusiSuspenseStory> busiSuspenseStoryList = busiSuspenseStoryService.getBusiSuspenseStoryByLastId(lastId, limit);
		if(busiSuspenseStoryList == null || busiSuspenseStoryList.size() <= 0) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(false, "无数据！", busiSuspenseStoryListVO), response);
			return;
		}
		BusiSuspenseStoryVO vo = new BusiSuspenseStoryVO();
		List<BusiSuspenseStoryVO> voList = new ArrayList<BusiSuspenseStoryVO>();
		for(BusiSuspenseStory busiSuspenseStory : busiSuspenseStoryList) {
			if(busiSuspenseStory.getBsssyUnid() < lastId) {
				lastId = busiSuspenseStory.getBsssyUnid();
			}
			vo = new BusiSuspenseStoryVO();
			vo.convertPOToVO(busiSuspenseStory);
			vo.setCountComment(busiCommentService.getCountComment(busiSuspenseStory.getBsssyUuid()));
			voList.add(vo);
		}
		busiSuspenseStoryListVO.setLastId(lastId);
		busiSuspenseStoryListVO.setVoList(voList);
		writeAjaxJSONResponse(ResultMessageBuilder.build(true, "", busiSuspenseStoryListVO), response);
	}
	
	/**
	 * 悬疑故事顶
	 * @param bsssyUuid
	 * @param userUuid
	 * @return
	 */
	@RequestMapping(value="/suspense/story/good", method=RequestMethod.POST)
	public void goodSuspenseStory(String bsssyUuid, String userUuid, HttpServletResponse response) {
		logger.info("[BusiSuspenseStoryController.goodSuspenseStory]:goodSuspenseStory begin");
		if(StringUtil.isEmpty(bsssyUuid)) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(false, "缺少bsssyUuid参数!"), response);
			return;
		}
		BusiTop busiTop = new BusiTop();
		busiTop.setBstopBusi(bsssyUuid);
		busiTop.setBstopBusiType(BusiType.SUSPENSE_STORY);
		busiTop.setBstopUser(userUuid);
		busiTop = busiTopService.getBusiTopByUserAndBusi(busiTop);
		if(busiTop != null && busiTop.getBstopUuid() != null) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(false, "已经顶过！"), response);
		}else {
			busiTop = new BusiTop();
			busiTop.setBstopBusi(bsssyUuid);
			busiTop.setBstopBusiType(BusiType.SUSPENSE_STORY);
			busiTop.setBstopUser(userUuid);
			busiTop.setBstopTime(new Date());
			busiTop.setBstopUuid(RandomUtil.generateUpperString(32));
			busiTopService.insertBusiTop(busiTop);
			busiSuspenseStoryService.updateBusiSuspenseStoryGood(bsssyUuid);
			writeAjaxJSONResponse(ResultMessageBuilder.build(true, "SUCCESS！"), response);
		}
	}
//==================定制内容结束==============>

}