package cn.weli.learnandroiddemo.ViewControl.ListView;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import cn.weli.learnandroiddemo.R;

public class ListViewActivity extends AppCompatActivity {

    private ListView mListview;
    private String[] data = {"Apple", "Banana", "Orange", "Watermelon", "Pear", "Grape", "Pineapple",
            "Strawberry", "Cherry", "Mango"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        mListview = findViewById(R.id.listview);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(ListViewActivity.this,R.layout.support_simple_spinner_dropdown_item,data);
        mListview.setAdapter(adapter);
    }
}
