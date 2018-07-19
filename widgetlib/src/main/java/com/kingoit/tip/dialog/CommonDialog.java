package com.kingoit.tip.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kingoit.widgetlib.R;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;


/**
 * Created by xmj on 2018/7/18.
 */

public class CommonDialog extends Dialog {

    private TextView tvContent;
    private TextView tvTitle;
    private LinearLayout mBtnContainer;
//    private TextView tvSubmit;
//    private TextView tvCancel;

    private Context mContext;
    private String title;
    private String content;
    //    private String positiveName;
//    private String negativeName;
    private OnDialogClickListener listener;
    private View lineView;
    private boolean isToShowPositiveButton = false;
    private boolean isToShowNegitiveButton = false;
    private LinkedHashMap<String, OnDialogClickListener> mListeners = new LinkedHashMap<>();

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

    public CommonDialog addButton(String name, OnDialogClickListener listener) {
        if (mListeners.get(name) == null) {
            mListeners.put(name, listener);
        }
        return this;
    }

    /*public CommonDialog setPositiveButton(String name) {
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
    }*/

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

        if (mListeners.size() > 0) {
            lineView = findViewById(R.id.line_above_btn_container);
            lineView.setVisibility(View.VISIBLE);
            mBtnContainer = (LinearLayout) findViewById(R.id.btn_container);
            mBtnContainer.setVisibility(View.VISIBLE);

            Iterator iter = mListeners.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry entry = (Map.Entry) iter.next();
                String name = (String) entry.getKey();
                final OnDialogClickListener listener = (OnDialogClickListener) entry.getValue();
                Button button = new Button(getContext());
                button.setTextAppearance(getContext(), R.style.CommonDialogButtonStyle);
                button.setText(name);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        listener.onClick();
                        dismiss();
                    }
                });
                mBtnContainer.addView(button);
            }
        }

        if (!TextUtils.isEmpty(title)) {
            tvTitle.setText(title);
        }

        if (!TextUtils.isEmpty(content)) {
            tvContent.setText(content);
        }
    }

    public interface OnDialogClickListener {
        void onClick();
    }
}