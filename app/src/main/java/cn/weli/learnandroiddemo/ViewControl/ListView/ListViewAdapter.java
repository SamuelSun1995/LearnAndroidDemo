package cn.weli.learnandroiddemo.ViewControl.ListView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import cn.weli.learnandroiddemo.R;

public class ListViewAdapter extends ArrayAdapter {

    public ListViewAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view;
        ViewHolder viewHolder;
        if(convertView==null){
            view = LayoutInflater.from(getContext()).inflate(R.layout.item_adapter_layout, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.imageView = view.findViewById(R.id.item_img);
            viewHolder.textView = view.findViewById(R.id.item_text);
            view.setTag(viewHolder);
        }else {
            view =convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        Item item = (Item) getItem(position);
        viewHolder.imageView.setImageResource(item.getImgId());
        viewHolder.textView.setText(item.getName());

        return view;
    }
}

class ViewHolder{
    ImageView imageView;
    TextView textView;
}
