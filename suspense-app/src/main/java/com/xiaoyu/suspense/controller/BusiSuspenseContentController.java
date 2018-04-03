package com.xiaoyu.suspense.controller;

import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.xiaoyu.suspense.controller.BaseController;
import com.xiaoyu.suspense.entity.BusiSuspenseContent;
import com.xiaoyu.suspense.service.BusiSuspenseContentService;
import com.xiaoyu.suspense.util.ResultMessageBuilder;
import com.xiaoyu.suspense.util.StringUtil;
import com.xiaoyu.suspense.vo.BusiSuspenseContentVO;

@Controller
@RequestMapping(value="/busiSuspenseContent")
public class BusiSuspenseContentController extends BaseController {

//<=================定制内容开始==============
	@Autowired
	private BusiSuspenseContentService  busiSuspenseContentService;
	
	/**
	 * 悬疑故事详情
	 * @param bssctOrd
	 * @param bssctStory
	 * @return
	 */
	@RequestMapping(value="/suspense/content/detail", method=RequestMethod.POST)
	public void findSuspenseContentDetail(Integer bssctOrd, String bssctStory, HttpServletResponse response) {
		logger.info("[BusiSuspenseContentController.findSuspenseContentDetail]:findSuspenseContentDetail begin");
		if(StringUtil.isEmpty(bssctStory)) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(false, "缺少故事Uuid参数！"), response);
			return;
		}
		if(bssctOrd == null) {
			bssctOrd = 1;
		}
		BusiSuspenseContent busiSuspenseContent = new BusiSuspenseContent();
		busiSuspenseContent.setBssctOrd(bssctOrd);
		busiSuspenseContent.setBssctStory(bssctStory);
		busiSuspenseContent = busiSuspenseContentService.getBusiSuspenseContentByOrd(busiSuspenseContent);
		if(busiSuspenseContent == null) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(false, "无该悬疑故事详情！"), response);
			return;
		}
		BusiSuspenseContentVO vo = new BusiSuspenseContentVO();
		vo.convertPOToVO(busiSuspenseContent);
		vo.setPageSize(busiSuspenseContentService.getCountContent(bssctStory));
		writeAjaxJSONResponse(ResultMessageBuilder.build(true, "", vo), response);
	}
//==================定制内容结束==============>

}