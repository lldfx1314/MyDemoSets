package com.luoli.mydrawing.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by LUOLI on 2017/5/18.
 */
public class MyDrawTextView extends View {
    public MyDrawTextView(Context context) {
        super(context);
    }

    public MyDrawTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyDrawTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        String text = "harvic\'s blog";
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setTextSize(150);
        paint.setStrokeCap(Paint.Cap.ROUND);
//        paint.setStrokeWidth(15);
        paint.setColor(Color.RED);
        // 定义一个基线原点
        int baseX = 50;
        int baseY = 200;
        // 画出基线
        canvas.drawLine(baseX, baseY, 1000, baseY, paint);
        // 竖直线
        canvas.drawLine(baseX, 0, baseX, 1000, paint);

        Paint.FontMetrics fm = paint.getFontMetrics();
        int top = baseY + (int) fm.top;
        int bottom = baseY + (int) fm.bottom;
        int ascent = baseY + (int) fm.ascent;
        int descent = baseY + (int) fm.descent;
        Log.d("luoli", "+top:" + fm.top);
        Log.d("luoli", "+ascent:" + fm.ascent);
        Log.d("luoli", "+descent:" + fm.descent);
        Log.d("luoli", "+bottom:" + fm.bottom);
        // 画top线
        paint.setColor(Color.BLUE);
        canvas.drawLine(baseX, top, 1000, top, paint);
        // 画ascent线
        paint.setColor(Color.GREEN);
        canvas.drawLine(baseX, ascent, 1000, ascent, paint);
        // 画descent线
        paint.setColor(Color.BLUE);
        canvas.drawLine(baseX, descent, 1000, descent, paint);
        // 画bottom线
        paint.setColor(Color.CYAN);
        canvas.drawLine(baseX, bottom, 1000, bottom, paint);


        //计算字符串的长度
        float width = paint.measureText(text);
        Log.d("luoli", "+width:" + width);
        // 计算字符串的高度
        int height = bottom - top;
        Log.d("luoli", "+height:" + height);
//        canvas.drawBitmap();
        // 画最大矩形
        Rect rect1 = new Rect(baseX,top, (int) (baseX+width),bottom);
        paint.setColor(Color.BLACK);
        canvas.drawRect(rect1,paint);
        // 画最小矩形

        // 计算最小矩形
        Rect rect = new Rect();
        paint.getTextBounds(text,0,text.length(),rect);
        rect.top = rect.top+baseY;
        rect.bottom = rect.bottom+baseY;
        rect.left = baseX;
        rect.right = (int) (baseX+width);
        paint.setColor(Color.RED);
        canvas.drawRect(rect,paint);
        Log.d("luoli", "+最小矩形:" + rect.toShortString());
        // 写一段文字
        paint.setColor(Color.GREEN);
        paint.setTextAlign(Paint.Align.LEFT);
        canvas.drawText(text, baseX, baseY, paint);
    }
}
