package com.xiaoyu.suspense.controller;

import java.util.Date;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.xiaoyu.suspense.controller.BaseController;
import com.xiaoyu.suspense.entity.BusiQuiz;
import com.xiaoyu.suspense.service.BusiQuizService;
import com.xiaoyu.suspense.util.RandomUtil;
import com.xiaoyu.suspense.util.ResultMessageBuilder;
import com.xiaoyu.suspense.util.StringUtil;

@Controller
@RequestMapping(value="/busiQuiz")
public class BusiQuizController extends BaseController {

//<=================定制内容开始==============
	@Autowired
	private BusiQuizService  busiQuizService;
	
	/**
	 * 竞猜
	 * @param busiCollect
	 * @return
	 */
	@RequestMapping(value="/quiz/add", method=RequestMethod.POST)
	public void addQuiz(String bsqizUser, String bsqizSuspense, String bsqizAnswer, Integer bsqizScore, HttpServletResponse response) {
		logger.info("[BusiQuizController.addQuiz]:addQuiz begin");
		if(StringUtil.isEmpty(bsqizUser)) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(false, "缺少竞猜人UUID！"), response);
			return;
		}
		if(StringUtil.isEmpty(bsqizSuspense)) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(false, "缺少每日悬疑UUID!"), response);
			return;
		}
		if(StringUtil.isEmpty(bsqizAnswer)) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(false, "缺少竞猜回答!"), response);
			return;
		}
		if(bsqizScore == null) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(false, "缺少竞猜分数!"), response);
			return;
		}
		
		//判断是否竞猜过
		BusiQuiz busiQuiz = busiQuizService.getBusiQuizByUserAndSuspense(bsqizUser, bsqizSuspense);
		if(busiQuiz != null && busiQuiz.getBsqizTime() != null) {
			busiQuiz.setBsqizAnswer(bsqizAnswer);
			busiQuiz.setBsqizScore(bsqizScore);
			busiQuiz.setBsqizTime(new Date());
			busiQuizService.updateBusiQuiz(busiQuiz);
		}else {
			busiQuiz = new BusiQuiz();
			busiQuiz.setBsqizAnswer(bsqizAnswer);
			busiQuiz.setBsqizScore(bsqizScore);
			busiQuiz.setBsqizResult(0);
			busiQuiz.setBsqizTime(new Date());
			busiQuiz.setBsqizUuid(RandomUtil.generateUpperString(32));
			busiQuiz.setBsqizUser(bsqizUser);
			busiQuiz.setBsqizSuspense(bsqizSuspense);
			busiQuizService.insertBusiQuiz(busiQuiz);
		}		
		writeAjaxJSONResponse(ResultMessageBuilder.build(true, "SUCCESS！"), response);
	}
//==================定制内容结束==============>

}