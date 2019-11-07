package cn.weli.learnandroiddemo.ViewControl.RecyleView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import cn.weli.learnandroiddemo.R;

public class RecyleViewAdapter extends RecyclerView.Adapter {

    private List<String> list;

    public RecyleViewAdapter(List<String> list) {
        this.list = list;

    }
    //创建新view被layoutManager所调用
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyle_view_layout, parent, false);
        return new MyViewHolder(view);
    }

    //将数据与界面进行绑定
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        ((MyViewHolder) holder).tv.setText(list.get(position));
        //瀑布流:设置一个随机高度
        ViewGroup.LayoutParams layoutParams = ((MyViewHolder) holder).tv.getLayoutParams();
        int mHeight = (int) (Math.random()*1000);
        layoutParams.height = mHeight;
        ((MyViewHolder) holder).tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.remove(position);
                notifyItemRemoved(position);
                notifyDataSetChanged();
            }
        });

    }
//获取数据数量
    @Override
    public int getItemCount() {
        return list.size();
    }
}

class MyViewHolder extends RecyclerView.ViewHolder {
    public TextView tv;
    public ImageView img;
    public LinearLayout mLinearLayout;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        tv = itemView.findViewById(R.id.recyle_view_tv);
//        img = itemView.findViewById(R.id.item_img);
        mLinearLayout = itemView.findViewById(R.id.recyleview_layout);
    }
}
