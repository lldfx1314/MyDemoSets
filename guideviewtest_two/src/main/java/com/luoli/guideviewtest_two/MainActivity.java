package com.luoli.guideviewtest_two;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.luoli.guideviewtest_two.base.BasicActivity;

public class MainActivity extends BasicActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button)findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
            }
        });

        setGuideResId(R.drawable.xinshou1);//添加引导页
        setGuideResId(R.drawable.xinshou3);//添加引导页
        setGuideResId(R.drawable.xinshou5);//添加引导页
    }
}