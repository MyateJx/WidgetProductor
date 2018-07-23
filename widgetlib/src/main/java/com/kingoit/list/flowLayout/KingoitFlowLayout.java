package com.kingoit.list.flowLayout;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.kingoit.widgetlib.R;

import java.util.ArrayList;
import java.util.List;

/**
 * kingoit,流式布局
 *
 * @author zuo
 * @date 2018/7/16 11:48
 */
public class KingoitFlowLayout extends ViewGroup {
    //记录每个View的位置
    private List<ChildPos> mChildPos = new ArrayList<ChildPos>();
    private float textSize;
    private int textColor;
    private float shapeRadius;
    private int shapeLineColor;
    private int shapeBackgroundColor;
    private float shapeLineWidth;
    private int deleteBtnColor;
    /**
     * 是否是可删除模式
     */
    private boolean isDeleteMode;

    private class ChildPos {
        int left, top, right, bottom;

        public ChildPos(int left, int top, int right, int bottom) {
            this.left = left;
            this.top = top;
            this.right = right;
            this.bottom = bottom;
        }
    }

    public KingoitFlowLayout(Context context) {
        this(context, null);
    }

    public KingoitFlowLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        initAttributes(context, attrs);
    }

    /**
     * 最终调用这个构造方法
     *
     * @param context  上下文
     * @param attrs    xml属性集合
     * @param defStyle Theme中定义的style
     */
    public KingoitFlowLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    /**
     * 流式布局属性设置
     * @param context
     * @param attrs
     */
    @SuppressLint("ResourceAsColor")
    private void initAttributes(Context context, AttributeSet attrs) {
        @SuppressLint("Recycle")
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.KingoitFlowLayout);
        textSize = typedArray.getDimension(R.styleable.KingoitFlowLayout_flowLayoutTextSize, 16f);
        textColor = typedArray.getColor(R.styleable.KingoitFlowLayout_flowLayoutTextColor, Color.parseColor("#FF4081"));
        shapeRadius = typedArray.getDimension(R.styleable.KingoitFlowLayout_flowLayoutRadius, 40f);
        shapeLineColor = typedArray.getColor(R.styleable.KingoitFlowLayout_flowLayoutLineColor,Color.parseColor("#ADADAD"));
        shapeBackgroundColor = typedArray.getColor(R.styleable.KingoitFlowLayout_flowLayoutBackgroundColor,Color.parseColor("#c5cae9"));
        shapeLineWidth = typedArray.getDimension(R.styleable.KingoitFlowLayout_flowLayoutLineWidth, 4f);
        deleteBtnColor = typedArray.getColor(R.styleable.KingoitFlowLayout_flowLayoutDeleteBtnColor, Color.GRAY);
    }

    /**
     * 测量宽度和高度
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //获取流式布局的宽度和模式
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        //获取流式布局的高度和模式
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);

        //使用wrap_content的流式布局的最终宽度和高度
        int width = 0, height = 0;
        //记录每一行的宽度和高度
        int lineWidth = 0, lineHeight = 0;
        //得到内部元素的个数
        int count = getChildCount();
        mChildPos.clear();
        for (int i = 0; i < count; i++) {
            //获取对应索引的view
            View child = getChildAt(i);
            //测量子view的宽和高
            measureChild(child, widthMeasureSpec, heightMeasureSpec);
            MarginLayoutParams lp = (MarginLayoutParams) child.getLayoutParams();
            //子view占据的宽度
            int childWidth = child.getMeasuredWidth() + lp.leftMargin + lp.rightMargin;
            //子view占据的高度
            int childHeight = child.getMeasuredHeight() + lp.topMargin + lp.bottomMargin;
            //换行
            if (lineWidth + childWidth > widthSize - getPaddingLeft() - getPaddingRight()) {
                //取最大的行宽为流式布局宽度
                width = Math.max(width, lineWidth);
                //叠加行高得到流式布局高度
                height += lineHeight;
                //重置行宽度为第一个View的宽度
                lineWidth = childWidth;
                //重置行高度为第一个View的高度
                lineHeight = childHeight;
                //记录位置
                mChildPos.add(new ChildPos(
                        getPaddingLeft() + lp.leftMargin,
                        getPaddingTop() + height + lp.topMargin,
                        getPaddingLeft() + childWidth - lp.rightMargin,
                        getPaddingTop() + height + childHeight - lp.bottomMargin));
            } else {  //不换行
                //记录位置
                mChildPos.add(new ChildPos(
                        getPaddingLeft() + lineWidth + lp.leftMargin,
                        getPaddingTop() + height + lp.topMargin,
                        getPaddingLeft() + lineWidth + childWidth - lp.rightMargin,
                        getPaddingTop() + height + childHeight - lp.bottomMargin));
                //叠加子View宽度得到新行宽度
                lineWidth += childWidth;
                //取当前行子View最大高度作为行高度
                lineHeight = Math.max(lineHeight, childHeight);
            }
            //最后一个控件
            if (i == count - 1) {
                width = Math.max(lineWidth, width);
                height += lineHeight;
            }
        }

        //如果使用AT_MOST（wrap_content）则使用width，height作为宽高
        //否则使用widthSize, heightSize作为宽高
        setMeasuredDimension(
                widthMode == MeasureSpec.AT_MOST ? width + getPaddingLeft() + getPaddingRight() : widthSize,
                heightMode == MeasureSpec.AT_MOST ? height + getPaddingTop() + getPaddingBottom() : heightSize);
    }

    /**
     * 让ViewGroup能够支持margin属性
     */
    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new MarginLayoutParams(getContext(), attrs);
    }

    /**
     * 设置每个View的位置
     */
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int count = getChildCount();
        for (int i = 0; i < count; i++) {
            View child = getChildAt(i);
            ChildPos pos = mChildPos.get(i);
            //设置View的左边、上边、右边底边位置
            child.layout(pos.left, pos.top, pos.right, pos.bottom);
        }
    }

    public void addItemView(LayoutInflater inflater, String tvName) {
        //加载 ItemView并设置名称，并设置名称
        View view = inflater.inflate(R.layout.kingoit_flow_layout, this, false);
        ImageView delete = view.findViewById(R.id.delete);
        if (isDeleteMode){
            delete.setVisibility(VISIBLE);
        }else {
            delete.setVisibility(GONE);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            delete.setImageTintList(ColorStateList.valueOf(deleteBtnColor));
        }
        TextView textView = view.findViewById(R.id.value);
        textView.setTextSize(textSize);
        textView.setTextColor(textColor);
        textView.setPadding(20,4,20,4);
        textView.setText(tvName);
        //动态设置shape
        GradientDrawable drawable = new GradientDrawable();
        drawable.setCornerRadius(shapeRadius);
        drawable.setStroke((int)shapeLineWidth, shapeLineColor);
        drawable.setColor(shapeBackgroundColor);
        textView.setBackgroundDrawable(drawable);

        //把 ItemView加入流式布局
        this.addView(view);
    }


    public boolean isDeleteMode() {
        return isDeleteMode;
    }

    public void setDeleteMode(boolean deleteMode) {
        isDeleteMode = deleteMode;
    }

    /**
     * 流式布局显示
     * Toast.makeText(FlowLayoutActivity.this, keywords, Toast.LENGTH_SHORT).show();
     * @param list
     */
    public void showTag(final List<String> list, final ItemClickListener listener) {
        removeAllViews();
        for (int i = 0; i < list.size(); i++) {
            final String keywords = list.get(i);
            addItemView(LayoutInflater.from(getContext()), keywords);
            getChildAt(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isDeleteMode()){
                        list.remove(keywords);
                        showTag(list,listener);
                    }else {
                        listener.onClick(keywords);
                    }
                }
            });
        }
    }

    public interface ItemClickListener{
        /**
         * item 点击事件
         * @param keywords
         */
        void onClick(String keywords);
    }
}
