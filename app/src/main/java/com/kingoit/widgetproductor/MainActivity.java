package com.kingoit.widgetproductor;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.kingoit.widgetproductor.databinding.ActivityMainBinding;
import com.kingoit.widgetproductor.list.FlowLayoutActivity;
import com.kingoit.widgetproductor.list.SpinnerActivity;
import com.kingoit.widgetproductor.navigation.HeadViewActivity;
import com.kingoit.widgetproductor.show.MarqueeTextActivity;
import com.kingoit.widgetproductor.tip.BannerActivity;
import com.kingoit.widgetproductor.tip.DialogActivity;
import com.kingoit.widgetproductor.tip.ToastActivity;
import com.kingoit.widgetproductor.tip.TooltipActivity;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mBinding.setClickProxy(new ClickProxy());
    }

    public class ClickProxy {
        public void toTooltip() {
            startActivity(new Intent(MainActivity.this, TooltipActivity.class));
        }

        public void toFlowLayout() {
            startActivity(new Intent(MainActivity.this, FlowLayoutActivity.class));
        }

        public void toSpinner() {
            startActivity(new Intent(MainActivity.this, SpinnerActivity.class));
        }

        public void toToast() {
            startActivity(new Intent(MainActivity.this, ToastActivity.class));
        }

        public void toBanner() {
            startActivity(new Intent(MainActivity.this, BannerActivity.class));
        }

        public void toDialog() {
            startActivity(new Intent(MainActivity.this, DialogActivity.class));
        }

        public void toHeadView() {
            startActivity(new Intent(MainActivity.this, HeadViewActivity.class));
        }

        public void toShowView() {
            startActivity(new Intent(MainActivity.this, MarqueeTextActivity.class));
        }
    }


}
