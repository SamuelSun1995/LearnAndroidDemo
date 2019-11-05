package cn.weli.learnandroiddemo.DataStorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import cn.weli.learnandroiddemo.R;

public class DataStoreMainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnSp;
    private Button mBtnFile;
    private Button mBtnDb;
    private Button mBtnCp;
    private Button mBtnNet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_store_main);
        bindView();
        setListener();
    }

    public void bindView(){
        mBtnSp = findViewById(R.id.sp_store);
        mBtnFile =findViewById(R.id.file_store);
        mBtnDb = findViewById(R.id.db_store);
        mBtnCp = findViewById(R.id.ContentProvider_store);
        mBtnNet =findViewById(R.id.net_store);
    }
    public void setListener(){
        mBtnSp.setOnClickListener(this);
        mBtnFile.setOnClickListener(this);
        mBtnDb.setOnClickListener(this);
        mBtnCp.setOnClickListener(this);
        mBtnNet.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.sp_store:
                Intent intent_sp = new Intent(this, SpStoreActivity.class);
                startActivity(intent_sp);
                break;
            case R.id.file_store:
                Intent intent_file = new Intent(this, FileStoreActivity.class);
                startActivity(intent_file);
                break;
            case R.id.db_store:
                break;
            case R.id.ContentProvider_store:
                break;
            case R.id.net_store:
                break;
        }
    }
}
