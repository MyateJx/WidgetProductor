package com.kingoit.tip.dialog;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;

import com.kingoit.widgetlib.R;


/**
 * Created by admin on 2018/2/5.
 */

public class ProgressDialogManager {

    public static ProgressDialog showProgressDialog(Context context, String message) {
        ProgressDialog progressDialog =
                ProgressDialog.show(context, context.getString(R.string.tip), message, false, false);
        progressDialog.setCanceledOnTouchOutside(false);
        return progressDialog;
    }

    /**
     * 显示进度框
     *
     * @param context  上下文
     * @param message  消息
     * @param listener 取消事件的监听
     * @param maxValue 进度最大值
     * @return
     */
    public static ProgressDialog showHorizontalProgressDialog(Context context, String message,
                                                              final DialogInterface.OnCancelListener listener,
                                                              int maxValue) {
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setTitle(context.getString(R.string.tip));
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setButton(DialogInterface.BUTTON_NEGATIVE,
                context.getString(R.string.cancel), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        progressDialog.setCancelable(true);
        progressDialog.setCanceledOnTouchOutside(false);    //禁止点击其他区域取消进度框
        progressDialog.setOnCancelListener(listener);
        progressDialog.setMax(maxValue);
        progressDialog.setProgress(0);
        progressDialog.setMessage(message);
        progressDialog.show();
        return progressDialog;
    }
}
