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
	 * ʹ�� httpclient ��jsoup ʵ������
	 * httpclient �����󣬻�ȡ����
	 * jsoup����Դ����
	 */
	public static void main(String[] args) throws Exception {
		HttpClient httpClient = new DefaultHttpClient();
		//ȡget����
		HttpGet httpGet = new HttpGet("https://www.taobao.com/");
		HttpResponse response = httpClient.execute(httpGet);
		//content  ������ҳԴ��
		String content = EntityUtils.toString(response.getEntity(),"utf-8");
		Document doc = Jsoup.parse(content);
	
		Elements elements = doc.getElementsByTag("a");
		for (Element element : elements) {
			System.out.println(element.text()+" : "+element.attr("href"));
		}
		
	}
}
