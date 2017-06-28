package com.luoli.guideviewtest;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.luoli.guideviewtest.GuideView.GuideViewUtil;

public class SecondActivity extends Activity{
	private Button mButton_1;
	private Button mButton_2;
	private GuideViewUtil mGuideViewUtil;
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.second);
	mGuideViewUtil=new GuideViewUtil(SecondActivity.this, R.drawable.xinshou3);
	mButton_1=(Button)findViewById(R.id.bt_2_1);
	mButton_2=(Button)findViewById(R.id.bt_2_3);
	mButton_1.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent=new Intent(SecondActivity.this, MainActivity.class);
			startActivity(intent);
			finish();
		}
	});
	mButton_2.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
		Intent intent=new Intent(SecondActivity.this, ThridActivity.class);
		startActivity(intent);
		finish();
		}
	});
}
}
