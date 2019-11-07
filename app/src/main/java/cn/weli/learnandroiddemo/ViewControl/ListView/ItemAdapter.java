package cn.weli.learnandroiddemo.ViewControl.ListView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import cn.weli.learnandroiddemo.R;

public class ItemAdapter extends ArrayAdapter {

    private int mLayoutId;
    private ImageView imageView;
    private TextView mTvItem;

    public ItemAdapter(Context context, int resource, List list) {
        super(context, resource, list);
        this.mLayoutId = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Item item = (Item) getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(mLayoutId, parent, false);
        imageView = view.findViewById(R.id.item_img);
        mTvItem = view.findViewById(R.id.item_text);
        imageView.setImageResource(item.getImgId());
        mTvItem.setText(item.getName());
        return view;
    }
}
