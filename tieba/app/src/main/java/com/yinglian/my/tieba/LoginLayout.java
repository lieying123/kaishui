package com.yinglian.my.tieba;

import android.support.v4.app.Fragment;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;

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
				public boolean shouldOverrideUrlLoading(WebView view, String url)
				{  
					if (url.contains("wap.baidu.com"))
					{
						
					}
					view.loadUrl(url);
					return true;  
				}  
			});
		return rootView;
	}
}
