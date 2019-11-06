package cn.weli.learnandroiddemo.ViewControl.ListView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

public class ItemAdapter extends ArrayAdapter {

    private int mLayoutId;

    public ItemAdapter(Context context, int resource) {
        super(context, resource);
        this.mLayoutId = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Item item = (Item) getItem(position);
        LayoutInflater.from(getContext()).inflate(mLayoutId,parent,false);
        return super.getView(position, convertView, parent);
    }
}
