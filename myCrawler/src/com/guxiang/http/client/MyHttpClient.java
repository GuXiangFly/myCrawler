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
	 * ʹ��httpclient ��ȡ��վ
	 */
	public static void main(String[] args) throws Exception {
		//����httpclient����
		HttpClient hClient =new DefaultHttpClient();
		
		//������Ӧʱ�䣬��Դ���ʱ�䣬���ô��������
		//Ϊʲô���ô����������   
		//��ֹ ������ַʹ���˷����漼�� ���ʶ�����ĳ��������� ��ô�ͻὫ���IP��������� �������޷�����
		hClient.getParams()
		.setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT,100000)
		.setParameter(CoreConnectionPNames.SO_TIMEOUT, 100000)
		.setParameter(ConnRouteParams.DEFAULT_PROXY, new HttpHost("58.251.166.240",8000));
		
		//����get�������
		HttpGet hGet = new HttpGet("http://www.itcast.cn/");
		//����վ��ȡ���� ��ȡԴ����
		HttpResponse response = hClient.execute(hGet);
		//��EntityUtils���������ҳת�����ַ���
		String content = EntityUtils.toString(response.getEntity(), "utf-8");
		System.out.println(content);
		
	}
}
