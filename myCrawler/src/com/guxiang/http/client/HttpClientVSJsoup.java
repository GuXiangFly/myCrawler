package com.guxiang.http.client;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HttpClientVSJsoup {
	/*
	 * 使用 httpclient 和jsoup 实现爬虫
	 * httpclient 发请求，获取代码
	 * jsoup解析源代码
	 */
	public static void main(String[] args) throws Exception {
		HttpClient httpClient = new DefaultHttpClient();
		//取get请求
		HttpGet httpGet = new HttpGet("https://www.taobao.com/");
		HttpResponse response = httpClient.execute(httpGet);
		//content  就是网页源码
		String content = EntityUtils.toString(response.getEntity(),"utf-8");
		Document doc = Jsoup.parse(content);
	
		Elements elements = doc.getElementsByTag("a");
		for (Element element : elements) {
			System.out.println(element.text()+" : "+element.attr("href"));
		}
		
	}
}
