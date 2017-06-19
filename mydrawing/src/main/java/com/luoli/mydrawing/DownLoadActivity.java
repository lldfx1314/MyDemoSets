package com.luoli.mydrawing;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.luoli.mydrawing.view.GADownloadingView;

/**
 * Created by LUOLI on 2017/6/9.
 */
public class DownLoadActivity extends AppCompatActivity implements View.OnClickListener {

    private Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
            mProgress += 10;
            if (!isSuccess && mProgress >= 60) {
                mGADownloadingView.onFail();
            }
            mGADownloadingView.updateProgress(mProgress);
            mHandler.postDelayed(mRunnable, UPDATE_PROGRESS_DELAY);
        }
    };

    private static final int UPDATE_PROGRESS_DELAY = 500;

    private GADownloadingView mGADownloadingView;
    private View mShowSuccess, mShowFailed;
    private int mProgress;
    private Handler mHandler = new Handler();
    private boolean isSuccess = true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);
        initViews();
    }
    private void initViews() {
        mGADownloadingView = (GADownloadingView) findViewById(R.id.ga_downloading);
        mShowSuccess = findViewById(R.id.show_success);
        mShowSuccess.setOnClickListener(this);
        mShowFailed = findViewById(R.id.show_failed);
        mShowFailed.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (mShowSuccess == v) {

            mGADownloadingView.releaseAnimation();
            mHandler.removeCallbacks(mRunnable);

            isSuccess = true;
            mProgress = 0;
            mGADownloadingView.performAnimation();
            mGADownloadingView.updateProgress(0);
            mHandler.postDelayed(mRunnable, 0);
        } else if (mShowFailed == v) {

            mGADownloadingView.releaseAnimation();
            mHandler.removeCallbacks(mRunnable);

            isSuccess = false;
            mProgress = 0;
            mGADownloadingView.performAnimation();
            mGADownloadingView.updateProgress(0);
            mHandler.postDelayed(mRunnable, 0);
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mHandler.removeCallbacks(mRunnable);

    }
}
