package com.kingoit.widgetproductor.tip;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

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

    public class ClickProxy {
        public void toShowTop() {
        }

        public void toShowCenter() {
        }

        public void toShowBottom() {
        }
    }

}
