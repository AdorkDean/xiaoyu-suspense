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
import com.xiaoyu.suspense.entity.BusiComment;
import com.xiaoyu.suspense.entity.BusiUser;
import com.xiaoyu.suspense.service.BusiCommentService;
import com.xiaoyu.suspense.service.BusiUserService;
import com.xiaoyu.suspense.util.RandomUtil;
import com.xiaoyu.suspense.util.ResultMessageBuilder;
import com.xiaoyu.suspense.util.StringUtil;
import com.xiaoyu.suspense.vo.BusiCommentListVO;
import com.xiaoyu.suspense.vo.BusiCommentVO;

@Controller
@RequestMapping(value="/busiComment")
public class BusiCommentController extends BaseController {

//<=================定制内容开始==============
	
	@Autowired
	private BusiCommentService  busiCommentService;
	
	@Autowired
	private BusiUserService  busiUserService;
	
	/**
	 * 添加评论
	 * @param busiComment
	 * @return
	 */
	@RequestMapping(value="/comment/add", method=RequestMethod.POST)
	public void addComment(BusiComment busiComment, HttpServletResponse response) {
		logger.info("[BusiCommentController.addComment]:addComment begin");
		if(StringUtil.isEmpty(busiComment.getBscotStory())) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(false, "缺少趣事UUID!"), response);
			return;
		}
		if(StringUtil.isEmpty(busiComment.getBscotUser())) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(false, "缺少用户UUID!"), response);
			return;
		}
		if(StringUtil.isEmpty(busiComment.getBscotContent())) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(false, "请输入评论内容!"), response);
			return;
		}
		busiComment.setBscotTime(new Date());
		busiComment.setBscotUuid(RandomUtil.generateUpperString(32));
		busiCommentService.insertBusiComment(busiComment);
		writeAjaxJSONResponse(ResultMessageBuilder.build(true, "SUCCESS！"), response);
	}

	/**
	 * 评论列表
	 * @param
	 * @return
	 */
	@RequestMapping(value="/comment/list", method=RequestMethod.POST)
	public void findBusiCommentByStory(Integer lastId, int limit, String bscotStory, HttpServletResponse response) {
		logger.info("[BusiCommentController.findBusiCommentByStory]:findBusiCommentByStory begin");		
		if(lastId == null) {
			lastId = Integer.MAX_VALUE;
		}
		if(StringUtil.isEmpty(bscotStory)) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(false, "缺少悬疑故事UUID!"), response);
			return;
		}
		BusiCommentListVO busiCommentListVO = new BusiCommentListVO();		
		List<BusiComment> busiCommentList = busiCommentService.getBusiCommentByStory(lastId, limit, bscotStory);
		if(busiCommentList == null || busiCommentList.size() <= 0) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(false, "无数据！", busiCommentListVO), response);
			return;
		}
		int total = busiCommentService.getCountComment(bscotStory);
		BusiCommentVO vo = new BusiCommentVO();
		List<BusiCommentVO> voList = new ArrayList<BusiCommentVO>();
		for(BusiComment busiCommnt : busiCommentList) {
			if(busiCommnt.getBscotUnid() < lastId) {
				lastId = busiCommnt.getBscotUnid();
			}
			vo = new BusiCommentVO();
			vo.convertPOToVO(busiCommnt);
			if(busiCommnt.getBscotContent() != null) {
				if(busiCommnt.getBscotContent().length() > 100)
					vo.setBscotContent(busiCommnt.getBscotContent().substring(0, 97) + "...");
				else {
					vo.setBscotContent(busiCommnt.getBscotContent());
				}
			}
			BusiUser user = new BusiUser(busiCommnt.getBscotUser());
			user = busiUserService.getBusiUser(user);
			if(user != null) {
				vo.setBscotUserCode(user.getBsusrCode());
				vo.setBscotUserHead(user.getBsusrHeadUrl());
			}
			voList.add(vo);
		}
		busiCommentListVO.setLastId(lastId);
		busiCommentListVO.setTotal(total);
		busiCommentListVO.setVoList(voList);
		writeAjaxJSONResponse(ResultMessageBuilder.build(true, "", busiCommentListVO), response);
	}
//==================定制内容结束==============>

}