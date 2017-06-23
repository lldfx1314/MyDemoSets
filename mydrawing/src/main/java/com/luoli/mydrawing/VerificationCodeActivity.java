package com.luoli.mydrawing;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.luoli.mydrawing.utils.Urls;
import com.luoli.mydrawing.utils.Utils;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import tech.michaelx.authcode.AuthCode;
import tech.michaelx.authcode.CodeConfig;

/**
 * Created by LUOLI on 2017/6/23.
 */
public class VerificationCodeActivity extends AppCompatActivity implements View.OnClickListener {
    private static final int REQUEST_PERMISSION_CODE = 0;
    private EditText etLoginMsgSecurity;
    private TextView tvLoginMsgSecurity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_code);
        handlePermission();


//        OkHttpClient client =
//                OkHttpUtils.getInstance().getOkHttpClient();
//        client.setConnectTimeout(60000, TimeUnit.MILLISECONDS);

        // 输入验证码
        etLoginMsgSecurity = (EditText) findViewById(R.id.et_loginMsg_security);
        // 获取验证码
        tvLoginMsgSecurity = (TextView) findViewById(R.id.tv_loginMsg_security);
        tvLoginMsgSecurity.setOnClickListener(this);
        CodeConfig config = new CodeConfig.Builder()
                .codeLength(4) // 设置验证码长度
                .smsFromStart(156) // 设置验证码发送号码前几位数字
                .smsFrom(Long.parseLong("15620606679")) // 如果验证码发送号码固定，则可以设置验证码发送完整号码
                .smsBodyStartWith("安互保科技") // 设置验证码短信开头文字
                .smsBodyContains("验证码") // 设置验证码短信内容包含文字
                .build();
        AuthCode.getInstance().with(this).config(config).into((etLoginMsgSecurity));
    }

    @Override
    public void onClick(View v) {
        // 定义一个方法获取验证码
        Toast.makeText(this,"已发送",Toast.LENGTH_SHORT).show();
//        getSecurityCode();

    }
    /**
     * 简单处理了短信权限
     */
    private void handlePermission() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_SMS)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.READ_SMS}, REQUEST_PERMISSION_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_PERMISSION_CODE) {
            if (grantResults.length != 0) {
                if (grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "您阻止了app读取您的短信，你可以自己手动输入验证码", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
    /**
     * 获取验证码
     */
//    private void getSecurityCode() {
//        // 调用方法先判断手机号码是否合法
//        isLegal = Utils.judgePhoneNumber(phoneNumber);
//        if (TextUtils.isEmpty(phoneNumber)) {
//            showdialog("请输入手机号码");
//            return;
//        } else if (!isLegal) {
//            // 不合法，弹出对话框提示用户
//            showdialog("请输入正确的手机号码");
//            return;
//        } else {
//            // 合法，就获取验证码
//            getSecuritys();
//        }
//    }
//
//    /**
//     * 获取验证码
//     */
//    private void getSecuritys() {
//        // 把光标移动到验证码输入框
//        Utils.setEditTextSelection(etLoginMsgSecurity);
//        // 第一次请求获取验证的token
//        getToken();
//
//    }
//
//    /**
//     * 第一次请求获取验证的token
//     */
//    private void getToken() {
//
//        String url = Urls.Url_Token;
//        OkHttpUtils.get()//
//                .url(url)//
//                .build()//
//                .execute(new MyStringCallback());
//
//
//    }
//
//    class MyStringCallback extends StringCallback {
//
//        @Override
//        public void onError(Request request, Exception e) {
//            System.out.println("Login_Message+++token===没拿到数据" + e.getMessage());
//        }
//
//        @Override
//        public void onResponse(String response) {
//            Security_Token_Bean bean = new Gson().fromJson(response, Security_Token_Bean.class);
//            if (bean != null) {
//                // 拿到checkCompleteBean，获取token
//                token = bean.data.token;
//                // 第二次请求获取验证码
//                if (token != null) {
//                    // 第一次请求获取验证的token不为为空，则第二次请求获取验证码
//                    getSecurity();
//
//                } else {
//                    // 为空，则弹吐司提示用户
//                    showdialog("网络有误，请稍后再试");
//                }
//            }
//        }
//    }
//
//    /**
//     * 第二次请求获取验证码
//     */
//    private void getSecurity() {
//        // 更改获取验证码的TextView显示的内容
//        Utils.setSecurityTextView(tvLoginMsgSecurity);
//
//        String url = Urls.Url_Security;
//        HashMap<String, String> params = new HashMap<>();
//        params.put("mobile", phoneNumber);
//        params.put("token", token);
//
//        OkHttpUtils.post()//
//                .url(url)//
//                .params(params)//
//                .build()//
//                .execute(new MyStringCallback1());
//    }
//
//    class MyStringCallback1 extends StringCallback {
//
//        @Override
//        public void onError(Request request, Exception e) {
//            System.out.println("Login_Message+++验证码===没拿到数据" + e.getMessage());
//        }
//
//        @Override
//        public void onResponse(String response) {
//            Security_Bean bean = new Gson().fromJson(response, Security_Bean.class);
//        }
//    }
}
