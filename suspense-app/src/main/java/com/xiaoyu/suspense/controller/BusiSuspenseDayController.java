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
import com.xiaoyu.suspense.entity.BusiCollect;
import com.xiaoyu.suspense.entity.BusiSuspenseDay;
import com.xiaoyu.suspense.enums.YesNoType;
import com.xiaoyu.suspense.service.BusiCollectService;
import com.xiaoyu.suspense.service.BusiSuspenseDayService;
import com.xiaoyu.suspense.util.DateUtil;
import com.xiaoyu.suspense.util.ResultMessageBuilder;
import com.xiaoyu.suspense.util.StringUtil;
import com.xiaoyu.suspense.vo.BusiSuspenseDayDayVO;
import com.xiaoyu.suspense.vo.BusiSuspenseDayListVO;
import com.xiaoyu.suspense.vo.BusiSuspenseDayVO;

@Controller
@RequestMapping(value="/busiSuspenseDay")
public class BusiSuspenseDayController extends BaseController {

//<=================定制内容开始==============
	@Autowired
	private BusiSuspenseDayService  busiSuspenseDayService;
	
	@Autowired
	private BusiCollectService  busiCollectService;
	
	/**
	 * 每日竞猜列表/历史竞猜列表
	 * @param bssdyDay
	 * @return
	 */
	@RequestMapping(value="/suspense/day/list", method=RequestMethod.POST)
	public void findSuspenseDayList(String bssdyDay, String userUuid, HttpServletResponse response) {
		logger.info("[BusiSuspenseDayController.findSuspenseDayList]:findSuspenseDayList begin");
		if(bssdyDay == null || StringUtil.isEmpty(bssdyDay) ) {
			Date newDate = DateUtil.addDate(new Date(), 1);
			bssdyDay = DateUtil.formatDefaultDate(newDate);
		}
		if(StringUtil.isEmpty(userUuid)) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(false, "缺少用户UUID!"), response);
			return;
		}
		
		BusiSuspenseDayDayVO busiSuspenseDayDayVO = new BusiSuspenseDayDayVO();
		List<BusiSuspenseDay> busiSuspenseDayList = busiSuspenseDayService.getSuspenseDayByDay(bssdyDay);
		if(busiSuspenseDayList == null || busiSuspenseDayList.size() <= 0) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(false, "无数据！", busiSuspenseDayDayVO), response);
			return;
		}
		BusiSuspenseDayVO vo = new BusiSuspenseDayVO();
		List<BusiSuspenseDayVO> voList = new ArrayList<BusiSuspenseDayVO>();
		BusiCollect busiCollect = new BusiCollect();
		for(BusiSuspenseDay busiSuspenseDay : busiSuspenseDayList) {
			vo = new BusiSuspenseDayVO();
			busiCollect = new BusiCollect();
			busiCollect.setBscltSuspense(busiSuspenseDay.getBssdyUuid());
			busiCollect.setBscltUser(userUuid);
			BusiCollect collect = busiCollectService.getBusiCollectByUserAndSuspense(busiCollect);
			if(collect != null && collect.getBscltTime() != null) {
				vo.setIsCollect(YesNoType.YES);
			}else {
				vo.setIsCollect(YesNoType.NO);
			}
			vo.convertPOToVO(busiSuspenseDay);
			voList.add(vo);
		}
		busiSuspenseDayDayVO.setBssdyDay(busiSuspenseDayList.get(0).getBssdyDay());
		busiSuspenseDayDayVO.setVoList(voList);
		writeAjaxJSONResponse(ResultMessageBuilder.build(true, "", busiSuspenseDayDayVO), response);
	}
	
	/**
	 * 我的竞猜列表
	 * @param userUuid
	 * @param lastId
	 * @param limit
	 * @return
	 */
	@RequestMapping(value="/suspense/day/quiz/list", method=RequestMethod.POST)
	public void finSuspenseDayQuizList(String userUuid, Integer lastId, int limit, HttpServletResponse response) {
		logger.info("[BusiSuspenseDayController.finSuspenseDayQuizList]:finSuspenseDayQuizList begin");
		if(lastId == null) {
			lastId = Integer.MAX_VALUE;
		}

		BusiSuspenseDayListVO busiSuspenseDayListVO = new BusiSuspenseDayListVO();
		List<BusiSuspenseDay> busiSuspenseDayList = busiSuspenseDayService.getSuspenseDayByMyQuiz(lastId, limit, userUuid);
		if(busiSuspenseDayList == null || busiSuspenseDayList.size() <= 0) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(false, "无数据！", busiSuspenseDayListVO), response);
			return;
		}
		BusiSuspenseDayVO vo = new BusiSuspenseDayVO();
		List<BusiSuspenseDayVO> voList = new ArrayList<BusiSuspenseDayVO>();
		BusiCollect busiCollect = new BusiCollect();
		for(BusiSuspenseDay busiSuspenseDay : busiSuspenseDayList) {
			if(busiSuspenseDay.getBssdyUnid() < lastId) {
				lastId = busiSuspenseDay.getBssdyUnid();
			}
			vo = new BusiSuspenseDayVO();
			busiCollect = new BusiCollect();
			busiCollect.setBscltSuspense(busiSuspenseDay.getBssdyUuid());
			busiCollect.setBscltUser(userUuid);
			BusiCollect collect = busiCollectService.getBusiCollectByUserAndSuspense(busiCollect);
			if(collect != null && collect.getBscltTime() != null) {
				vo.setIsCollect(YesNoType.YES);
			}else {
				vo.setIsCollect(YesNoType.NO);
			}
			vo.convertPOToVO(busiSuspenseDay);
			voList.add(vo);
		}
		busiSuspenseDayListVO.setLastId(lastId);
		busiSuspenseDayListVO.setVoList(voList);
		writeAjaxJSONResponse(ResultMessageBuilder.build(true, "", busiSuspenseDayListVO), response);
	}
	
	/**
	 * 我的收藏列表
	 * @param userUuid
	 * @param lastId
	 * @param limit
	 * @return
	 */
	@RequestMapping(value="/suspense/day/collect/list", method=RequestMethod.POST)
	public void finSuspenseDayCollectList(String userUuid, Integer lastId, int limit, HttpServletResponse response) {
		logger.info("[BusiSuspenseDayController.finSuspenseDayCollectList]:finSuspenseDayCollectList begin");
		if(lastId == null) {
			lastId = Integer.MAX_VALUE;
		}

		BusiSuspenseDayListVO busiSuspenseDayListVO = new BusiSuspenseDayListVO();
		List<BusiSuspenseDay> busiSuspenseDayList = busiSuspenseDayService.getSuspenseDayByMyCollect(lastId, limit, userUuid);
		if(busiSuspenseDayList == null || busiSuspenseDayList.size() <= 0) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(false, "无数据！", busiSuspenseDayListVO), response);
			return;
		}
		BusiSuspenseDayVO vo = new BusiSuspenseDayVO();
		List<BusiSuspenseDayVO> voList = new ArrayList<BusiSuspenseDayVO>();
		for(BusiSuspenseDay busiSuspenseDay : busiSuspenseDayList) {
			if(busiSuspenseDay.getBssdyUnid() < lastId) {
				lastId = busiSuspenseDay.getBssdyUnid();
			}
			vo = new BusiSuspenseDayVO();
			vo.convertPOToVO(busiSuspenseDay);
			voList.add(vo);
		}
		busiSuspenseDayListVO.setLastId(lastId);
		busiSuspenseDayListVO.setVoList(voList);
		writeAjaxJSONResponse(ResultMessageBuilder.build(true, "", busiSuspenseDayListVO), response);
	}
//==================定制内容结束==============>

}