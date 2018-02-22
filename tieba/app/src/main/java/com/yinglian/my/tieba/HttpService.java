package com.yinglian.my.tieba;
import java.net.*;
import java.io.*;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.HttpResponse;
import org.apache.http.HttpEntity;
import org.apache.http.util.EntityUtils;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.*;

public class HttpService
{
	public static String getHttp(String path)
	{
		String json=null;
		try
		{
			URL url=new URL(path);
			URI uri=new URI(url.getProtocol(), url.getHost(), url.getPath(), url.getQuery(), null);
			HttpClient http=new DefaultHttpClient();
			HttpGet httpGet=new HttpGet(uri);
			HttpResponse response=http.execute(httpGet);
			HttpEntity entity=response.getEntity();
			json = EntityUtils.toString(entity);
		}
		catch (MalformedURLException e)
		{}
		catch (URISyntaxException e)
		{}
		catch (IOException e)
		{}

		return json;
	}

	public static String getHttpWithCookie(String path, String cookies)
	{
		HttpClient httpClient = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet(path);
		//String Au="Bearer "+access_token;
		//httpGet.setHeader("Authorization",Au);  
		httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.1"+"(KHTML, like Gecko) Chrome/21.0.1180.89 Safari/537.1");
		httpGet.addHeader(new BasicHeader("Cookie",cookies));
		HttpResponse response = null;  
		try{
			response = httpClient.execute(httpGet);
		}catch (Exception e) {} 
		String temp="";
		try{
			HttpEntity entity = response.getEntity();
			temp=EntityUtils.toString(entity,"UTF-8");
		}catch (Exception e) {} 
		return temp;
	}
}
