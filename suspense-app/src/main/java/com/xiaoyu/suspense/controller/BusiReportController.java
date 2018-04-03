package com.xiaoyu.suspense.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.xiaoyu.suspense.controller.BaseController;
import com.xiaoyu.suspense.entity.BusiReport;
import com.xiaoyu.suspense.entity.BusiUser;
import com.xiaoyu.suspense.service.BusiReportService;
import com.xiaoyu.suspense.service.BusiUserService;
import com.xiaoyu.suspense.util.RandomUtil;
import com.xiaoyu.suspense.util.ResultMessageBuilder;
import com.xiaoyu.suspense.util.StringUtil;
import com.xiaoyu.suspense.vo.BusiReportListVO;
import com.xiaoyu.suspense.vo.BusiReportVO;

@Controller
@RequestMapping(value="/busiReport")
public class BusiReportController extends BaseController {

//<=================定制内容开始==============
	@Autowired
	private BusiReportService  busiReportService;
	
	@Autowired
	private BusiUserService  busiUserService;
	
	/**
	 * 我关注的人
	 * @param bsrptAttention
	 * @param lastId
	 * @param limit
	 * @return
	 */
	@RequestMapping(value="/report/list", method=RequestMethod.POST)
	public void findReportList(String bsrptAttention, Integer lastId, int limit, HttpServletResponse response) {
		logger.info("[BusiReportController.findReportList]:findReportList begin");
		if(lastId == null) {
			lastId = Integer.MAX_VALUE;
		}

		BusiReportListVO busiReportListVO = new BusiReportListVO();
		List<BusiReport> busiReportList = busiReportService.getBusiReportByReport(bsrptAttention, null, lastId, limit);
		if(busiReportList == null || busiReportList.size() <= 0) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(false, "无数据！", busiReportListVO), response);
			return;
		}
		BusiReportVO vo = new BusiReportVO();
		List<BusiReportVO> voList = new ArrayList<BusiReportVO>();
		for(BusiReport busiReport : busiReportList) {
			if(busiReport.getBsrptUnid() < lastId) {
				lastId = busiReport.getBsrptUnid();
			}
			vo = new BusiReportVO();
			vo.convertPOToVO(busiReport);
			BusiUser user = new BusiUser(busiReport.getBsrptBeAttention());
			user = busiUserService.getBusiUser(user);
			if(user != null) {
				vo.setBeAttentionName(user.getBsusrCode());
			}
			voList.add(vo);
		}
		busiReportListVO.setLastId(lastId);
		busiReportListVO.setVoList(voList);
		writeAjaxJSONResponse(ResultMessageBuilder.build(true, "", busiReportListVO), response);
	}
	
	/**
	 * 关注我的人
	 * @param bsrptBeAttention
	 * @param lastId
	 * @param limit
	 * @return
	 */
	@RequestMapping(value="/bereport/list", method=RequestMethod.POST)
	public void findBeReportList(String bsrptBeAttention, Integer lastId, int limit, HttpServletResponse response) {
		logger.info("[BusiReportController.findBeReportList]:findBeReportList begin");
		if(lastId == null) {
			lastId = Integer.MAX_VALUE;
		}

		BusiReportListVO busiReportListVO = new BusiReportListVO();
		List<BusiReport> busiReportList = busiReportService.getBusiReportByReport(null, bsrptBeAttention, lastId, limit);
		if(busiReportList == null || busiReportList.size() <= 0) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(false, "无数据！", busiReportListVO), response);
			return;
		}
		BusiReportVO vo = new BusiReportVO();
		List<BusiReportVO> voList = new ArrayList<BusiReportVO>();
		for(BusiReport busiReport : busiReportList) {
			if(busiReport.getBsrptUnid() < lastId) {
				lastId = busiReport.getBsrptUnid();
			}
			vo = new BusiReportVO();
			vo.convertPOToVO(busiReport);
			BusiUser user = new BusiUser(busiReport.getBsrptAttention());
			user = busiUserService.getBusiUser(user);
			if(user != null) {
				vo.setBeAttentionName(user.getBsusrCode());
			}
			voList.add(vo);
		}
		busiReportListVO.setLastId(lastId);
		busiReportListVO.setVoList(voList);
		writeAjaxJSONResponse(ResultMessageBuilder.build(true, "", busiReportListVO), response);
	}
	
	/**
	 * 关注
	 * @param lastId
	 * @param userUuid
	 * @param limit
	 * @return
	 */
	@RequestMapping(value="/report/add", method=RequestMethod.POST)
	public void addReport(BusiReport busiReport, HttpServletResponse response) {
		logger.info("[BusiReportController.addReport]:addReport begin");
		if(StringUtil.isEmpty(busiReport.getBsrptAttention())) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(false, "缺少关注人UUID！"), response);
			return;
		}
		if(StringUtil.isEmpty(busiReport.getBsrptBeAttention())) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(false, "缺少被关注人UUID!"), response);
			return;
		}
		//判断是否关注过
		BusiReport report = busiReportService.getBusiReportByUserAndUser(busiReport);
		if(report != null && report.getBsrptCdate() != null) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(false, "您已关注过该用户！"), response);
			return;
		}
		busiReport.setBsrptCdate(new Date());
		busiReport.setBsrptUuid(RandomUtil.generateUpperString(32));
		busiReportService.insertBusiReport(busiReport);
		writeAjaxJSONResponse(ResultMessageBuilder.build(true, "SUCCESS！"), response);
	}
	
	/**
	 * 取消关注
	 * @param bsrptAttention
	 * @param bsrptBeAttention
	 * @return
	 */
	@RequestMapping(value="/report/cancel", method=RequestMethod.POST)
	public void cancelReport(String bsrptAttention, String bsrptBeAttention, HttpServletResponse response) {
		logger.info("[BusiReportController.cancelReport]:cancelReport begin");
		if(StringUtil.isEmpty(bsrptAttention)) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(false, "缺少关注人UUID！"), response);
			return;
		}
		if(StringUtil.isEmpty(bsrptBeAttention)) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(false, "缺少被关注人UUID!"), response);
			return;
		}
		busiReportService.deleteBusiReportByUserAndUser(bsrptAttention, bsrptBeAttention);
		writeAjaxJSONResponse(ResultMessageBuilder.build(true, "SUCCESS！"), response);
	}
	
	/**
	 * 取消关注
	 * @param bsrptUuid
	 * @return
	 */
	@RequestMapping(value="/report/cancel/{bsrptUuid}", method=RequestMethod.POST)
	public void cancelReport(@PathVariable String bsrptUuid, HttpServletResponse response) {
		logger.info("[BusiReportController.cancelReport]:cancelReport begin");
		if(StringUtil.isEmpty(bsrptUuid)) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(false, "缺少关注UUID！"), response);
			return;
		}
		BusiReport busiReport = new BusiReport();
		busiReport.setBsrptUuid(bsrptUuid);
		busiReportService.deleteBusiReport(busiReport);
		writeAjaxJSONResponse(ResultMessageBuilder.build(true, "SUCCESS！"), response);
	}
//==================定制内容结束==============>

}