package com.xiaoyu.suspense.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.htmlparser.util.NodeList;

public class GetSuspenseWebUtil {

	public static Map<String, List<String>> getSuspenseUrl(String strUrl) {
		Map<String, List<String>> hashMap = new HashMap<String, List<String>>();
		List<String> strUrlList = new ArrayList<String>();
		List<String> strTitleList = new ArrayList<String>();
		List<String> strDescList = new ArrayList<String>();
		NodeList rt = GetWebUtil.getNodeList(strUrl);
		//String strHtml = HtmlRegexpUtil.replaceText(HtmlRegexpUtil.filterHtml(rt.toHtml(), "<span.*?</span>"));
		String strHtml = HtmlRegexpUtil.replaceText(rt.toHtml());
		Pattern pattern = Pattern.compile("<divclass=\"listz\"><ul>.*?</ul></div>");
		Matcher matcher = pattern.matcher(strHtml);
		boolean result = matcher.find();
		if (result) {
			String str1 = matcher.group();
			str1 = str1.substring(23, str1.length());
			//添加URL
			Pattern pattern2 = Pattern.compile("</span><ahref=\".*?\"title=\"");
			Matcher matcher2 = pattern2.matcher(str1);
			boolean result2 = matcher2.find();
			while (result2) {
				String str2 = matcher2.group();
				str2 = "http://www.gushijiuba.com" + str2.substring(15, str2.indexOf("\"title=\""));
				strUrlList.add(str2);
				//System.out.println(str2);
				result2 = matcher2.find();
			}
			//添加标题
			Pattern pattern3 = Pattern.compile("\">.*?</a></li>");
			Matcher matcher3 = pattern3.matcher(str1);
			boolean result3 = matcher3.find();
			while (result3) {
				String str3 = matcher3.group();
				str3 = str3.substring(2, str3.length() - 9);
				strTitleList.add(str3);
				//System.out.println(str3);
				result3 = matcher3.find();
			}
			//添加描述
			Pattern pattern4 = Pattern.compile("<p>.*?</p>");
			Matcher matcher4 = pattern4.matcher(str1);
			boolean result4 = matcher4.find();
			while (result4) {
				String str4 = matcher4.group();
				str4 = str4.substring(3, str4.length() - 4);
				strDescList.add(str4);
				//System.out.println(str4);
				result4 = matcher4.find();
			}
		}
		hashMap.put("strUrlList", strUrlList);
		hashMap.put("strTitleList", strTitleList);
		hashMap.put("strDescList", strDescList);
		return hashMap;
	}
	
	public static List<String> getSuspenseContent(String strUrl) {
		List<String> contentList = new ArrayList<String>();
		NodeList rt = GetWebUtil.getNodeList(strUrl);
		//String strHtml = HtmlRegexpUtil.replaceText(rt.toHtml());
		String strHtml = HtmlRegexpUtil.replaceText(HtmlRegexpUtil.filterHtml(rt.toHtml(), "<span.*?</span>"));
		Pattern pattern = Pattern.compile("</div><p>.*?</p></div><divclass=\"dede_pages\">");
		Matcher matcher = pattern.matcher(strHtml);
		boolean result = matcher.find();
		if (result) {
			String str1 = matcher.group();
			//System.out.println(str1.length());
			str1 = str1.substring(16, str1.length() - 51);
			str1 = str1.replaceAll("</p><p></p><p></p><p>", "\n").replaceAll("</p></p><p></p><p>", "\n").replaceAll("</p></p>", "</p>").replaceAll("<p><p>", "<p>").replaceAll("</p><p>", "\n").replaceAll("</p>", "\n").replaceAll("<p>", "\n").replaceAll("<ahref='http://www.gushijiuba.com/aiqinggushi/'target='_blank'>", "")
					.replace("<ahref='http://www.gushijiuba.com/renshenggushi/'target='_blank'>", "")
					.replaceAll("<ahref='http://www.gushijiuba.com/renshenggushi/qinqinggushi/'target='_blank'>", "").replaceAll("<ahref='http://www.gushijiuba.com/renshenggushi/chuangyegushi/'target='_blank'>", "").replaceAll("<u>", "").replaceAll("</u>", "").replaceAll("</a>", "").replaceAll("</p", "");				
			str1 = HtmlRegexpUtil.replaceTextByTag(str1);
			//System.out.println(str1);
			int length = str1.length();
			if(length < 7992) {
				if(length <= 999) {
					contentList.add(str1.substring(0, length));
				}else {
					contentList.add(str1.substring(0, 998));
					if(length > 1998 ) {
						contentList.add(str1.substring(998, 1997));
						if(length > 2997) {
							contentList.add(str1.substring(1997, 2996));
							if(length > 3996) {
								contentList.add(str1.substring(2996, 3995));
								if(length > 4995) {
									contentList.add(str1.substring(3995, 4994));
									if(length > 5994) {
										contentList.add(str1.substring(4994, 5993));
										if(length > 6993) {
											contentList.add(str1.substring(5993, 6992));
											contentList.add(str1.substring(6992, length - 1));
										}else {
											contentList.add(str1.substring(5993, length));
										}
									}else {
										contentList.add(str1.substring(4994, length));
									}
								}else {
									contentList.add(str1.substring(3995, length));
								}
							}else {
								contentList.add(str1.substring(2996, length));
							}
						}else {
							contentList.add(str1.substring(1997, length));
						}
					}else {
						contentList.add(str1.substring(998, length));
					}
				}
			}			
		}
		return contentList;
	}
	
	public static void main(String[] args) throws Exception {
		//<a\s*href="?([\w\W]*?)"?[\s]*?[^>]>([\s\S]*?)(?=</a>)
		//<div class="content" title="?([\w\W]*?)">([\s\S]*?)(?=</div>)
		Date date = new Date();
		Map<String, List<String>> hashMap = getSuspenseUrl("http://www.gushijiuba.com/chuanqigushi/xuanyigushi/list_18_84.html");
		List<String> strUrlList = hashMap.get("strUrlList");
		List<String> strContentList = new ArrayList<>();
		for(String strUrl : strUrlList) {
			strContentList = new ArrayList<>();
			strContentList = getSuspenseContent(strUrl);
			for(String strContent : strContentList) {
				System.out.println(strContent);
			}			
		}		
		Date date1 = new Date();
		System.out.println(date1.getTime() - date.getTime());
	}

}