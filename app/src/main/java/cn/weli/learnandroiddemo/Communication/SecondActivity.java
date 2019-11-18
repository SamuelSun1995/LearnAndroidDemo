package cn.weli.learnandroiddemo.Communication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.content.CursorLoader;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Set;

import javax.xml.transform.Templates;

import cn.weli.learnandroiddemo.R;

public class SecondActivity extends AppCompatActivity {

    private TextView mTv;
    private TextView mShow;
    private TextView mTvPhone;
    private Button mBtnRead;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        initView();
        onClick();

    }

    public void initView() {
        mTv = findViewById(R.id.tv_show);
        mShow = findViewById(R.id.show);
        mTvPhone = findViewById(R.id.phone);
        mBtnRead = findViewById(R.id.btn_read);
        Toast.makeText(this, "Intent-filter启动！", Toast.LENGTH_SHORT).show();
        //获取该Activity对应的Intent的Action属性
        String action = getIntent().getAction();
        mTv.setText("Action为：\n" + action);
        Set<String> categories = getIntent().getCategories();
        mTv.setText("Action为：\n" + action + "\nCategories属性为：\n" + categories);


    }


    public void onClick(){
        mBtnRead.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                //运行时获取读取联系人信息的权限
                requestPermissions(new String[]{Manifest.permission.READ_CONTACTS},0X13);
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode==0x13){
            //如果用户同意授权访问
            if(permissions.length>0&&grantResults[0]== PackageManager.PERMISSION_GRANTED){
                //创建Intent
                Intent intent = new Intent();
                //设置Intent的action属性
                intent.setAction(Intent.ACTION_PICK);
                //设置Intent的Type
                intent.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE);
                //启动Activity，希望获取该Activity的结果
                startActivityForResult(intent,0);

            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case 0:
                if(requestCode == Activity.RESULT_OK){
                    //获取返回数据
                    Uri contactData = data.getData();
                    CursorLoader cursorLoader = new CursorLoader(this,contactData,null,null,null,null);
                    //查询联系人
                    Cursor cursor =cursorLoader.loadInBackground();
                    //如果查询到指定的联系人
                    if(cursor!=null&&cursor.moveToFirst()){
                        String contactId = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
                        //获取联系人的名字
                        String name = cursor.getString(cursor.getColumnIndexOrThrow(ContactsContract.Contacts.DISPLAY_NAME));
                        String phoneNumber = "此联系人暂未输入号码";
                        //根据联系人查询该联系人的详细信息
                        Cursor phones =getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,ContactsContract.CommonDataKinds.Phone._ID+"="+contactId,null,null);
                        if(phones!=null&&phones.moveToFirst()){
                            //取出电话号码
                            phoneNumber =phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                        }
                        //关闭游标
                        if(phones!=null){
                            phones.close();
                        }
                        //显示联系人姓名
                        mShow.setText(name);
                        //显示联系人号码
                        mTvPhone.setText(phoneNumber);
                    }
                    //关闭游标
                    if(cursor!=null){
                        cursor.close();
                    }
                }
        }
    }
}
