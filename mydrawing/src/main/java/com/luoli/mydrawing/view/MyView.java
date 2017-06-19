package com.luoli.mydrawing.view;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.ScaleAnimation;

/**
 * Created by LUOLI on 2017/5/15.
 */
public class MyView extends View {
    private Path path = new Path();
    private float preX;
    private float preY;

    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
//        ValueAnimator.ofArgb()
//        TranslateAnimation
//        AlphaAnimation
//        ScaleAnimation
//        RotateAnimation
//        AnimationSet
//        new ScaleAnimation()

//        ObjectAnimator.ofInt();
//        ValueAnimator.ofObject()
    }

    @Override
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
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 画笔
        Paint paint = new Paint();
        paint.setColor(Color.RED);
//        paint.setTextSize(20);
        paint.setStrokeWidth(20);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawPath(path,paint);


//        canvas.drawLine();
        Canvas canvas1 = new Canvas();
        Bitmap bitmap = Bitmap.createBitmap(50,50, Bitmap.Config.ARGB_8888);
        canvas1.setBitmap(bitmap);
    }
    /**重置*/
    public void reset(){
        path.reset();
        invalidate();
    }
}
