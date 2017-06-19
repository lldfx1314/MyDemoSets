package com.luoli.mydrawing.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;

/**
 * Created by LUOLI on 2017/5/15.
 */
public class MyView1 extends View {
    private Path path ;
    private Paint paint;
    private int dx = 0;
    private int mItemWaveLength = 600;// 一个波长
    private ValueAnimator animator;

    public MyView1(Context context, AttributeSet attrs) {

        super(context, attrs);
        path = new Path();// 路径
        // 画笔
        paint = new Paint();
        paint.setColor(Color.GREEN);
//        paint.setAlpha((int) 0.5);
        paint.setStrokeWidth(20);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);//　填充并且描边
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        path.reset();
        // 绘制路径,假设Y方向是500
        int originY = 500;
        int halfWaveLen = mItemWaveLength/2;// 半个波长200
        // b把开始点设置在X轴负方向的一个波长处
        path.moveTo(-mItemWaveLength+dx,originY);
        // 利用贝塞尔曲线绘制其余的波长
        for (int i = -mItemWaveLength; i < getWidth() + mItemWaveLength; i+=mItemWaveLength) {
            path.rQuadTo(halfWaveLen/2,-100,halfWaveLen,0);
            path.rQuadTo(halfWaveLen/2,100,halfWaveLen,0);
        }
        path.lineTo(getWidth(),getHeight());
        path.lineTo(0,getHeight());
        path.close();

        canvas.drawPath(path,paint);
    }


    public void startAnim(){
        animator = ValueAnimator.ofInt(0,mItemWaveLength);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setDuration(800);
        animator.setInterpolator(new LinearInterpolator());
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                dx = (int) animation.getAnimatedValue();
                postInvalidate();
            }
        });
        animator.start();
    }

    /**重置*/
    public void reset(){
        path.reset();
        invalidate();
    }

    public void stopAnim() {
        if(animator!=null&&animator.isRunning()){
            animator.cancel();
            path.reset();
            invalidate();
        }
    }

    public boolean isRunning() {
        if(animator!=null){
            return animator.isRunning();
        }
        return false;
    }


    /** @Override
    public boolean onTouchEvent(MotionEvent event) {
    switch (event.getAction()){
    case MotionEvent.ACTION_DOWN:
    path.moveTo(event.getX(),event.getY());
    preX = event.getX();
    preY = event.getY();
    return true;
    case MotionEvent.ACTION_MOVE:
    // 获取结束点
    float endX = (preX+event.getX())/2;
    float endY = (preY+event.getY())/2;
    //                preX,preY是控制点   endX,endY是结束点
    path.quadTo(preX,preY,endX,endY );
    // 重新对开始的点赋值
    preX = event.getX();
    preY = event.getY();
    invalidate();
    break;
    }
    return super.onTouchEvent(event);
    }*/
}
