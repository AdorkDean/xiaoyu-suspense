package com.xiaoyu.suspense.controller;

import java.util.Date;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.xiaoyu.suspense.controller.BaseController;
import com.xiaoyu.suspense.entity.BusiCollect;
import com.xiaoyu.suspense.service.BusiCollectService;
import com.xiaoyu.suspense.util.RandomUtil;
import com.xiaoyu.suspense.util.ResultMessageBuilder;
import com.xiaoyu.suspense.util.StringUtil;

@Controller
@RequestMapping(value="/busiCollect")
public class BusiCollectController extends BaseController {

//<=================定制内容开始==============
	@Autowired
	private BusiCollectService  busiCollectService;

	/**
	 * 收藏趣事
	 * @param busiCollect
	 * @return
	 */
	@RequestMapping(value="/collect/add", method=RequestMethod.POST)
	public void addCollect(BusiCollect busiCollect, HttpServletResponse response) {
		logger.info("[BusiCollectController.addCollect]:addCollect begin");
		if(StringUtil.isEmpty(busiCollect.getBscltUser())) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(false, "缺少收藏人UUID！"), response);
			return;
		}
		if(StringUtil.isEmpty(busiCollect.getBscltSuspense())) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(false, "缺少每日悬疑UUID!"), response);
			return;
		}
		//判断是否收藏过
		BusiCollect collect = busiCollectService.getBusiCollectByUserAndSuspense(busiCollect);
		if(collect != null && collect.getBscltTime() != null) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(false, "您已收藏过该每日悬疑！"), response);
			return;
		}
		busiCollect.setBscltTime(new Date());
		busiCollect.setBscltUuid(RandomUtil.generateUpperString(32));
		busiCollectService.insertBusiCollect(busiCollect);
		writeAjaxJSONResponse(ResultMessageBuilder.build(true, "SUCCESS！"), response);
	}
	
	/**
	 * 取消收藏
	 * @param busiCollect
	 * @return
	 */
	@RequestMapping(value="/collect/cancel", method=RequestMethod.POST)
	public void cancelCollect(String bscltSuspense, String bscltUser, HttpServletResponse response) {
		logger.info("[BusiCollectController.cancelCollect]:cancelCollect begin");
		if(StringUtil.isEmpty(bscltUser)) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(false, "缺少收藏人UUID！"), response);
			return;
		}
		if(StringUtil.isEmpty(bscltSuspense)) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(false, "缺少每日悬疑UUID!"), response);
			return;
		}
		busiCollectService.deleteBusiCollectBySuspenseAndUser(bscltSuspense, bscltUser);
		writeAjaxJSONResponse(ResultMessageBuilder.build(true, "SUCCESS！"), response);
	}
//==================定制内容结束==============>

}