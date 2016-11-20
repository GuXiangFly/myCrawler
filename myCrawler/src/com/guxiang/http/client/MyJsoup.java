package com.guxiang.http.client;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MyJsoup {
	/*
	 * ʹ��Jsoup������ҳԴ��
	 */
	public static void main(String[] args) throws Exception {
		//ʹ��jsoup���������������
		Document doc = Jsoup.connect("http://www.itcast.cn").get();
		/*Elements elements = doc.getElementsByTag("a");
		System.out.println(elements);*/
		//ʹ��������jquery �� css ������ѡ�����ķ�ʽ����Ԫ�ؽڵ����
		
		Elements elements = doc.select("ul.nav_txt a");
		//ѭ��Ԫ��
		for (Element element : elements) {
			System.out.println(element.text()+":"+element.attr("href"));
		}
	}
}
