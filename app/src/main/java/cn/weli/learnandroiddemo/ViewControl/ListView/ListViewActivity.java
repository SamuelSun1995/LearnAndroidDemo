package cn.weli.learnandroiddemo.ViewControl.ListView;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import cn.weli.learnandroiddemo.R;

public class ListViewActivity extends AppCompatActivity {

    private ListView mListview;
    private String[] data = {"Apple", "Banana", "Orange", "Watermelon", "Pear", "Grape", "Pineapple",
            "Strawberry", "Cherry", "Mango"};

    private List list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        mListview = findViewById(R.id.listview);
        list = new ArrayList();
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(ListViewActivity.this,R.layout.support_simple_spinner_dropdown_item,data);
//        mListview.setAdapter(adapter);
        initList();
        //未优化的适配器
        ItemAdapter adapter = new ItemAdapter(ListViewActivity.this, R.layout.item_adapter_layout,list);
        //优化的适配器
        ListViewAdapter viewAdapter = new ListViewAdapter(ListViewActivity.this, 0, list);
        mListview.setAdapter(viewAdapter);
    }

    public void initList() {
        for(int i=0;i<10000;i++){
            Item item = new Item("Item:" + i, R.mipmap.ic_launcher);
            list.add(item);
        }
    }
}
