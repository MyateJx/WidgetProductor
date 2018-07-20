package com.kingoit.list.spinner;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.kingoit.widgetlib.R;

import java.util.List;

/**
 * ArrayList<String> ,其中的string可以换成一个通用的实体，比如一个（int）id ,一个(string) value
 * author: zuo
 * date: 2017/11/29 15:05
 */

public class SpinnerUtils {
    private Context mContext;
    private TextView mTextView;
    private ItemClickListener itemClickListener;
    private List<String> mData;
    private RecyclerView.Adapter<RecyclerView.ViewHolder> mAdapter;
    private PopupWindow popupWindow;

    public SpinnerUtils(Context context, TextView textView, List<String> data, ItemClickListener listener) {
        this.mContext = context;
        this.mTextView = textView;
        this.mData = data;
        this.itemClickListener = listener;
        initView();
    }
/*
    public SpinnerUtils(Context context, TextView textView, List<String> data, ItemClickListener listener, RecyclerView.Adapter<RecyclerView.ViewHolder> adapter) {
        this.mContext = context;
        this.mTextView = textView;
        this.mData = data;
        this.itemClickListener = listener;
        initView();
    }*/

    private void initView() {
        if (mData != null && mData.size() > 0) {
            mTextView.setText(mData.get(0));
            tvSetImg(mTextView, R.drawable.arrow_down);
        }
        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupWindow();
            }
        });
    }


    public interface ItemClickListener {
        void onItemClick(View view);
    }

    private void showPopupWindow() {
        tvSetImg(mTextView, R.drawable.arrow_top);
        View view = LayoutInflater.from(mContext).inflate(R.layout.choose_pop_rv, null);
        popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        popupWindow.setTouchable(true);
        popupWindow.setBackgroundDrawable(mContext.getResources().getDrawable(R.drawable.shape_popup_view));
        popupWindow.showAsDropDown(mTextView);
        popupWindow.setOnDismissListener(new PopupDismissListener());
        RecyclerView recyclerView = view.findViewById(R.id.rv_choose_pop);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mAdapter = new SpinnerChooseAdapter(mContext, new SpinnerChooseAdapter.MyItemClickListener() {
            @Override
            public void onItemClick(View view) {
                int tag = (int) view.getTag();
                mTextView.setText(mData.get(tag));
                if (popupWindow != null) {
                    popupWindow.dismiss();
                }
                if (itemClickListener != null) {
                    itemClickListener.onItemClick(view);
                }
            }
        }, mData);
        recyclerView.setAdapter(mAdapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(mContext, DividerItemDecoration.VERTICAL));
    }

    /**
     * 弹窗消失的时候让箭头换回来
     */
    class PopupDismissListener implements PopupWindow.OnDismissListener {
        @Override
        public void onDismiss() {
            tvSetImg(mTextView, R.drawable.arrow_down);
        }

    }

    /**
     * 设置textView右侧的图像
     *
     * @param textView
     * @param img
     */
    private void tvSetImg(TextView textView, int img) {
        Drawable nav_up = mContext.getResources().getDrawable(img);
        nav_up.setBounds(0, 0, nav_up.getMinimumWidth(), nav_up.getMinimumHeight());
        textView.setCompoundDrawables(null, null, nav_up, null);
    }

    /**
     * 基础数据类型，其他要传如的必须是它的子类
     */
    public class BaseSpinnerData {
        private int key;
        private String value;

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
