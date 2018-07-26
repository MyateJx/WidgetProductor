package com.kingoit.widgetproductor.tip;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.widget.Toast;

import com.kingoit.widgetproductor.R;
import com.kingoit.widgetproductor.databinding.ActivityToastBinding;

/**
 * @author xmj
 * @date 2018/7/16
 */
public class ToastActivity extends AppCompatActivity {

    private ActivityToastBinding mBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_toast);
        mBinding.setClickProxy(new ClickProxy());
    }

    private Toast mToast;
    private int index = 0;

    public class ClickProxy {
        public void toShowTop() {
            if (mToast == null) {
                mToast = Toast.makeText(getApplicationContext(), "xx", Toast.LENGTH_SHORT);
            }
            index++;
            mToast.setText("" + index);
            mToast.setGravity(Gravity.TOP, 0, 0);
            mToast.show();
        }

        public void toShowCenter() {
            mToast.cancel();
        }

        public void toShowBottom() {
        }
    }

}
