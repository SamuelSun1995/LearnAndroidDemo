package cn.weli.learnandroiddemo.Communication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import cn.weli.learnandroiddemo.R;

public class IntentActivity extends AppCompatActivity {

    private Button mBtnStart;
    private Button mBtnBackHome;
    private Button mBtnDataAndType1;
    private Button mBtnDataAndType2;
    private Button mBtnDataAndType3;
    private Button mBtnStartSysActivity;
    private Button mBtnStartAddBook;
    private Button mBtnCall;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);
        initView();

    }

    private void initView() {
        mBtnStart = findViewById(R.id.intent_test);
        mBtnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction("I want to go to the SecondActivity");
                intent.addCategory("category");
                startActivity(intent);
            }
        });

        mBtnBackHome = findViewById(R.id.btn_backhome);
        mBtnBackHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //创建Intent对象
                Intent intent = new Intent();
                //为Intent设置Action、Category属性
                intent.setAction(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                startActivity(intent);
            }
        });

        mBtnDataAndType1 = findViewById(R.id.btn_data_and_type1);
        mBtnDataAndType2 = findViewById(R.id.btn_data_and_type2);
        mBtnDataAndType3 = findViewById(R.id.btn_data_and_type3);

        mBtnDataAndType1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                //先为Intent设置Type属性
                intent.setType("abc/xyz");
                //再为Intent设置Data属性，覆盖Type
                intent.setData(Uri.parse("lee://www.weli.cn:8888/test"));               //其中lee:是scheme部分，www.weli.cn是host部分，8888是port部分，/test是path部分
                Toast.makeText(IntentActivity.this,intent.toString(),Toast.LENGTH_SHORT).show();
            }
        });
        mBtnDataAndType2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                //先为Intent设置Data属性，
                intent.setData(Uri.parse("lee://www.weli.cn:8888/test"));               //其中lee:是scheme部分，www.weli.cn是host部分，8888是port部分，/test是path部分
                //再为Intent设置Type属性，覆盖Data
                intent.setType("abc/xyz");
                Toast.makeText(IntentActivity.this,intent.toString(),Toast.LENGTH_SHORT).show();
            }
        });
        mBtnDataAndType3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                //同时设置Data和Type
                intent.setDataAndType(Uri.parse("lee://www.weli.cn:8888/test"),"abc/xyz");
                Toast.makeText(IntentActivity.this,intent.toString(),Toast.LENGTH_SHORT).show();
            }
        });


        mBtnStartSysActivity = findViewById(R.id.btn_start_sys_activity);
        mBtnStartAddBook = findViewById(R.id.btn_start_add_book);
        mBtnCall = findViewById(R.id.btn_call);
        mBtnStartSysActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //创建Intent
                Intent intent =new Intent();
                //为Intent设置Action属性
                intent.setAction(Intent.ACTION_VIEW);
                //设置Data属性
                intent.setData(Uri.parse("http://www.weli.cn"));
                startActivity(intent);
            }
        });

        mBtnStartAddBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //创建Intent
                Intent intent =new Intent();
                //为Intent设置Action属性（动作为编辑）
                intent.setAction(Intent.ACTION_EDIT);
                //设置Data属性
                intent.setData(Uri.parse("content://com.android.contacts/contacts/1"));
                startActivity(intent);
            }
        });
        mBtnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //创建Intent
                Intent intent =new Intent();
                //为Intent设置Action属性（动作为拨号）
                intent.setAction(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:15751008939"));
                startActivity(intent);
            }
        });

    }

}
