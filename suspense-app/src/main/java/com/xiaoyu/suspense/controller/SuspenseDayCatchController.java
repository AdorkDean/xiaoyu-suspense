package com.xiaoyu.suspense.controller;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.xiaoyu.suspense.entity.BusiSuspenseDay;
import com.xiaoyu.suspense.service.BusiSuspenseDayService;
import com.xiaoyu.suspense.util.DateUtil;
import com.xiaoyu.suspense.util.RandomUtil;
import com.xiaoyu.suspense.util.ResultMessageBuilder;
import com.xiaoyu.suspense.util.StringUtil;

@Controller
@RequestMapping(value="/suspenseDayCatch")
public class SuspenseDayCatchController extends BaseController {
	
	private final Logger logger = LoggerFactory.getLogger("BASE_LOGGER");
	
	@Autowired
	private BusiSuspenseDayService  busiSuspenseDayService;
	
	/**
	 * 批量插入每日悬疑
	 * @param path
	 * @return
	 */
	@RequestMapping(value="/start", method=RequestMethod.POST)
	public void start(String path, HttpServletResponse response) {
		//D:\\每日竞猜内容.txt
		if(StringUtil.isEmpty(path)) {
			writeAjaxJSONResponse(ResultMessageBuilder.build(false, "请输入文件路径!"), response);
			return;
		}
		String str = getTextFromText(path);
		String[] strList = str.split("\n\n");
		for (int i = 0; i < strList.length; i++) {
			String[] contentList = strList[i].split("\n");
			int intanswer = 0;
			String content = "";
			String answer = "";
			for (int j = 1; j < contentList.length; j++) {
				if(contentList[j].startsWith("答：") || contentList[j].startsWith("答:")) {
					intanswer = j;
					break;
				}
				content += contentList[j] +"\n";
			}
			for (; intanswer < contentList.length; intanswer++) {
				answer += contentList[intanswer] +"\n";
			}
			System.out.println("head:" + contentList[0]);
			System.out.println("content:" + content);
			System.out.println("answer:" + answer.substring(2, answer.length()));
			
			//插入到数据库中
			BusiSuspenseDay busiSuspenseDay = new BusiSuspenseDay();
			busiSuspenseDay.setBssdyContent(content);
			busiSuspenseDay.setBssdyDay(DateUtil.formatDefaultDate(new Date()));
			busiSuspenseDay.setBssdyResult(answer);
			busiSuspenseDay.setBssdyScore(5);
			busiSuspenseDay.setBssdyUuid(RandomUtil.generateUpperString(32));
			busiSuspenseDayService.insertBusiSuspenseDay(busiSuspenseDay);
			logger.info("[SuspenseDayCatchUtil: " + contentList[0]);
			writeAjaxJSONResponse(ResultMessageBuilder.build(true, "SUCCESS！"), response);
		}
	}
	
	private static String getCharset(String fileName) throws IOException{	        
		BufferedInputStream bin = new BufferedInputStream(new FileInputStream(fileName));  
        int p = (bin.read() << 8) + bin.read();  
        String code = null;            
        switch (p) {  
        	case 0xefbb:  
        		code = "UTF-8";  
                break;  
            case 0xfffe:  
                code = "Unicode";  
                break;  
            case 0xfeff:  
                code = "UTF-16BE";  
                break;  
            default:  
                code = "GBK";  
        }  
        return code;
	}
	
	public static String getTextFromText(String filePath){	        
		try {
			InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath),getCharset(filePath));
            BufferedReader br = new BufferedReader(isr);           
            StringBuffer sb = new StringBuffer();   
            String temp = null;   
            while((temp = br.readLine()) != null){   
            	sb.append(temp).append("\n");                  
            }   
            br.close();
            return sb.toString();   
        } catch (FileNotFoundException e) {
            e.printStackTrace();             
        }catch (IOException e) {
            e.printStackTrace();
        }   
        return null;
	}
	
}