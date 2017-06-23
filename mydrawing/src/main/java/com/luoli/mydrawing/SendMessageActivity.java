package com.luoli.mydrawing;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.luoli.mydrawing.eventbus.FirstEvent;
import com.luoli.mydrawing.eventbus.SecondEvent;

import de.greenrobot.event.EventBus;


/**
 * Created by LUOLI on 2017/6/21.
 */
public class SendMessageActivity extends AppCompatActivity{
    private Button btn_FirstEvent;
    private Button btn_SecondEvent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message);
        btn_FirstEvent = (Button) findViewById(R.id.btn_first_event);
        btn_SecondEvent = (Button) findViewById(R.id.btn_second_event);

        btn_FirstEvent.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                EventBus.getDefault().post(
                        new FirstEvent("FirstEvent btn clicked"));
            }
        });
        btn_SecondEvent.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                EventBus.getDefault().post(
                        new SecondEvent("SecondEvent btn clicked"));
            }
        });
    }
}
