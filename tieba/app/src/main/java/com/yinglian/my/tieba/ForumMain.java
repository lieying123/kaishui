package com.yinglian.my.tieba;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.os.Bundle;
import android.content.SharedPreferences;
import android.widget.*;
import android.os.AsyncTask;

public class ForumMain extends Fragment
{
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		final View rootView=inflater.inflate(R.layout.fragment_tieba_main, container, false);
		SharedPreferences pref =getActivity().getSharedPreferences("data",0); 
		String cookie = pref.getString("cookie","");
		if(cookie.length()>1){
			new AsyncTask<String,Void,String>(){
				@Override
				protected String doInBackground(String[] args)
				{
					String article=HttpService.getHttp("http://tieba.baidu.com/f/like/mylike",args[0]);
					return article;
				};
				@Override
				protected void onPostExecute(String result)
				{
					TextView i=(TextView)rootView.findViewById(R.id.fragmenttiebamainTextView1);
					i.setText(result);
				}
			}.execute(cookie); 
		
		
		//Toast.makeText(getActivity(), cookie,Toast.LENGTH_SHORT).show();
							   }
		return rootView;
	}
}

