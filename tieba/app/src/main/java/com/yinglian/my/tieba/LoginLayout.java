package com.yinglian.my.tieba;

import android.support.v4.app.Fragment;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;
import java.net.URL;
import java.net.HttpURLConnection;
import java.io.IOException;
import java.util.Map;
import java.util.List;
import java.net.MalformedURLException;

public class LoginLayout extends Fragment
{
	private WebView webView;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		View rootView=inflater.inflate(R.layout.login, container, false);
		webView = (WebView) rootView.findViewById(R.id.webView);
		webView.getSettings().setJavaScriptEnabled(true);
		webView.getSettings().setAllowFileAccess(true);
		webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
		//setAllowFileAccess设置可以访问文件，这个权限很重要，没有就不能访问
		webView.loadUrl("http://wappass.baidu.com/passport/?login");
		webView.onResume();
		webView.canGoForward();
		webView.setWebViewClient(new WebViewClient(){
				@Override
				public boolean shouldOverrideUrlLoading(WebView view, String url1)
				{  
					if (url1.contains("wap.baidu.com"))
					{
						try
						{
							URL url = new URL(url1);
							HttpURLConnection conn = (HttpURLConnection) url.openConnection();
							conn.setRequestMethod("GET");
							conn.connect();
							if (conn.getResponseCode() == HttpURLConnection.HTTP_OK)
							{
								Map<String, List<String>> headFields = conn.getHeaderFields();
								List<String> cookieList = headFields.get("Set-Cookie");

							}
						}
						catch (MalformedURLException e)
						{}
						catch (IOException e)
						{}

					}
					view.loadUrl(url1);
					return true;  
				}  
			});
		return rootView;
	}
}
