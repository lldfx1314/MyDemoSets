package com.luoli.mydrawing.view.evaluator;

import android.animation.TypeEvaluator;

/**
 * Created by LUOLI on 2017/6/1.
 */
public class CharEvaluator implements TypeEvaluator<Character> {
    @Override
    public Character evaluate(float fraction, Character startValue, Character endValue) {
        int startInt = startValue;
        int endInt = endValue;
        int current = (int) (startInt+fraction*(endInt-startInt));
        char cur = (char) current;
        return cur;
    }
}
