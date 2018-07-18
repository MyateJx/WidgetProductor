package com.kingoit.tip.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.kingoit.widgetlib.R;


/**
 * Created by xmj on 2018/7/18.
 */

public class CommonDialog extends Dialog implements View.OnClickListener {

    private TextView tvContent;
    private TextView tvTitle;
    private TextView tvSubmit;
    private TextView tvCancel;

    private Context mContext;
    private String title;
    private String content;
    private String positiveName;
    private String negativeName;
    private OnDialogClickListener listener;
    private View lineView;
    private boolean isToShowPositiveButton = false;
    private boolean isToShowNegitiveButton = false;

    public CommonDialog(Context context) {
        super(context);
        this.mContext = context;
    }

    public CommonDialog(Context context, int themeResId, String content) {
        this(context);
        this.content = content;
    }

    public CommonDialog(Context context, int themeResId, String content, OnDialogClickListener listener) {
        this(context, themeResId, content);
        this.listener = listener;
    }

    public CommonDialog setTitle(String title) {
        this.title = title;
        return this;
    }

    public CommonDialog setContent(String content) {
        this.content = content;
        return this;
    }

    public CommonDialog setPositiveButton(String name) {
        this.positiveName = name;
        if (!TextUtils.isEmpty(positiveName)) {
            isToShowPositiveButton = true;
        }
        return this;
    }

    public CommonDialog setNegativeButton(String name) {
        this.negativeName = name;
        if (!TextUtils.isEmpty(negativeName)) {
            isToShowNegitiveButton = true;
        }
        return this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_commom);
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        initView();
    }

    private void initView() {
        tvTitle = (TextView) findViewById(R.id.title);
        tvContent = (TextView) findViewById(R.id.content);
        tvSubmit = (TextView) findViewById(R.id.submit);
        tvSubmit.setOnClickListener(this);
        tvCancel = (TextView) findViewById(R.id.cancel);
        tvCancel.setOnClickListener(this);
        lineView = findViewById(R.id.view_line);

        if (!TextUtils.isEmpty(title)) {
            tvTitle.setText(title);
        }

        if (!TextUtils.isEmpty(content)) {
            tvContent.setText(content);
        }

        if (!TextUtils.isEmpty(positiveName)) {
            tvSubmit.setText(positiveName);
        }

        if (!TextUtils.isEmpty(negativeName)) {
            tvCancel.setText(negativeName);
        }

        tvSubmit.setVisibility(isToShowPositiveButton ? View.VISIBLE : View.GONE);
        tvCancel.setVisibility(isToShowNegitiveButton ? View.VISIBLE : View.GONE);
        lineView.setVisibility(isToShowPositiveButton && isToShowNegitiveButton ? View.VISIBLE : View.GONE);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.cancel) {
            this.dismiss();
            if (listener != null) {
                listener.onClick(false);
            }
        }
        if (id == R.id.submit) {
            this.dismiss();
            if (listener != null) {
                listener.onClick(true);
            }
        }

    }

    public interface OnDialogClickListener {
        void onClick(boolean confirm);
    }
}