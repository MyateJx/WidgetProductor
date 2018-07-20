package com.kingoit.widgetproductor.tip;

import android.app.FragmentManager;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.kingoit.tip.dialog.CommonDialog;
import com.kingoit.tip.dialog.KingoitDialog;
import com.kingoit.widgetproductor.R;
import com.kingoit.widgetproductor.databinding.ActivityDialogBinding;

/**
 * @author xmj
 * @date 2018/7/16
 */
public class DialogActivity extends AppCompatActivity {

    private ActivityDialogBinding mBinding;
    private static final int PROGRESS_UPDATE = 0;
    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_dialog);
        mBinding.setClickProxy(new ClickProxy());
    }

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case PROGRESS_UPDATE:
                    int progress = (Integer) msg.obj;
                    if (progress < 200) {
                        mProgressDialog.setProgress(progress);
                    } else {
                        mProgressDialog.dismiss();
                    }
                    break;
                default:
            }
        }
    };

    public class ClickProxy {
        public void toSimpleDialog() {

        }

        public void toCommonDialog() {
            KingoitDialog.getCommonDialog(DialogActivity.this)
                    .setTitle("我是对话框标题")
                    .setContent("回房间看速度快粉红色的肯恢复")
                    .addButton("按钮1", new CommonDialog.OnDialogClickListener() {
                        @Override
                        public void onClick() {
                            Toast.makeText(DialogActivity.this, "按钮1", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .addButton("按钮2", new CommonDialog.OnDialogClickListener() {
                        @Override
                        public void onClick() {
                            Toast.makeText(DialogActivity.this, "按钮2", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .addButton("按钮3", new CommonDialog.OnDialogClickListener() {
                        @Override
                        public void onClick() {
                            Toast.makeText(DialogActivity.this, "按钮3", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .show();
        }

        public void toSimpleCommonDialog() {
            KingoitDialog.getCommonDialog(DialogActivity.this).setTitle("我是对话框标题").show();
        }

        public void toProgressDialog() {
            mProgressDialog = KingoitDialog.showHorizontalProgressDialog(
                    DialogActivity.this, "标题啊", "消息啊", 0,
                    200, true, new DialogInterface.OnCancelListener() {
                        @Override
                        public void onCancel(DialogInterface dialog) {
                            Toast.makeText(DialogActivity.this, "hahah", Toast.LENGTH_SHORT).show();
                        }
                    });
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 200; i++) {
                        if (!mProgressDialog.isShowing()) {
                            break;
                        }
                        try {
                            Thread.sleep(20);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        Message message = new Message();
                        message.what = PROGRESS_UPDATE;
                        message.obj = i;
                        mHandler.sendMessage(message);
                    }
                }
            }).start();


        }

        public void toShowBottom() {

        }
    }
}
