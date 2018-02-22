package com.yinglian.my.tieba;
import java.net.*;
import java.io.*;

public class HttpService
{
	protected static String getHttp(String path,String cookie)
	{
		try{
			URL url = new URL(path);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setConnectTimeout(5000);
			conn.setReadTimeout(5000);
			conn.setRequestProperty("Cookie", cookie);
			InputStream inStream = conn.getInputStream();
			byte[] data = readInputStream(inStream);
			String html = new String(data, "utf-8");
			return html;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	protected static String postHttp(String url,String path){
		try
		{
			URL url1=new URL(url);
			HttpURLConnection conn=(HttpURLConnection)url1.openConnection();
			conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.1"+"(KHTML, like Gecko) Chrome/21.0.1180.89 Safari/537.1");
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			OutputStreamWriter osw=new OutputStreamWriter(conn.getOutputStream(),"utf-8");
			BufferedWriter bw=new BufferedWriter(osw);
			bw.write(path);
			bw.flush();
			conn.setConnectTimeout(5000);
			conn.setReadTimeout(5000);
			InputStream inStream = conn.getInputStream();
			byte[] data = readInputStream(inStream);
			String html = new String(data, "utf-8");
			return html;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public static byte[] readInputStream(InputStream inStream) throws Exception
	{
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int len = 0;
		while ((len = inStream.read(buffer)) != -1)
		{
			outStream.write(buffer, 0, len);
		}
		inStream.close();
		return outStream.toByteArray();
	}
}
