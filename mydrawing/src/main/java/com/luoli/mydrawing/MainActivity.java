package com.luoli.mydrawing;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.luoli.mydrawing.eventbus.FirstEvent;
import com.luoli.mydrawing.eventbus.SecondEvent;
import com.luoli.mydrawing.view.CustomPopWindow;
import com.luoli.mydrawing.view.MyView;
import com.luoli.mydrawing.view.PopUpMenuView;

import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;
import de.greenrobot.event.ThreadMode;

//import org.greenrobot.eventbus.EventBus;
//import org.greenrobot.eventbus.Subscribe;
//import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnSystemUiVisibilityChangeListener {

    private PopUpMenuView popUpMenuView;
    private Button btnTop;
    private Button btnDownload;
    private Button btnPopupwindow;
    private PopupWindow popupWindow;
    private CustomPopWindow popWindow;
    private Button btnPopupwindow2;
    private Button countDownTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        requestWindowFeature(Window.FEATURE_ACTION_BAR_OVERLAY);
        requestWindowFeature(Window.FEATURE_ACTION_MODE_OVERLAY);
        setContentView(R.layout.activity_main);
//        setStatusBarTransparent();
        // 注册EventBus
        EventBus.getDefault().register(this);
        findView();
        RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        new RecyclerView(this).setRecycledViewPool(viewPool);
        viewPool.setMaxRecycledViews(0,10);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }


    @Subscribe(threadMode = ThreadMode.MainThread)
    public void onFirstEvent(FirstEvent event){
        String msg = "onFirstEvent收到了消息：" + event.getMsg();
        Log.d("luoli", msg);
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Subscribe(threadMode = ThreadMode.PostThread)
    public void onSecondEvent(SecondEvent event){
        String msg = "onSecondEvent收到了消息：" + event.getMsg();
        Log.d("luoli", msg);
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }


    /******************************************/
//    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
//    public void onEventMainThread(StateEvent event) {
//        Log.d(TAG, "StateEvent is emitted");
//    }
//    public void onEventMainThread(FirstEvent event) {
//
//        String msg = "onEventMainThread收到了消息：" + event.getMsg();
//        Log.d("luoli", msg);
////        tv.setText(msg);
//        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
//    }


    @Override
    protected void onResume() {
        super.onResume();
        int[] location = new int[2];
        btnDownload.getLocationOnScreen(location);
        int x = location[0];
        int y = location[1];
        Toast.makeText(this, "哈哈x：" + x + "++y：" + y, Toast.LENGTH_SHORT).show();
    }

    public void goToSend(View view) {
        startActivity(new Intent(MainActivity.this, SendMessageActivity.class));
    }

    public void verificationCode(View view){
        startActivity(new Intent(MainActivity.this, VerificationCodeActivity.class));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.reset1:
                startActivity(new Intent(MainActivity.this, ChangeActivity.class));
                break;
            case R.id.btn_top:
                startActivity(new Intent(MainActivity.this, PopupActivity.class));
                break;
            case R.id.btn_download:
                startActivity(new Intent(MainActivity.this, DownLoadActivity.class));
                break;
            case R.id.btn_popupwindow2:
                startActivity(new Intent(MainActivity.this, PopupWindow2Activity.class));
                break;
            case R.id.countDownTime:
                startActivity(new Intent(MainActivity.this, CountDownTimeActivity.class));
                break;
            case R.id.btn_popupwindow:
//                View view = View.inflate(this,R.layout.view_popup_window,null);
//                PopupWindow popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//                View view = View.inflate(this, R.layout.view_popup_window, null);
//                //　弹窗里按钮的点击事件
//                handleLogic(view);
//                popupWindow = new PopupWindow();
//                popupWindow.setContentView(view);
//                popupWindow.setAnimationStyle(R.style.popupwindow);
//                popupWindow.setWidth(dp2sp(250));
//                popupWindow.setHeight(dp2sp(150));
//                popupWindow.setBackgroundDrawable(new ColorDrawable(Color.WHITE));
//                popupWindow.setOutsideTouchable(false);
//                popupWindow.setFocusable(true);
////                popupWindow.setC
//                popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
//                    @Override
//                    public void onDismiss() {
////                        Toast.makeText(MainActivity.this,"弹窗消失了",Toast.LENGTH_SHORT).show();
//                        recover();
//                    }
//                });
//                popupWindow.showAsDropDown(btnPopupwindow, 350, 10);
                /*********************************************************************/
                View contentView = LayoutInflater.from(this).inflate(R.layout.view_popup_window, null);
                //　弹窗里按钮的点击事件
                handleLogic(contentView);
                popWindow = new CustomPopWindow.PopupWindowBuilder(this)
                        .setView(contentView)//显示的布局
                        .enableBackgroundDark(true)
                        .setFocusable(true)
                        .setAnimationStyle(R.style.popupwindow)
                        .setBgDarkAlpha(0.3f)
                        .create()//创建PopupWindow
                        .showAsDropDown(btnPopupwindow, 350, 10);
                break;
        }
    }


    /**
     * 处理弹窗显示内容、点击事件等逻辑
     *
     * @param contentView
     */
    private void handleLogic(View contentView) {
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (popWindow != null) {
                    popWindow.dissmiss();
                }
                String showContent = "";
                switch (v.getId()) {
                    case R.id.tv_menu01:
                        showContent = "点击 Item菜单1";
                        break;
                }
                Toast.makeText(MainActivity.this, showContent, Toast.LENGTH_SHORT).show();
            }
        };
        contentView.findViewById(R.id.tv_menu01).setOnClickListener(listener);
    }

    /**
     * 弹出popupWindow变暗
     */
    private void turnDark() {
        WindowManager.LayoutParams lp = this.getWindow().getAttributes();
        lp.alpha = 0.5f;
        this.getWindow().setAttributes(lp);
        this.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
    }

    private void findView() {
        final MyView myView = (MyView) findViewById(R.id.myview);
        findViewById(R.id.reset).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myView.reset();
            }
        });
        findViewById(R.id.btn_animate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AnimateActivity.class));
            }
        });
        Button reset1 = (Button) findViewById(R.id.reset1);
        reset1.setOnClickListener(this);
        btnTop = (Button) findViewById(R.id.btn_top);
        btnTop.setOnClickListener(this);
        btnDownload = (Button) findViewById(R.id.btn_download);
        btnDownload.setOnClickListener(this);

        popUpMenuView = (PopUpMenuView) findViewById(R.id.popUpMenuView);
        popUpMenuView.setOnClickListener(this);
        // 弹出popupwindow
        btnPopupwindow = (Button) findViewById(R.id.btn_popupwindow);
        btnPopupwindow.setOnClickListener(this);
        // 弹出popupwindow
        btnPopupwindow2 = (Button) findViewById(R.id.btn_popupwindow2);
        btnPopupwindow2.setOnClickListener(this);
        //　倒计时
        countDownTime = (Button) findViewById(R.id.countDownTime);
        countDownTime.setOnClickListener(this);
    }

    /**
     * popupWindow消失的时候恢复
     */
    private void recover() {
        WindowManager.LayoutParams lp = this.getWindow().getAttributes();
        lp.alpha = 1.0f;
        this.getWindow().setAttributes(lp);
        this.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
    }

    private int dp2sp(int dp) {
        float density = getResources().getDisplayMetrics().density;
        return (int) (dp * density + 0.5);
    }


    private void setStatusBarTransparent() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //托盘重叠显示在Activity上
            View decorView = getWindow().getDecorView();
            int uiOptions = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(uiOptions);
            decorView.setOnSystemUiVisibilityChangeListener(this);
            // 设置托盘透明
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            Log.d("CP_Common", "VERSION.SDK_INT =" + Build.VERSION.SDK_INT);
        } else {
            Log.d("CP_Common", "SDK 小于19不设置状态栏透明效果");
        }
    }

    @Override
    public void onSystemUiVisibilityChange(int visibility) {

    }
}
