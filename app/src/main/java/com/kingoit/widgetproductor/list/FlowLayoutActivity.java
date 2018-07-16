package com.kingoit.widgetproductor.list;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.kingoit.list.flowLayout.KingoitFlowLayout;
import com.kingoit.widgetproductor.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 流式布局示例代码
 *
 * @author zuo
 * @date 2018/7/16 12:27
 */
public class FlowLayoutActivity extends AppCompatActivity {

    private KingoitFlowLayout flowLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flow_layout);
        flowLayout = findViewById(R.id.kingoit_flow_layout);
        initData();
    }

    private void initData() {
        List<String> list = new ArrayList<>();
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
        showTag(list);
    }

    /**
     * 流式布局显示
     * @param list
     */
    private void showTag(List<String> list) {
        flowLayout.removeAllViews();
        for (int i = 0; i < list.size(); i++) {
            final String keywords = list.get(i);
            flowLayout.addItemView(LayoutInflater.from(this),keywords);
            flowLayout.getChildAt(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(FlowLayoutActivity.this,keywords,Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
