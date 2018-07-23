package com.kingoit.widgetproductor.tip;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.kingoit.tip.tooltip.KingoitTooltip;
import com.kingoit.widgetproductor.R;
import com.kingoit.widgetproductor.databinding.ActivityTooltipsBinding;

/**
 * @author xmj
 * @date 2018/7/16
 */
public class TooltipActivity extends AppCompatActivity {

    private ActivityTooltipsBinding mBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_tooltips);
        mBinding.setClickProxy(new ClickProxy());
    }

    public class ClickProxy {
        public void toHide() {
            KingoitTooltip.getInstance().dismissAll();
        }

        public void toShow() {
            KingoitTooltip.getInstance().showTip(getApplicationContext(),
                    mBinding.btnSimpleDialog, mBinding.rootLayout, "哈哈哈", KingoitTooltip.POSITION_ABOVE);
        }

        public void toShowLeft() {
            KingoitTooltip.getInstance().showTip(getApplicationContext(),
                    mBinding.btnSimpleDialog, mBinding.rootLayout, "哈哈哈", KingoitTooltip.POSITION_LEFT_TO);
        }

        public void toShowRight() {
            KingoitTooltip.getInstance().showTip(getApplicationContext(),
                    mBinding.btnSimpleDialog, mBinding.rootLayout, "哈哈哈", KingoitTooltip.POSITION_RIGHT_TO);
        }

        public void toShowBottom() {
            KingoitTooltip.getInstance().showTip(getApplicationContext(),
                    mBinding.btnSimpleDialog, mBinding.rootLayout, "哈哈哈", KingoitTooltip.POSITION_BELOW);
        }
    }

}
