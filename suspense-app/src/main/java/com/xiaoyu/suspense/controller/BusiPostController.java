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
import com.xiaoyu.suspense.entity.BusiPost;
import com.xiaoyu.suspense.entity.BusiTop;
import com.xiaoyu.suspense.entity.BusiUser;
import com.xiaoyu.suspense.enums.BusiType;
import com.xiaoyu.suspense.service.BusiFollowPostService;
import com.xiaoyu.suspense.service.BusiPostService;
import com.xiaoyu.suspense.service.BusiTopService;
import com.xiaoyu.suspense.service.BusiUserService;
import com.xiaoyu.suspense.util.RandomUtil;
import com.xiaoyu.suspense.util.ResultMessageBuilder;
import com.xiaoyu.suspense.util.StringUtil;
import com.xiaoyu.suspense.vo.BusiPostListVO;
import com.xiaoyu.suspense.vo.BusiPostVO;

@Controller
@RequestMapping(value="/busiPost")
public class BusiPostController extends BaseController {

//<=================定制内容开始==============
	@Autowired
	private BusiPostService  busiPostService;

	@Autowired
	private BusiUserService  busiUserService;
	
	@Autowired
	private BusiFollowPostService  busiFollowPostService;
	
	@Autowired
	private BusiTopService busiTopService;
	
	/**
	 * 发帖
	 * @param busiPost
	 * @return
	 */
	@RequestMapping(value="/post/add", method=RequestMethod.POST)
	public void addBusiPost(BusiPost busiPost, HttpServletResponse response) {
		logger.info("[BusiPostController.addBusiPost]:addBusiPost begin");
		if(StringUtil.isEmpty(busiPost.getBspstUser())) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(false, "缺少发帖人UUID！"), response);
			return;
		}
		if(StringUtil.isEmpty(busiPost.getBspstContent())) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(false, "缺少发帖内容!"), response);
			return;
		}
		if(busiPost.getBspstType() == null) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(false, "缺少帖子类型!"), response);
			return;
		}
		if(busiPost.getBspstContent().length() <= 8) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(false, "发帖内容请在八字以上!"), response);
			return;
		}
		if(StringUtil.isEmpty(busiPost.getBspstTitle())) {
			busiPost.setBspstTitle(busiPost.getBspstContent().substring(7) + "...");
		}
		
		busiPost.setBspstUp(0);
		busiPost.setBspstTime(new Date());
		busiPost.setBspstUuid(RandomUtil.generateUpperString(32));
		busiPostService.insertBusiPost(busiPost);
		writeAjaxJSONResponse(ResultMessageBuilder.build(true, "SUCCESS！"), response);
	}
	
	/**
	 * 帖子列表
	 * @param lastId
	 * @param limit
	 * @return
	 */
	@RequestMapping(value="/post/list", method=RequestMethod.POST)
	public void findPostList(Integer lastId, int limit, HttpServletResponse response) {
		logger.info("[BusiPostController.findPostList]:findPostList begin");
		if(lastId == null) {
			lastId = Integer.MAX_VALUE;
		}

		BusiPostListVO busiPostListVO = new BusiPostListVO();
		List<BusiPost> busiPostList = busiPostService.getBusiPostByMy(null, lastId, limit);
		if(busiPostList == null || busiPostList.size() <= 0) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(false, "无数据！", busiPostListVO), response);
			return;
		}
		BusiPostVO vo = new BusiPostVO();
		List<BusiPostVO> voList = new ArrayList<BusiPostVO>();
		for(BusiPost busiPost : busiPostList) {
			if(busiPost.getBspstUnid() < lastId) {
				lastId = busiPost.getBspstUnid();
			}
			vo = new BusiPostVO();
			vo.convertPOToVOList(busiPost);
			BusiUser user = new BusiUser(busiPost.getBspstUser());
			user = busiUserService.getBusiUser(user);
			if(user != null) {
				vo.setPushUserCode(user.getBsusrCode());
				vo.setPushUserHead(user.getBsusrHeadUrl());
			}
			vo.setCountFollowPost(busiFollowPostService.getCountFollowPost(busiPost.getBspstUuid()));
			voList.add(vo);
		}
		busiPostListVO.setLastId(lastId);
		busiPostListVO.setVoList(voList);
		writeAjaxJSONResponse(ResultMessageBuilder.build(true, "", busiPostListVO), response);
	}

	/**
	 * 我的帖子
	 * @param lastId
	 * @param userUuid
	 * @param limit
	 * @return
	 */
	@RequestMapping(value="/my/post/list", method=RequestMethod.POST)
	public void findMyPostList(Integer lastId, String userUuid, int limit, HttpServletResponse response) {
		logger.info("[BusiPostController.findMyPostList]:findMyPostList begin");		
		if(lastId == null) {
			lastId = Integer.MAX_VALUE;
		}
		if(StringUtil.isEmpty(userUuid)) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(false, "缺少用户UUID!"), response);
			return;
		}
		BusiPostListVO busiPostListVO = new BusiPostListVO();
		List<BusiPost> busiPostList = busiPostService.getBusiPostByMy(userUuid, lastId, limit);
		if(busiPostList == null || busiPostList.size() <= 0) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(false, "无数据！", busiPostListVO), response);
			return;
		}
		BusiPostVO vo = new BusiPostVO();
		List<BusiPostVO> voList = new ArrayList<BusiPostVO>();
		for(BusiPost busiPost : busiPostList) {
			if(busiPost.getBspstUnid() < lastId) {
				lastId = busiPost.getBspstUnid();
			}
			vo = new BusiPostVO();
			vo.convertPOToVOList(busiPost);
			BusiUser user = new BusiUser(busiPost.getBspstUser());
			user = busiUserService.getBusiUser(user);
			if(user != null) {
				vo.setPushUserCode(user.getBsusrCode());
				vo.setPushUserHead(user.getBsusrHeadUrl());
			}
			vo.setCountFollowPost(busiFollowPostService.getCountFollowPost(busiPost.getBspstUuid()));
			voList.add(vo);
		}
		busiPostListVO.setLastId(lastId);
		busiPostListVO.setVoList(voList);
		writeAjaxJSONResponse(ResultMessageBuilder.build(true, "", busiPostListVO), response);
	}

	/**
	 * 帖子详情
	 * @param bspstUuid
	 * @return
	 */
	@RequestMapping(value="/post/detail", method=RequestMethod.POST)
	public void findPostDetail(String bspstUuid, HttpServletResponse response) {
		logger.info("[BusiPostController.findPostDetail]:findPostDetail begin");
		if(StringUtil.isEmpty(bspstUuid)) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(false, "缺少bspstUuid参数！"), response);
			return;
		}
		BusiPost busiPost = new BusiPost();
		busiPost.setBspstUuid(bspstUuid);
		busiPost = busiPostService.getBusiPost(busiPost);
		if(busiPost == null) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(false, "无该帖子详情！"), response);
			return;
		}
		BusiPostVO vo = new BusiPostVO();
		vo.convertPOToVO(busiPost);
		BusiUser user = new BusiUser(busiPost.getBspstUser());
		user = busiUserService.getBusiUser(user);
		if(user != null) {
			vo.setPushUserCode(user.getBsusrCode());
			vo.setPushUserHead(user.getBsusrHeadUrl());
		}
		vo.setCountFollowPost(busiFollowPostService.getCountFollowPost(busiPost.getBspstUuid()));
		writeAjaxJSONResponse(ResultMessageBuilder.build(true, "", vo), response);
	}
	
	/**
	 * 帖子顶
	 * @param bspstUuid
	 * @param userUuid
	 * @return
	 */
	@RequestMapping(value="/post/good", method=RequestMethod.POST)
	public void goodPost(String bspstUuid, String userUuid, HttpServletResponse response) {
		logger.info("[BusiPostController.goodPost]:goodPost begin");
		if(StringUtil.isEmpty(bspstUuid)) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(false, "缺少bspstUuid参数!"), response);
			return;
		}
		BusiTop busiTop = new BusiTop();
		busiTop.setBstopBusi(bspstUuid);
		busiTop.setBstopBusiType(BusiType.SUSPENSE_COMMUNITY);
		busiTop.setBstopUser(userUuid);
		busiTop = busiTopService.getBusiTopByUserAndBusi(busiTop);
		if(busiTop != null && busiTop.getBstopUuid() != null) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(false, "已经顶过！"), response);
		}else {
			busiTop = new BusiTop();
			busiTop.setBstopBusi(bspstUuid);
			busiTop.setBstopBusiType(BusiType.SUSPENSE_COMMUNITY);
			busiTop.setBstopUser(userUuid);
			busiTop.setBstopTime(new Date());
			busiTop.setBstopUuid(RandomUtil.generateUpperString(32));
			busiTopService.insertBusiTop(busiTop);
			busiPostService.updateBusiPostGood(bspstUuid);
			writeAjaxJSONResponse(ResultMessageBuilder.build(true, "SUCCESS！"), response);			
		}
	}
//==================定制内容结束==============>

}