package com.luoli.guideviewtest_two;


import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

public class SecondActivity extends Activity {
    private Button mButton_1;
    private Button mButton_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
    }
}
