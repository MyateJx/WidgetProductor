package com.kingoit.tip.dialog;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;

import com.kingoit.widgetlib.R;

/**
 * @author xmj
 * @date 2018/7/18
 * <p>
 * 对话框。包括常用的选项、进度等。
 */
public class KingoitDialog {

    /**
     * 显示环形等待对话框
     *
     * @param context
     * @param title
     * @param message
     * @param iconRes
     * @param disableClickOutsideToClose
     * @param listener
     * @return
     */
    public static ProgressDialog showRoundProgressDialog(
            Context context, String title, String message, int iconRes, boolean disableClickOutsideToClose,
            final DialogInterface.OnCancelListener listener) {
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setTitle(TextUtils.isEmpty(title) ? context.getString(R.string.progress) : title);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setButton(DialogInterface.BUTTON_NEGATIVE, context.getString(R.string.cancel),
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        progressDialog.setCancelable(true);
        //禁止点击其他区域取消进度框
        progressDialog.setCanceledOnTouchOutside(!disableClickOutsideToClose);
        progressDialog.setOnCancelListener(listener);
        if (iconRes != 0) {
            progressDialog.setIcon(iconRes);
        }
        progressDialog.setMessage(message);
        progressDialog.show();
        return progressDialog;
    }

    /**
     * 显示横向进度对话框
     *
     * @param context
     * @param message  信息
     * @param listener 监听
     * @return
     */
    public static ProgressDialog showHorizontalProgressDialog(
            Context context, String message, final DialogInterface.OnCancelListener listener) {
        return showHorizontalProgressDialog(context, null, message, 0,
                100, true, listener);
    }

    /**
     * 显示横向进度对话框
     *
     * @param context
     * @param title                      标题
     * @param message                    信息
     * @param iconRes                    图标
     * @param maxValue                   最大值
     * @param disableClickOutsideToClose 是否禁用外部点击关闭对话框
     * @param listener                   监听
     * @return
     */
    public static ProgressDialog showHorizontalProgressDialog(
            Context context, String title, String message, int iconRes,
            int maxValue, boolean disableClickOutsideToClose,
            final DialogInterface.OnCancelListener listener) {
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setTitle(TextUtils.isEmpty(title) ? context.getString(R.string.progress) : title);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setButton(DialogInterface.BUTTON_NEGATIVE, context.getString(R.string.cancel),
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        progressDialog.setCancelable(true);
        //禁止点击其他区域取消进度框
        progressDialog.setCanceledOnTouchOutside(!disableClickOutsideToClose);
        progressDialog.setOnCancelListener(listener);
        progressDialog.setMax(maxValue);
        if (iconRes != 0) {
            progressDialog.setIcon(iconRes);
        }
        progressDialog.setProgress(0);
        progressDialog.setMessage(message);
        progressDialog.show();
        return progressDialog;
    }

    /**
     * 获得普通对话框
     *
     * @param context
     * @return
     */
    public static CommonDialog getCommonDialog(Context context) {
        return new CommonDialog(context, R.style.CommonDialogStyle);
    }

}
