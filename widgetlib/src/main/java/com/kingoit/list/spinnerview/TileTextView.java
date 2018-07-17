package com.kingoit.list.spinnerview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Gravity;


import com.kingoit.widgetlib.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 两端对齐的TextView
 * Created by ssq on 2015/12/24.
 * 这控件写的不太好用，在字体大小方面不好控制  推荐使用TextViewWithWordRegular
 */
public class TileTextView extends android.support.v7.widget.AppCompatTextView {

    private Paint textPaint;
    private int mTextSize, margin;

    public TileTextView(Context context) {
        super(context);
        init(context, null);
    }

    public TileTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public TileTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        setGravity(Gravity.CENTER_VERTICAL);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CommonTitleTextView);
        if (typedArray != null) {
            mTextSize = typedArray.getDimensionPixelSize(R.styleable.CommonTitleTextView_tv_textSize, (int) (18 * displayMetrics.scaledDensity));//14sp
            typedArray.recycle();
        }
        margin = (int) (3 * displayMetrics.density);//3dp
        textPaint = new Paint();
        textPaint.setAntiAlias(true);
        textPaint.setTextSize(mTextSize);
        textPaint.setTextAlign(Paint.Align.LEFT);
        textPaint.setColor(0xFF585858);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        String text = getText().toString();
        if (TextUtils.isEmpty(text)) {
            return;
        }
        char[] textCharArray = text.toCharArray();
        // 已绘的宽度
        float drawedWidth = 0;
        float charWidth;
        float singleLineTextWidth = getWidth() - margin * 2;
        //每行字符截取
        List<char[]> charsList = new ArrayList<>();
        int j = 0;
        for (int i = 0; i < textCharArray.length; i++) {
            charWidth = textPaint.measureText(textCharArray, i, 1);
            if (textCharArray[i] == '\n') {
                char[] chars = new char[i - j];
                System.arraycopy(textCharArray, j, chars, 0, chars.length);
                charsList.add(chars);
                j = i + 1;
                drawedWidth = 0;
                continue;
            }
            if (singleLineTextWidth - drawedWidth < charWidth) {
                char[] chars = new char[i - j + 1];
                System.arraycopy(textCharArray, j, chars, 0, chars.length);
                charsList.add(chars);
                j = i + 1;
                drawedWidth = 0;
            }
            drawedWidth += charWidth;
            if (i == (textCharArray.length - 1) && j <= i) {
                char[] chars = new char[i - j + 1];
                System.arraycopy(textCharArray, j, chars, 0, chars.length);
                charsList.add(chars);
            }
        }
        for (int i = 0, len = charsList.size(); i < len; i++) {
            drawLineText(charsList.get(i), singleLineTextWidth, canvas, i + 1);
        }
    }

    private void drawLineText(char[] chars, float singleLineTextWidth, Canvas canvas, int lineCount) {
        float totalTextWidth = textPaint.measureText(chars, 0, chars.length);
        float paddingWidth = 0;
        if (chars.length > 1) {
            paddingWidth = (singleLineTextWidth - totalTextWidth) / (chars.length - 1);
        }
        float charWidth, drawedWidth = 0;
        for (int i = 0; i < chars.length; i++) {
            charWidth = textPaint.measureText(chars, i, 1);
            canvas.drawText(chars, i, 1, drawedWidth + margin, lineCount * mTextSize, textPaint);
            drawedWidth += (charWidth + paddingWidth);
        }
    }


    public void setmTextSize(int mTextSize) {
        this.mTextSize = mTextSize;
    }

}
