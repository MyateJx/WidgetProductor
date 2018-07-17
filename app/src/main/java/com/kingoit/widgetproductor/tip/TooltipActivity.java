package com.kingoit.widgetproductor.tip;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.kingoit.tip.tooltip.KingoitTooltip;
import com.kingoit.widgetproductor.R;

/**
 * @author xmj
 * @date 2018/7/16
 */
public class TooltipActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnHide, btnShow;
    private ViewGroup rootlayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tooltips);
        btnHide = findViewById(R.id.btn_hide);
        btnHide.setOnClickListener(this);
        btnShow = findViewById(R.id.btn_show);
        btnShow.setOnClickListener(this);
        rootlayout = findViewById(R.id.rootLayout);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_hide:
                KingoitTooltip.getInstance().dismissAll();
                break;
            case R.id.btn_show:
                KingoitTooltip.getInstance().showTip(getApplicationContext(), btnHide, rootlayout, "哈哈哈", KingoitTooltip.POSITION_ABOVE);
                break;
            default:
        }
    }
}
