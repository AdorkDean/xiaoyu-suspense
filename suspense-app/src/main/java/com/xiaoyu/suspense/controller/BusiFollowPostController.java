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
import com.xiaoyu.suspense.entity.BusiFollowPost;
import com.xiaoyu.suspense.entity.BusiUser;
import com.xiaoyu.suspense.service.BusiFollowPostService;
import com.xiaoyu.suspense.service.BusiUserService;
import com.xiaoyu.suspense.util.RandomUtil;
import com.xiaoyu.suspense.util.ResultMessageBuilder;
import com.xiaoyu.suspense.util.StringUtil;
import com.xiaoyu.suspense.vo.BusiFollowPostListVO;
import com.xiaoyu.suspense.vo.BusiFollowPostVO;

@Controller
@RequestMapping(value="/busiFollowPost")
public class BusiFollowPostController extends BaseController {

//<=================定制内容开始==============
	@Autowired
	private BusiFollowPostService  busiFollowPostService;

	@Autowired
	private BusiUserService  busiUserService;
	
	/**
	 * 跟帖
	 * @param busiFollowPost
	 * @return
	 */
	@RequestMapping(value="/follow/post/add", method=RequestMethod.POST)
	public void addFollowPost(BusiFollowPost busiFollowPost, HttpServletResponse response) {
		logger.info("[BusiFollowPostController.addFollowPost]:addFollowPost begin");
		if(StringUtil.isEmpty(busiFollowPost.getBsfptUser())) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(false, "缺少跟帖人UUID！"), response);
			return;
		}
		if(StringUtil.isEmpty(busiFollowPost.getBsfptPost())) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(false, "缺少帖子UUID!"), response);
			return;
		}
		if(StringUtil.isEmpty(busiFollowPost.getBsfptContent())) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(false, "缺少跟帖内容!"), response);
			return;
		}
		
		busiFollowPost.setBsfptTime(new Date());
		busiFollowPost.setBsfptUuid(RandomUtil.generateUpperString(32));
		busiFollowPostService.insertBusiFollowPost(busiFollowPost);
		writeAjaxJSONResponse(ResultMessageBuilder.build(true, "SUCCESS！"), response);
	}
		
	/**
	 * 跟帖列表
	 * @param lastId
	 * @param postUuid
	 * @param limit
	 * @return
	 */
	@RequestMapping(value="/follow/post/list", method=RequestMethod.POST)
	public void findFollowPostList(Integer lastId, String postUuid, int limit, HttpServletResponse response) {
		logger.info("[BusiFollowPostController.findFollowPostList]:findFollowPostList begin");		
		if(lastId == null) {
			lastId = Integer.MAX_VALUE;
		}
		if(StringUtil.isEmpty(postUuid)) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(false, "缺少帖子UUID!"), response);
			return;
		}
		BusiFollowPostListVO busiFollowPostListVO = new BusiFollowPostListVO();
		List<BusiFollowPost> busiFollowPostList = busiFollowPostService.getBusiFollowPostByPost(postUuid, lastId, limit);
		if(busiFollowPostList == null || busiFollowPostList.size() <= 0) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(false, "无数据！", busiFollowPostListVO), response);
			return;
		}
		BusiFollowPostVO vo = new BusiFollowPostVO();
		List<BusiFollowPostVO> voList = new ArrayList<BusiFollowPostVO>();
		for(BusiFollowPost busiFollowPost : busiFollowPostList) {
			if(busiFollowPost.getBsfptUnid() < lastId) {
				lastId = busiFollowPost.getBsfptUnid();
			}
			vo = new BusiFollowPostVO();
			vo.convertPOToVO(busiFollowPost);
			BusiUser user = new BusiUser(busiFollowPost.getBsfptUser());
			user = busiUserService.getBusiUser(user);
			if(user != null) {
				vo.setPushUserCode(user.getBsusrCode());
				vo.setPushUserHead(user.getBsusrHeadUrl());
			}
			voList.add(vo);
		}
		busiFollowPostListVO.setLastId(lastId);
		busiFollowPostListVO.setVoList(voList);
		writeAjaxJSONResponse(ResultMessageBuilder.build(true, "", busiFollowPostListVO), response);
	}
//==================定制内容结束==============>

}