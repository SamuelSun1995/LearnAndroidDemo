package cn.weli.learnandroiddemo.ViewControl.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cn.weli.learnandroiddemo.R;
import cn.weli.learnandroiddemo.ViewControl.ListView.ItemAdapter;

public class SearchViewActivity extends AppCompatActivity {

    private String[] data = {"Apple", "Banana", "Orange", "Watermelon", "Pear", "Grape", "Pineapple",
            "Strawberry", "Cherry", "Mango"};

    private SearchView mSearchView;
    private ListView mListView;
    private List<Integer> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_view);
        mSearchView = findViewById(R.id.sv);
        mListView = findViewById(R.id.tv_lv);

        mList = new ArrayList<>();

        initData();

        ArrayAdapter adapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, mList);
        mListView.setAdapter(adapter);
        //设置ListView启用过滤
        mListView.setTextFilterEnabled(true);
        //设置该SearchView是否自动缩小为图标
        mSearchView.setIconifiedByDefault(false);
        //设置该searchview显示搜索按钮
        mSearchView.setSubmitButtonEnabled(true);

        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(SearchViewActivity.this,"您选择的是："+query,Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                mListView.setFilterText(newText);
                return true;
            }
        });


    }

    public void initData() {
        for (int i = 0; i < 1000; i++) {
            mList.add(i);
        }
    }
}
