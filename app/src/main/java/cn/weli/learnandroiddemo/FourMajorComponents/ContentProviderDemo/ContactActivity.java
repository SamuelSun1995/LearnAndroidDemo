package cn.weli.learnandroiddemo.FourMajorComponents.ContentProviderDemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.ListView;

import cn.weli.learnandroiddemo.R;

public class ContactActivity extends AppCompatActivity {

    private ListView mLv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        //检查权限
        check();
    }

    public void check() {
        //判断是否有权限
        if(ContextCompat.checkSelfPermission(ContactActivity.this, Manifest.permission.READ_CONTACTS)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(ContactActivity.this,new String[]{Manifest.permission.READ_CONTACTS},201);

        }

    }
}
