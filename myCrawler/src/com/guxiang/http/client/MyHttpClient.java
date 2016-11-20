package com.guxiang.http.client;

import java.io.IOException;

import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.params.ConnRouteParams;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.util.EntityUtils;

public class MyHttpClient {
	/*
	 * 使用httpclient 爬取网站
	 */
	public static void main(String[] args) throws Exception {
		//创建httpclient对象
		HttpClient hClient =new DefaultHttpClient();
		
		//设置响应时间，传源码的时间，设置代理服务器
		//为什么设置代理服务器？   
		//防止 访问网址使用了反爬虫技术 如果识别出你的程序是爬虫 那么就会将你的IP加入黑名单 导致你无法访问
		hClient.getParams()
		.setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT,100000)
		.setParameter(CoreConnectionPNames.SO_TIMEOUT, 100000)
		.setParameter(ConnRouteParams.DEFAULT_PROXY, new HttpHost("58.251.166.240",8000));
		
		//创建get请求对象
		HttpGet hGet = new HttpGet("http://www.itcast.cn/");
		//向网站发取请求 获取源代码
		HttpResponse response = hClient.execute(hGet);
		//用EntityUtils工具类吧网页转换成字符串
		String content = EntityUtils.toString(response.getEntity(), "utf-8");
		System.out.println(content);
		
	}
}
