package com.luoli.guideviewtest;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.luoli.guideviewtest.GuideView.GuideViewUtil;

public class ThridActivity extends Activity {
	private Button mButton;
	private GuideViewUtil mGuideViewUtil;
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.thrid);
	mGuideViewUtil=new GuideViewUtil(this, R.drawable.xinshou5);
	mButton=(Button)findViewById(R.id.bt_3);
	mButton.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
		Intent intent=new Intent(ThridActivity.this, SecondActivity.class);
		startActivity(intent);
		finish();
		}
	});
}
}
