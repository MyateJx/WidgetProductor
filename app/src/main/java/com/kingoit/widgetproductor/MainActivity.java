package com.kingoit.widgetproductor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.kingoit.widgetproductor.list.FlowLayoutActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.to_flow_layout).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.to_flow_layout:
                startActivity(new Intent(MainActivity.this, FlowLayoutActivity.class));
                break;
            default:
                break;
        }
    }
}
