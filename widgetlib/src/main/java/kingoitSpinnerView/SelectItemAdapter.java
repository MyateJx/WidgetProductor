package kingoitSpinnerView;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
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


public class SelectItemAdapter extends RecyclerView.Adapter<SelectItemAdapter.ViewHolder> {

    private Context mContext;
    private List<String> mList = new ArrayList<>();
    private ISelectItemAdapterListener listener;

    public SelectItemAdapter(Context context) {
        this.mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.select_item_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final String text = mList.get(position);
        holder.textView.setText(text);
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (null != listener) {
                    listener.ISelectItemAdapterListener_onItemClick(text);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;

        ViewHolder(View view) {
            super(view);
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
