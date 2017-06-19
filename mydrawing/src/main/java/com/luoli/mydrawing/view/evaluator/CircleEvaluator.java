package com.luoli.mydrawing.view.evaluator;

import android.animation.TypeEvaluator;

import com.luoli.mydrawing.view.Point;

/**
 * Created by LUOLI on 2017/6/1.
 */
public class CircleEvaluator implements TypeEvaluator<Point>{
    @Override
    public Point evaluate(float fraction, Point startValue, Point endValue) {
        int start = startValue.getRadius();
        int end = endValue.getRadius();
        int current = (int) (start + fraction*(end-start));
        return new Point(current);
    }
}
