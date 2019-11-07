package cn.weli.learnandroiddemo.ViewControl.RecyleView;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;

import cn.weli.learnandroiddemo.R;
import cn.weli.learnandroiddemo.ViewControl.ListView.Item;

public class RecyleViewActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyle_view);
        mRecyclerView = findViewById(R.id.recyleview);
        list = new ArrayList<String>();
        //初始化数据
        initList();
        //设置recyleView保持固定的大小，这样可以优化RecylerView的性能
        mRecyclerView.setHasFixedSize(true);
        //线性布局
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        //网格布局
//        GridLayoutManager layoutManager = new GridLayoutManager(this, 4);
        //瀑布流
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL);    //多少列，多少行
//        //设置recyleView滚动方向
//        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        //设置Item增加、移除动画
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        //添加分割线
//        mRecyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
//        mRecyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.HORIZONTAL));
        //为recyleView设置布局管理器
        mRecyclerView.setLayoutManager(layoutManager);
        RecyleViewAdapter adapter = new RecyleViewAdapter(list);
        mRecyclerView.setAdapter(adapter);
    }

    public void initList() {
        char c = 'A';
        for (int i = 0; i < 10000; i++) {
            if (c != 'Z') {
                list.add(c + "");
                c++;
            } else {
                list.add("Z");
                c = 'A';
            }
        }
    }
}
