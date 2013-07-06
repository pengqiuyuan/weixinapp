package com.weixin.app.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("httpClientUtil")
public class HttpClientUtil{
	
	private final static Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);

	public static List<String> createHttpClient(String url, String reg){
		List<String> reponses = new ArrayList<String>();
		HttpClient client = new HttpClient();
		String response = null;
		PostMethod postMethod = new PostMethod(url);
		postMethod.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "utf-8");
		try {
			int statusCode = client.executeMethod(postMethod);
			System.out.println("status: " + statusCode);
			if(statusCode == org.apache.commons.httpclient.HttpStatus.SC_OK){
				response = postMethod.getResponseBodyAsString();
				Pattern p = null;
				Matcher m = null;
				StringBuffer sb = new StringBuffer();
				int count = 0;
				p = Pattern.compile(reg);
				m = p.matcher(response);
				while(m.find()){
					reponses.add(m.group());
					count ++;
				}
				System.out.println("抓取条数：" + count);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return reponses;
	}
	
	public static void main(String[] args) {
//		String reg = "/html/\\w+.shtml[^>]+title=\"[^>]+\"";
//		String reg = "name='fCssceaca'[^>]+><[^>]+";
		String reg = "name='fCssceaca'[^>]+><[^>]+>[^<]+</a></span>[\\s]+</span><span style='float:right;'><span class='modeFileAddOnscss' >[^<]+";
		List<String> responses = createHttpClient("http://218.193.119.253:1958/listb.aspx?page=1&menuid=1335", reg);
		Map<String, String> values = new HashMap<String, String>();
		String[] tmp = {};
		for(String response : responses){
//			tmp = response.split("\"");
//			values.put(tmp[0], tmp[2]);
			System.out.println(response);
//			String p = response.replaceAll("\\&[a-zA-Z]{1,10};", "").replaceAll("<[^>]*>", "");
//			System.out.println(p);
		}
//		Set<Entry<String, String>> set = values.entrySet();
//        for (Iterator<Map.Entry<String, String>> it = set.iterator(); it.hasNext();) {
//            Map.Entry<String, String> entry = (Map.Entry<String, String>) it.next();
//            System.out.println(entry.getKey() + "--->" + entry.getValue());
//        }
    }
	
}