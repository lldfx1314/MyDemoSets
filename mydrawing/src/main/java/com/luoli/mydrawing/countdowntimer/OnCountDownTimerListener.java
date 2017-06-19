package com.luoli.mydrawing.countdowntimer;

/**
 * Created by LUOLI on 2017/6/19.
 */
public interface OnCountDownTimerListener {
    void onTick(long millisUntilFinished);

    void onFinish();
}
