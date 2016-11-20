package com.guxiang.http.client;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MyJsoup {
	/*
	 * 使用Jsoup解析网页源码
	 */
	public static void main(String[] args) throws Exception {
		//使用jsoup向服务器发送请求
		Document doc = Jsoup.connect("http://www.itcast.cn").get();
		/*Elements elements = doc.getElementsByTag("a");
		System.out.println(elements);*/
		//使用类似于jquery 和 css 这样的选择器的方式进行元素节点访问
		
		Elements elements = doc.select("ul.nav_txt a");
		//循环元素
		for (Element element : elements) {
			System.out.println(element.text()+":"+element.attr("href"));
		}
	}
}
