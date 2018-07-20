package com.kingoit.navigation;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.kingoit.widgetlib.R;

/**
 * 常用头部导航控件
 *
 * @author zuo
 * @date 2018/7/19 16:56
 */
public class KingoitHeadView extends FrameLayout {
    /**
     * 头部控件，以此为：左侧ImageView、左侧TextView、标题TextView、标题容器FrameLayout、右侧TextView、右侧ImageView
     */
    private ImageView headLeftImg;
    private TextView headLeftTv;
    private TextView headTitleTv;
    private FrameLayout headContainer;
    private TextView headRightTv;
    private ImageView headRightImg;

    public KingoitHeadView(@NonNull Context context) {
        super(context);
    }

    public KingoitHeadView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        View view = View.inflate(context, R.layout.kingoit_head_view, this);
        headLeftImg = view.findViewById(R.id.kingo_head_left_img);
        headLeftTv = view.findViewById(R.id.kingo_head_left_tv);
        headTitleTv = view.findViewById(R.id.kingo_head_title_tv);
        headContainer = view.findViewById(R.id.kingo_head_container);
        headRightTv = view.findViewById(R.id.kingo_head_right_tv);
        headRightImg = view.findViewById(R.id.kingo_head_right_img);
        initAttributes(context, attrs);
    }

    /**
     * 初始化，KingoitHeadView 的自定义属性 ，并和相关控件关联上
     */
    private void initAttributes(@NonNull Context context, @Nullable AttributeSet attrs) {
        @SuppressLint("Recycle")
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.KingoitHeadView);
        headLeftImg.setImageResource(typedArray.getResourceId(R.styleable.KingoitHeadView_headLeftImgSrc, R.drawable.arrow_left));
        headLeftImg.setVisibility(typedArray.getBoolean(R.styleable.KingoitHeadView_headLeftImgVisible, true) ? View.VISIBLE : View.GONE);
        headLeftTv.setText(typedArray.getString(R.styleable.KingoitHeadView_headLeftText));
        headLeftTv.setTextColor(typedArray.getColor(R.styleable.KingoitHeadView_headLeftTextColor, Color.BLACK));
        headLeftTv.setBackgroundResource(typedArray.getResourceId(R.styleable.KingoitHeadView_headLeftTextBackground, R.color.colorWhite));
        headTitleTv.setText(typedArray.getString(R.styleable.KingoitHeadView_headTitleText));
        headTitleTv.setTextColor(typedArray.getColor(R.styleable.KingoitHeadView_headTitleTextColor, Color.BLACK));
        headTitleTv.setBackgroundResource(typedArray.getResourceId(R.styleable.KingoitHeadView_headTitleTextBackground, R.color.colorWhite));
        headTitleTv.setVisibility(typedArray.getBoolean(R.styleable.KingoitHeadView_headTitleTextVisible, true) ? View.VISIBLE : View.GONE);
        headRightTv.setText(typedArray.getString(R.styleable.KingoitHeadView_headRightText));
        headRightTv.setTextColor(typedArray.getColor(R.styleable.KingoitHeadView_headRightTextColor, Color.BLACK));
        headRightTv.setBackgroundResource(typedArray.getResourceId(R.styleable.KingoitHeadView_headRightTextBackground, R.color.colorWhite));
        headRightImg.setImageResource(typedArray.getResourceId(R.styleable.KingoitHeadView_headRightImgSrc, R.drawable.delete));
        headRightImg.setVisibility(typedArray.getBoolean(R.styleable.KingoitHeadView_headRightImgVisible, true) ? View.VISIBLE : View.GONE);
    }

    //获取布局的相关控件，便于在代码中动态设置相关属性

    public ImageView getHeadLeftImg() {
        return headLeftImg;
    }

    public TextView getHeadLeftTv() {
        return headLeftTv;
    }

    public TextView getHeadTitleTv() {
        return headTitleTv;
    }

    public FrameLayout getHeadContainer() {
        return headContainer;
    }

    public TextView getHeadRightTv() {
        return headRightTv;
    }

    public ImageView getHeadRightImg() {
        return headRightImg;
    }
}
