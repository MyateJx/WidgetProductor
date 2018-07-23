package com.kingoit.widgetproductor.list;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kingoit.list.spinner.BaseSpinnerAdapter;
import com.kingoit.widgetlib.R;

import java.util.List;

/**
 * 展示UserBean类型数据的SpinnerAdapter
 *
 * @author zuo
 * @date 2017/11/23 15:25
 */

public class SpinnerUserChooseAdapter extends BaseSpinnerAdapter<RecyclerView.ViewHolder, SpinnerActivity.UserBean> {
    private List<SpinnerActivity.UserBean> mData;

    public SpinnerUserChooseAdapter(Context context, List<SpinnerActivity.UserBean> list, OnItemClickListener itemClickListener) {
        super(context, list, R.layout.item_choose_time);
        this.mData = list;
        setOnItemClickListener(itemClickListener);
    }

    @Override
    protected RecyclerView.ViewHolder getViewHolder(View itemView) {
        itemView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        return new ItemViewHolder(itemView);
    }

    @Override
    protected void setValues(RecyclerView.ViewHolder holder, int position) {
        ((ItemViewHolder) holder).textView.setText(mData.get(position).getName());
    }

    @Override
    protected List<SpinnerActivity.UserBean> getData() {
        return mData;
    }


    public class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public ItemViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.choose_item);
        }
    }
}
