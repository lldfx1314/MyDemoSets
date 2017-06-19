package com.luoli.mydrawing;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.luoli.mydrawing.view.MyView1;

/**
 * Created by LUOLI on 2017/5/15.
 */
public class ChangeActivity extends AppCompatActivity{

    private MyView1 myView1;
    private Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change);
        myView1 = (MyView1) findViewById(R.id.myview1);
        button = (Button) findViewById(R.id.button_zt);

        myView1.startAnim();
//        Handler handler = new Handler();
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                myView1.stopAnim();
//            }
//        },10000);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(myView1.isRunning()){
                    // 动画正在运行，停止
                    myView1.stopAnim();
                    button.setText("开始");
                }else{
                    // 动画停止运行，开始
                    myView1.startAnim();
                    button.setText("结束");
                }
            }
        });
    }
}
