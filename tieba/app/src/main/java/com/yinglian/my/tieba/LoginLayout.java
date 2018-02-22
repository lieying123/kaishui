package com.yinglian.my.tieba;

import android.support.v4.app.Fragment;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebChromeClient;
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
		webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webView.getSettings().setSupportMultipleWindows(true);
        webView.getSettings().setBuiltInZoomControls(true);
		webView.getSettings().setAllowFileAccess(true);
		//setAllowFileAccess设置可以访问文件，这个权限很重要，没有就不能访问
        webView.setWebChromeClient(new WebChromeClient());
		webView.loadUrl("http://wappass.baidu.com/passport/?login");
		webView.setWebViewClient(new WebViewClient(){

				@Override
				public boolean shouldOverrideUrlLoading(WebView view, String url)
				{  
					if (url.contains("wap.baidu.com"))
					{
						
					}
					else
					{  
						view.loadUrl(url);  
					}  
					return true;  
				}  
			});
		return rootView;
	}
}
