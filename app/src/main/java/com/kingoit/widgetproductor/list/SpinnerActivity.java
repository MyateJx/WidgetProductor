package com.kingoit.widgetproductor.list;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.kingoit.list.spinner.BaseSpinnerAdapter;
import com.kingoit.list.spinner.SpinnerUtils;
import com.kingoit.widgetproductor.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zyh on 2018/7/17.
 */

public class SpinnerActivity extends AppCompatActivity implements BaseSpinnerAdapter.OnItemClickListener {
    private List<UserBean> list = new ArrayList<>();
    private TextView textView;
    private SpinnerUtils spinnerUtils;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        initData();
        initView();
    }

    private void initView() {
        textView = findViewById(R.id.show_spinner);
//        SpinnerChooseAdapter chooseAdapter = new SpinnerChooseAdapter(this, list, this);
        SpinnerUserChooseAdapter chooseAdapter = new SpinnerUserChooseAdapter(this, list, this);
        spinnerUtils = new SpinnerUtils(this, textView, chooseAdapter);
        spinnerUtils.setArrows(R.drawable.arrow_down_app,R.drawable.arrow_up_app);
        spinnerUtils.init();
    }

    private void initData() {
        list.add(new UserBean(1,"战争女神"));
        list.add(new UserBean(2,"蒙多"));
        list.add(new UserBean(3,"德玛西亚皇子"));
        list.add(new UserBean(4,"殇之木乃伊"));
        list.add(new UserBean(5,"狂战士"));
        list.add(new UserBean(6,"布里茨克拉克"));
        list.add(new UserBean(7,"冰晶凤凰 艾尼维亚"));
        list.add(new UserBean(8,"德邦总管"));
        list.add(new UserBean(9,"野兽之灵 乌迪尔 （德鲁伊）"));
        list.add(new UserBean(10,"赛恩"));
        list.add(new UserBean(11,"诡术妖姬"));
        list.add(new UserBean(12,"永恒梦魇"));
    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this, "点击" + list.get(position).getName(), Toast.LENGTH_SHORT).show();
        textView.setText(list.get(position).getName());
        if (spinnerUtils != null) {
            spinnerUtils.closeSpinner();
        }
    }

    @Override
    public void onItemLongClick(View view, int position) {
        Toast.makeText(this, "长按" + list.get(position).getName(), Toast.LENGTH_SHORT).show();
        textView.setText(list.get(position).getName());
        if (spinnerUtils != null) {
            spinnerUtils.closeSpinner();
        }
    }

    public class UserBean{
        private int id;
        private String name;

        public UserBean(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
