package com.yinglian.my.tieba;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.support.v7.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
		if (savedInstanceState == null)
		{
			getSupportFragmentManager().beginTransaction()
				//在这里载入的是主碎片
				.add(R.id.container, new PlaceHolderFragment())
				//在这里载入的是子碎片
				.add(R.id.fragmentmainFrameLayout, new ForumMain())
				.commit();
		}
    }
}
