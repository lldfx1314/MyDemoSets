package com.luoli.mydrawing;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.TextView;

import com.luoli.mydrawing.view.evaluator.CharEvaluator;
import com.luoli.mydrawing.view.RedCircle;

/**
 * Created by LUOLI on 2017/6/1.
 */
public class AnimateActivity extends AppCompatActivity {
    private Button btnStart;
    private TextView textView;
    private RedCircle redCircle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animate);
        btnStart = (Button) findViewById(R.id.btn);
        textView = (TextView) findViewById(R.id.tv);
//        textView.setRotation();
        redCircle = (RedCircle)  findViewById(R.id.redCircle);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                doAnimation();
                doObjectAnimation();
//                redCircle.doAnimation();
            }
        });
        redCircle.setComplete(new RedCircle.Complete() {
            @Override
            public void execute() {
                doObjectAnimation();
            }
        });
    }

    private void doObjectAnimation() {

//        ObjectAnimator animator = ObjectAnimator.ofFloat(redCircle, "TranslationY", 0, 600, 100);
        ObjectAnimator animator = ObjectAnimator.ofInt(redCircle, "PointRadius", getR());
//        ObjectAnimator.ofPropertyValuesHolder();
//        ValueAnimator.ofPropertyValuesHolder()
//        textView.setRotation();
//        textView.setScaleY();
        animator.setDuration(2000);
//        animator.setInterpolator(new BounceInterpolator());

        animator.start();
    }

    private int[] getR() {
        int [] arr = new int[]{300,800,50,300,50,100,0,400};
        return arr;
    }

    private void doAnimation() {
        ValueAnimator animator = ValueAnimator.ofObject(new CharEvaluator(),new Character('A'),new Character('Z'));
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                char text = (char)animation.getAnimatedValue();
                textView.setText(String.valueOf(text));
            }
        });
        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        animator.setDuration(10000);
        animator.setInterpolator(new AccelerateInterpolator());
        animator.start();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }
}
