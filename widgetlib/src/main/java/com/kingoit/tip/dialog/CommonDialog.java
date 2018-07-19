package com.kingoit.tip.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kingoit.widgetlib.R;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;


/**
 * Created by xmj on 2018/7/18.
 * <p>
 * 底部可动态添加按钮。
 */

public class CommonDialog extends Dialog {

    private String title;
    private String content;

    private LinkedHashMap<String, OnDialogClickListener> mListeners = new LinkedHashMap<>();

    public CommonDialog(Context context) {
        super(context);
    }

    public CommonDialog(Context context, int themeResId) {
        super(context, themeResId);
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_commom);
        initView();
    }

    private void initView() {
        TextView tvTitle = (TextView) findViewById(R.id.title);
        TextView tvContent = (TextView) findViewById(R.id.content);

        if (mListeners.size() > 0) {
            View lineView = findViewById(R.id.line_above_btn_container);
            lineView.setVisibility(View.VISIBLE);
            LinearLayout btnContainer = (LinearLayout) findViewById(R.id.btn_container);
            btnContainer.setVisibility(View.VISIBLE);

            Iterator iter = mListeners.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry entry = (Map.Entry) iter.next();
                String name = (String) entry.getKey();
                final OnDialogClickListener listener = (OnDialogClickListener) entry.getValue();
                TextView button = new TextView(getContext());
                button.setText(name);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) btnContainer.getLayoutParams();
                layoutParams.weight = 1;
                button.setLayoutParams(layoutParams);
                button.setBackgroundResource(R.drawable.com_dialog_background_detail_bg);
                button.setGravity(Gravity.CENTER);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        listener.onClick();
                        dismiss();
                    }
                });
                btnContainer.addView(button);
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