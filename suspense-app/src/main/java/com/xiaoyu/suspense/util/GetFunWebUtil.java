package com.xiaoyu.suspense.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.htmlparser.util.NodeList;

public class GetFunWebUtil {

	public static List<String> getFunUrl(String strUrl) {
		List<String> strList = new ArrayList<String>();
		NodeList rt = GetWebUtil.getNodeList(strUrl);
		//String strHtml = HtmlRegexpUtil.replaceText(HtmlRegexpUtil.filterHtml(rt.toHtml(), "<span.*?</span>"));
		String strHtml = HtmlRegexpUtil.replaceText(rt.toHtml());
		Pattern pattern = Pattern.compile("<divclass=\"list_title\"><ul>.*?</ul></div>");
		Matcher matcher = pattern.matcher(strHtml);
		boolean result = matcher.find();
		if (result) {
			String str1 = matcher.group();
			Pattern pattern1 = Pattern.compile("<ahref=\".*?\"target=\"_blank\">.*?</a>");
			Matcher matcher1 = pattern1.matcher(str1);
			boolean result1 = matcher1.find();
			while (result1) {
				String str2 = matcher1.group();
				strList.add(str2);
				result1 = matcher1.find();
			}
		}
		List<String> strList1 = new ArrayList<String>();
		for(String str : strList) {
			String str1 = "http://www.jokeji.cn" + str.substring(8, str.indexOf("\"target=\"_blank\">")).replace("冷笑话", "%E5%86%B7%E7%AC%91%E8%AF%9D");
			strList1.add(str1);
			//System.out.println(str1);
		}
		return strList1;
	}
	
	public static List<String> getFunContent(String strUrls) {
		List<String> contentList = new ArrayList<String>();
		List<String> strList = getFunUrl(strUrls);
		for(String strUrl : strList) {			
			NodeList rt = GetWebUtil.getNodeList(strUrl);
			String strHtml = HtmlRegexpUtil.replaceText(rt.toHtml());
			Pattern pattern = Pattern.compile("<spanid=\"text110\">.*?</P><P><Ahref=");
			Matcher matcher = pattern.matcher(strHtml);
			boolean result = matcher.find();
			if(!result) {
				pattern = Pattern.compile("<spanid=\"text110\">.*?</span>");
				matcher = pattern.matcher(strHtml);
				result = matcher.find();
			}
			if (result) {
				String str1 = matcher.group();
				str1 = str1.replaceAll("<FONTface=Verdana>", "").replaceAll("</FONT>", "").replaceAll("<STRONG>", "").replace("</STRONG>", "").replaceAll("<SPANclass=content_f>", "").replaceAll("<SPANstyle=\"FONT-SIZE:medium\">", "").replaceAll("</SPAN>", "").replaceAll("<SPAN>", "").replaceAll("</DIV>", "");
				Pattern pattern1 = Pattern.compile("<P>.*?</P>");
				Matcher matcher1 = pattern1.matcher(str1);
				boolean result1 = matcher1.find();
				if(!result1) {
					str1 = str1.replaceAll("</P>", "").replaceAll("<P>", "");
					str1 = str1.substring(19, str1.length() - 7).trim();
					if(str1.startsWith(".")) {
						str1.substring(1).trim();
					}
					removeRule(str1);
					//System.out.println(str1);
					if((str1.length() > 2) && (str1.length() <= 500)) {
						contentList.add(str1);
					}
				}
				if(result1) {
					if(str1.length() > 503) {
						while (result1) {
							String str2 = matcher1.group().replaceAll("</P>", "").replaceAll("<P>", "").trim();
							if(str2.startsWith(".")) {
								str2.substring(1).trim();
							}
							removeRule(str2);
							//System.out.println(str2);
							if((str2.length() > 2) && (str2.length() <= 500)) {
								contentList.add(str2);
							}
							result1 = matcher1.find();
						}
					}else {
						String str3 = "";
						while (result1) {
							String str2 = matcher1.group().replaceAll("</P>", "").replaceAll("<P>", "").trim();
							if(str2.startsWith(".")) {
								str2.substring(1).trim();
							}
							removeRule(str2);
							//System.out.println(str2);
							if((str2.length() > 2) && (str2.length() <= 496)) {
								str3 += str2 + "\n\n";
							}
							result1 = matcher1.find();
						}
						contentList.add(str3);
					}
				}								
			}
		}
		return contentList;
	}
	
	public static String removeRule(String str1) {
		int ks = str1.indexOf("<FONT");
		int js = str1.indexOf(">");
		if(ks >= 0) {
			str1 = str1.substring(0, ks) + str1.substring(js + 1);
		}
		ks = str1.indexOf("<SPAN");
		if(ks >= 0) {
			str1 = str1.substring(0, ks) + str1.substring(js + 1);
		}
		ks = str1.indexOf("<IMG");
		if(ks >= 0) {
			str1 = str1.substring(0, ks) + str1.substring(js + 1);
		}
		ks = str1.indexOf("DIVclass");
		if(ks >= 0) {
			str1 = str1.substring(0, ks) + str1.substring(js + 1);
		}
		ks = str1.indexOf("DIValign");
		if(ks >= 0) {
			str1 = str1.substring(0, ks) + str1.substring(js + 1);
		}
		return str1;
	}
	
	public static void main(String[] args) throws Exception {
		//<a\s*href="?([\w\W]*?)"?[\s]*?[^>]>([\s\S]*?)(?=</a>)
		//<div class="content" title="?([\w\W]*?)">([\s\S]*?)(?=</div>)
		Date date = new Date();
		getFunContent("http://www.gushijiuba.com/chuanqigushi/xuanyigushi/list_18_84.html");
		Date date1 = new Date();
		System.out.println(date1.getTime() - date.getTime());
	}
	
}