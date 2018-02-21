package com.yinglian.my.tieba;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.os.Bundle;

public class NetdiscMain extends Fragment
{
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		View rootView=inflater.inflate(R.layout.fragment_netdisc_main, container, false);
		//这里应该得用一个RecyclerView实现吧名列表
		//第一行是搜索栏
		//贴吧碎片的右上角消息按钮
		return rootView;
	}
}
