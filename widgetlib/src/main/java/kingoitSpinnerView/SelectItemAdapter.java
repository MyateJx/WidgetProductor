package kingoitSpinnerView;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.kingoit.widgetlib.R;

import java.util.ArrayList;
import java.util.List;


public class SelectItemAdapter extends BaseAdapter {

    private Context mContext;
    private List<String> mList = new ArrayList<>();
    private ISelectItemAdapterListener listener;

    public SelectItemAdapter(Context context) {
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int i) {
        return mList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder vh = null;
        final String text = mList.get(i);
        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.select_item_view, viewGroup, false);
            vh = new ViewHolder(view);
            view.setTag(vh);
        } else {
            vh = (ViewHolder) view.getTag();
        }

        vh.textView.setText(text);
        vh.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.ISelectItemAdapterListener_onItemClick(text);
                }
            }
        });
        return null;
    }

    private class ViewHolder {

        private TextView textView;

        ViewHolder(View view) {
            textView = view.findViewById(R.id.input_selectitem_account);
        }

    }

    public void setList(List<String> list) {
        if (!mList.isEmpty()) {
            mList.clear();
        }
        mList.addAll(list);
        notifyDataSetChanged();
    }

    public void setISelectItemAdapterListener(ISelectItemAdapterListener listener) {
        this.listener = listener;
    }

    public interface ISelectItemAdapterListener {
        void ISelectItemAdapterListener_onItemClick(String text);
    }
}
