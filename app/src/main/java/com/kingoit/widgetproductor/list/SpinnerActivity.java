package com.kingoit.widgetproductor.list;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.kingoit.list.spinnerview.KingoitItemView;
import com.kingoit.widgetproductor.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zyh on 2018/7/17.
 */

public class SpinnerActivity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        kingoitItemViewTest();
    }

    private void kingoitItemViewTest() {
        KingoitItemView kingoitItemView = findViewById(R.id.test);
        List<String> list = new ArrayList<>();
        list.add("qqqdsfasdfasdf");
        list.add("wwwqewrqwr");
        list.add("qqeeeqasdasda");
        list.add("rrrgfsdgag");
        list.add("tthshsdfhsdfgt");
        list.add("qqqyyyyyyyyyyyyyyyyyy");
        kingoitItemView.setList(list);
    }
}
