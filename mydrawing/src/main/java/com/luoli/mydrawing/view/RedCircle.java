package com.luoli.mydrawing.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.BounceInterpolator;

import com.luoli.mydrawing.view.evaluator.CircleEvaluator;

/**
 * Created by LUOLI on 2017/6/1.
 */
public class RedCircle extends View {
    //　定义一个半径
    private Point mPoint = new Point(300);
    private final Paint paint;

    public RedCircle(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mPoint != null) {
            canvas.drawCircle(400, 400, mPoint.getRadius(), paint);
        }
    }
    private int i = 0;
    public void setPointRadius(int radius){
        mPoint.setRadius(radius);
        Log.d("luoli","哈哈+"+i++);
        invalidate();
    }

    /**执行动画*/
    public void doAnimation(){

//        ObjectAnimator.ofInt()
        ValueAnimator animator = ValueAnimator.ofObject(new CircleEvaluator(), new Point(20), new Point(200));
        animator.setDuration(1000);
        animator.setRepeatCount(1);
        animator.setInterpolator(new BounceInterpolator());
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mPoint = (Point) animation.getAnimatedValue();
                invalidate();
            }
        });
        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
//                if(complete!=null){
//                    complete.execute();
//                }
                Log.d("luoli","Start******************");
            }

            @Override
            public void onAnimationEnd(Animator animation) {
//                if(complete!=null){
//                    complete.execute();
//                }
                Log.d("luoli","End******************");

            }

            @Override
            public void onAnimationCancel(Animator animation) {
                Log.d("luoli","Cancel******************");

            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                Log.d("luoli","Repeat******************");
                if(complete!=null){
                    complete.execute();
                }
            }
        });
        animator.start();
    }

    public void setComplete(Complete complete) {
        this.complete = complete;
    }

    private Complete complete;
    public interface Complete{
        void execute();
    }
}
