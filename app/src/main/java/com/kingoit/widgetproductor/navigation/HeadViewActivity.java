package com.kingoit.widgetproductor.navigation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.kingoit.list.spinner.SpinnerUtils;
import com.kingoit.navigation.KingoitHeadView;
import com.kingoit.widgetproductor.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 展示 公共头文件
 *
 * @author zuo
 * @date 2018/7/20 11:59
 */
public class HeadViewActivity extends AppCompatActivity implements SpinnerUtils.ItemClickListener{

    private List<String> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_head_view);
    }

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        spinnerHeadView();
    }


    private void spinnerHeadView() {
        initData();
        KingoitHeadView headView1 = findViewById(R.id.head_view_1);
        final TextView headTitleTv = headView1.getHeadTitleTv();
        new SpinnerUtils(this, headTitleTv, list, this);
    }


    private void initData() {
        list.add("战争女神");
        list.add("蒙多");
        list.add("德玛西亚皇子");
        list.add("殇之木乃伊");
        list.add("狂战士");
        list.add("布里茨克拉克");
        list.add("冰晶凤凰 艾尼维亚");
        list.add("德邦总管");
        list.add("野兽之灵 乌迪尔 （德鲁伊）");
        list.add("赛恩");
        list.add("诡术妖姬");
        list.add("永恒梦魇");
    }

    @Override
    public void onItemClick(View view) {
        int tag = (int) view.getTag();
        Toast.makeText(getApplicationContext(), list.get(tag), Toast.LENGTH_SHORT).show();
    }
}
