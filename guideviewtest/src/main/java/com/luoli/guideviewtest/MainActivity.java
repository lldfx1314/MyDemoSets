package com.luoli.guideviewtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.luoli.guideviewtest.GuideView.GuideViewUtil;

public class MainActivity extends AppCompatActivity {

    private Button mButton;
    private GuideViewUtil mGuideViewUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton =(Button)findViewById(R.id.bt_1);
        mButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent=new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
                finish();
            }
        });
        mGuideViewUtil=new GuideViewUtil(this, R.drawable.xinshou1);
        mGuideViewUtil.setGuideView();
    }
}
