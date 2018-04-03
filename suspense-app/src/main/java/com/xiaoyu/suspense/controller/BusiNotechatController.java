package com.xiaoyu.suspense.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.xiaoyu.suspense.controller.BaseController;
import com.xiaoyu.suspense.entity.BusiNotechat;
import com.xiaoyu.suspense.entity.BusiUser;
import com.xiaoyu.suspense.service.BusiNotechatService;
import com.xiaoyu.suspense.service.BusiUserService;
import com.xiaoyu.suspense.util.RandomUtil;
import com.xiaoyu.suspense.util.ResultMessageBuilder;
import com.xiaoyu.suspense.util.StringUtil;
import com.xiaoyu.suspense.vo.BusiNotechatListVO;
import com.xiaoyu.suspense.vo.BusiNotechatVO;

@Controller
@RequestMapping(value="/busiNotechat")
public class BusiNotechatController extends BaseController {

//<=================定制内容开始==============
	@Autowired
	private BusiNotechatService  busiNotechatService;
	
	@Autowired
	private BusiUserService  busiUserService;
	
	/**
	 * 聊天详情
	 * @param lastId
	 * @param reportUuid
	 * @param limit
	 * @return
	 */
	@RequestMapping(value="/notechat/list", method=RequestMethod.POST)
	public void findBusiNotechatList(Integer lastId, String reportUuid, String userUuid, int limit, HttpServletResponse response) {
		logger.info("[BusiNotechatController.findBusiNotechatList]:findBusiNotechatList begin");		
		if(lastId == null) {
			lastId = Integer.MAX_VALUE;
		}
		if(StringUtil.isEmpty(reportUuid)) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(false, "缺少关注UUID!"), response);
			return;
		}
		if(StringUtil.isEmpty(userUuid)) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(false, "缺少用户UUID!"), response);
			return;
		}
		BusiNotechatListVO busiNotechatListVO = new BusiNotechatListVO();
		List<BusiNotechat> busiNotechatList = busiNotechatService.getBusiNotechatByReport(reportUuid, lastId, limit);
		if(busiNotechatList == null || busiNotechatList.size() <= 0) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(false, "无数据！", busiNotechatListVO), response);
			return;
		}
		BusiNotechatVO vo = new BusiNotechatVO();
		List<BusiNotechatVO> voList = new ArrayList<BusiNotechatVO>();
		for(BusiNotechat busiNotechat : busiNotechatList) {
			if(busiNotechat.getBsnctUnid() < lastId) {
				lastId = busiNotechat.getBsnctUnid();
			}
			vo = new BusiNotechatVO();
			vo.convertPOToVO(busiNotechat, userUuid);
			BusiUser user = new BusiUser(busiNotechat.getBsnctUser());
			user = busiUserService.getBusiUser(user);
			if(user != null) {
				vo.setUserHead(user.getBsusrHeadUrl());
			}
			voList.add(vo);
		}
		// 排序,通过泛型和匿名类来实现  
        Collections.sort(voList, new Comparator<BusiNotechatVO>() {  
  
            public int compare(BusiNotechatVO o1, BusiNotechatVO o2) {  
                int result = o1.getBsnctUnid() - o2.getBsnctUnid();  
                return result;  
            }  
        });
		busiNotechatListVO.setLastId(lastId);
		busiNotechatListVO.setVoList(voList);
		writeAjaxJSONResponse(ResultMessageBuilder.build(true, "", busiNotechatListVO), response);
	}
	
	/**
	 * 添加聊天内容
	 * @param lastId
	 * @param userUuid
	 * @param limit
	 * @return
	 */
	@RequestMapping(value="/notechat/add", method=RequestMethod.POST)
	public void addBusiNotechat(BusiNotechat busiNotechat, HttpServletResponse response) {
		logger.info("[BusiNotechatController.addBusiNotechat]:addBusiNotechat begin");
		if(StringUtil.isEmpty(busiNotechat.getBsnctReport())) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(false, "缺少关注UUID！"), response);
			return;
		}
		if(StringUtil.isEmpty(busiNotechat.getBsnctContent())) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(false, "聊天内容不能为空!"), response);
			return;
		}
		if(StringUtil.isEmpty(busiNotechat.getBsnctUser())) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(false, "缺少发送用户UUID！"), response);
			return;
		}
		if(busiNotechat.getBsnctType() == null) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(false, "缺少聊天内容类型!"), response);
			return;
		}
		
		busiNotechat.setBsnctSebdTime(new Date());
		busiNotechat.setBsnctUuid(RandomUtil.generateUpperString(32));
		busiNotechatService.insertBusiNotechat(busiNotechat);
		writeAjaxJSONResponse(ResultMessageBuilder.build(true, "SUCCESS！"), response);
	}
//==================定制内容结束==============>

}