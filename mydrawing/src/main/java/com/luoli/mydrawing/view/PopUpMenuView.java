package com.luoli.mydrawing.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.luoli.mydrawing.R;


/**
 * Created by LUOLI on 2017/6/5.
 */
public class PopUpMenuView extends RelativeLayout implements View.OnClickListener {
    private final Context context;
    private Button mMenuButton;
    private Button mItemButton1;
    private Button mItemButton2;
    private Button mItemButton3;
    private Button mItemButton4;
    private Button mItemButton5;
    private boolean mIsMenuOpen = false;
    private View inflate;

    public PopUpMenuView(Context context) {
        this(context, null);
    }

    public PopUpMenuView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PopUpMenuView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        initView();
    }

    private void initView() {
        inflate = View.inflate(context, R.layout.activity_popup, this);
        mMenuButton = (Button) inflate.findViewById(R.id.menu);
        mMenuButton.setOnClickListener(this);

        mItemButton1 = (Button) inflate.findViewById(R.id.item1);
        mItemButton1.setOnClickListener(this);

        mItemButton2 = (Button) inflate.findViewById(R.id.item2);
        mItemButton2.setOnClickListener(this);

        mItemButton3 = (Button) inflate.findViewById(R.id.item3);
        mItemButton3.setOnClickListener(this);

        mItemButton4 = (Button) inflate.findViewById(R.id.item4);
        mItemButton4.setOnClickListener(this);

        mItemButton5 = (Button) inflate.findViewById(R.id.item5);
        mItemButton5.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == mMenuButton) {
            if (!mIsMenuOpen) {
                mIsMenuOpen = true;
                doAnimateOpen1(mItemButton1, 1, 5, 800);
                doAnimateOpen1(mItemButton2, 2, 5, 800);
                doAnimateOpen1(mItemButton3, 3, 5, 800);
                doAnimateOpen1(mItemButton4, 4, 5, 800);
                doAnimateOpen1(mItemButton5, 5, 5, 800);
//                doAnimateOpen(mItemButton1, 0, 5, 500);
//                doAnimateOpen(mItemButton2, 1, 5, 500);
//                doAnimateOpen(mItemButton3, 2, 5, 500);
//                doAnimateOpen(mItemButton4, 3, 5, 500);
//                doAnimateOpen(mItemButton5, 4, 5, 500);
            } else {
                mIsMenuOpen = false;
                doAnimateClose1(mItemButton1, 1, 5, 800);
                doAnimateClose1(mItemButton2, 2, 5, 800);
                doAnimateClose1(mItemButton3, 3, 5, 800);
                doAnimateClose1(mItemButton4, 4, 5, 800);
                doAnimateClose1(mItemButton5, 5, 5, 800);


//                doAnimateClose(mItemButton1, 0, 5, 500);
//                doAnimateClose(mItemButton2, 1, 5, 500);
//                doAnimateClose(mItemButton3, 2, 5, 500);
//                doAnimateClose(mItemButton4, 3, 5, 500);
//                doAnimateClose(mItemButton5, 4, 5, 500);
            }
        } else {
            Toast.makeText(context, "你点击了" + v.getId(), Toast.LENGTH_SHORT).show();
        }
    }

    private void doAnimateOpen1(View view, int index, int total, int length) {
        if (view.getVisibility() != View.VISIBLE) {
            view.setVisibility(View.VISIBLE);
        }
//        double degree = Math.toRadians(90) / (total - 1) * index;
//        int translationX = -(int) (radius * Math.sin(degree));
//        int translationY = -(int) (radius * Math.cos(degree));
        int translationY = -length * index / total;
        AnimatorSet set = new AnimatorSet();

        set.playTogether(
//                ObjectAnimator.ofFloat(view, "translationX", 0, translationX),
                ObjectAnimator.ofFloat(view, "translationY", 0, translationY),
                ObjectAnimator.ofFloat(view, "scaleX", 0f, 1f),
                ObjectAnimator.ofFloat(view, "scaleY", 0f, 1f),
                ObjectAnimator.ofFloat(view, "alpha", 0f, 1));
        set.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                RelativeLayout.LayoutParams params = (LayoutParams) inflate.getLayoutParams();
                params.width = LayoutParams.MATCH_PARENT;
                params.height = LayoutParams.MATCH_PARENT;
                inflate.setLayoutParams(params);
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
        //动画周期为500ms
        set.setDuration(1 * 100).start();
    }

    private void doAnimateClose1(final View view, int index, int total,
                                 int length) {
        if (view.getVisibility() != View.VISIBLE) {
            view.setVisibility(View.VISIBLE);
        }
//        double degree = Math.PI * index / ((total - 1) * 2);
//        int translationX = -(int) (radius * Math.sin(degree));
//        int translationY = -(int) (radius * Math.cos(degree));
        int translationY = -length * index / total;
        AnimatorSet set = new AnimatorSet();
        //包含平移、缩放和透明度动画
        set.playTogether(
//                ObjectAnimator.ofFloat(view, "translationX", translationX, 0),
                ObjectAnimator.ofFloat(view, "translationY", translationY, 0),
                ObjectAnimator.ofFloat(view, "scaleX", 1f, 0.1f),
                ObjectAnimator.ofFloat(view, "scaleY", 1f, 0.1f),
                ObjectAnimator.ofFloat(view, "alpha", 1f, 0.1f));
        set.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                view.setVisibility(View.GONE);
                RelativeLayout.LayoutParams params = (LayoutParams) inflate.getLayoutParams();
                params.width = LayoutParams.WRAP_CONTENT;
                params.height = LayoutParams.WRAP_CONTENT;
                inflate.setLayoutParams(params);
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                view.setVisibility(View.GONE);
                RelativeLayout.LayoutParams params = (LayoutParams) inflate.getLayoutParams();
                params.width = LayoutParams.WRAP_CONTENT;
                params.height = LayoutParams.WRAP_CONTENT;
                inflate.setLayoutParams(params);
            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        set.setDuration(1 * 100).start();
    }


    private void doAnimateOpen(View view, int index, int total, int radius) {
        if (view.getVisibility() != View.VISIBLE) {
            view.setVisibility(View.VISIBLE);
        }
        double degree = Math.toRadians(90) / (total - 1) * index;
        int translationX = -(int) (radius * Math.sin(degree));
        int translationY = -(int) (radius * Math.cos(degree));

        AnimatorSet set = new AnimatorSet();
        //包含平移、缩放和透明度动画
//        set.playSequentially(
//                ObjectAnimator.ofFloat(view, "alpha", 0f, 1),
//                ObjectAnimator.ofFloat(view, "scaleX", 0f, 1f),
//                ObjectAnimator.ofFloat(view, "scaleY", 0f, 1f),
//                ObjectAnimator.ofFloat(view, "translationY", 0, translationY),
//                ObjectAnimator.ofFloat(view, "translationX", 0, translationX)
//        );
        set.playTogether(
                ObjectAnimator.ofFloat(view, "translationX", 0, translationX),
                ObjectAnimator.ofFloat(view, "translationY", 0, translationY),
                ObjectAnimator.ofFloat(view, "scaleX", 0f, 1f),
                ObjectAnimator.ofFloat(view, "scaleY", 0f, 1f),
                ObjectAnimator.ofFloat(view, "alpha", 0f, 1));
        //动画周期为500ms
        set.setDuration(1 * 100).start();
    }

    private void doAnimateClose(final View view, int index, int total,
                                int radius) {
        if (view.getVisibility() != View.VISIBLE) {
            view.setVisibility(View.VISIBLE);
        }
        double degree = Math.PI * index / ((total - 1) * 2);
        int translationX = -(int) (radius * Math.sin(degree));
        int translationY = -(int) (radius * Math.cos(degree));
        AnimatorSet set = new AnimatorSet();
        //包含平移、缩放和透明度动画
        set.playTogether(
                ObjectAnimator.ofFloat(view, "translationX", translationX, 0),
                ObjectAnimator.ofFloat(view, "translationY", translationY, 0),
                ObjectAnimator.ofFloat(view, "scaleX", 1f, 0.1f),
                ObjectAnimator.ofFloat(view, "scaleY", 1f, 0.1f),
                ObjectAnimator.ofFloat(view, "alpha", 1f, 0.1f));
        set.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                view.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        set.setDuration(1 * 100).start();
    }
}
