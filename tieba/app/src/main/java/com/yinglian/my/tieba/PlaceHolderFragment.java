package com.yinglian.my.tieba;
import android.widget.ImageView;
import android.view.LayoutInflater;
import android.view.View;
import android.support.v4.app.Fragment;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import java.lang.reflect.Field;
import android.content.Context;
import android.support.v4.widget.ViewDragHelper;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Button;
import android.widget.*;



public class PlaceHolderFragment extends Fragment
{
	private ImageView one;
	private ImageView two;
	private ImageView three;
	private Toolbar toolbar;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		View rootView=inflater.inflate(R.layout.fragment_main, container, false);

		one = (ImageView)rootView.findViewById(R.id.fragmainbottomtoolbarImageButton1);
		two = (ImageView)rootView.findViewById(R.id.fragmainbottomtoolbarImageButton2);
		three = (ImageView)rootView.findViewById(R.id.fragmainbottomtoolbarImageButton3);

		one.setOnClickListener(new OnClickListener(){
				public void onClick(View p1)
				{
					getFragmentManager().beginTransaction()
						.replace((R.id.fragmentmainFrameLayout), new ForumMain())
						.commit();
					toolbar.setTitle("贴吧");
					one.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.Auqamarin));
					two.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.GhostWhite));
					three.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.GhostWhite));
				}
			});

		DrawerLayout mDrawerLayout = (DrawerLayout)rootView.findViewById(R.id.drawerlayout);
		toolbar = (Toolbar)rootView.findViewById(R.id.toolbar);
		((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

		two.setOnClickListener(new OnClickListener(){
				public void onClick(View p1)
				{
					getFragmentManager().beginTransaction()
						.replace((R.id.fragmentmainFrameLayout), new NetdiscMain())
						.commit();
					toolbar.setTitle("网盘");
					one.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.GhostWhite));
					two.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.Auqamarin));
					three.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.GhostWhite));
				}
			});

		ActionBarDrawerToggle mToggle = new ActionBarDrawerToggle
		(getActivity(), mDrawerLayout, toolbar, R.string.open, R.string.close);
		mToggle.syncState();
		mDrawerLayout.addDrawerListener(mToggle);

		three.setOnClickListener(new OnClickListener(){
				public void onClick(View p1)
				{
					toolbar.setTitle("设置");
					getFragmentManager().beginTransaction()
						.replace((R.id.fragmentmainFrameLayout), new SettingMain())
						.commit();
					one.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.GhostWhite));
					two.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.GhostWhite));
					three.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.Auqamarin));
				}
			});
			
		DisplayMetrics dm = getResources().getDisplayMetrics();
		int width = dm.widthPixels;
		ImageView touxiang=(ImageView)rootView.findViewById(R.id.drawerlayoutleftImageView);
		LinearLayout.LayoutParams params= (LinearLayout.LayoutParams) touxiang.getLayoutParams();
		params.width=width*2/5;
		params.height=width*2/5;
		touxiang.setLayoutParams(params);
		
		Button aaa=(Button)rootView.findViewById(R.id.drawerlayoutleftButton1);
		aaa.setOnClickListener(new OnClickListener(){
			@Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction()
					.replace(R.id.container, new PlaceHolderFragment())
					.commit();
			}
		});

		return rootView;
	}
}
