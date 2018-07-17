package com.kingoit.widgetproductor.tip;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.kingoit.tip.tooltip.KingoitTooltip;
import com.kingoit.widgetproductor.R;
import com.kingoit.widgetproductor.databinding.ActivityBannerBinding;

/**
 * @author xmj
 * @date 2018/7/16
 */
public class BannerActivity extends AppCompatActivity {

    private ActivityBannerBinding mBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_banner);
        mBinding.setClickProxy(new ClickProxy());
    }

    public class ClickProxy {

        public void toShowTop() {
        }

        public void toShowBottom() {
        }
    }

}
