package cn.weli.learnandroiddemo.ViewControl.Fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import cn.weli.learnandroiddemo.R;

public class DynamicFragmentActivity extends AppCompatActivity implements View.OnClickListener {


    private FragmentManager mFragmentManager;

    private Button mBtnChange1;
    private Button mBtnChange2;

    private MyFragment1 mMyFragment1;
    private MyFragment2 mMyFragment2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_fragment);
        mMyFragment1 = new MyFragment1();
        mMyFragment2 = new MyFragment2();
        //Fragment管理器
        mFragmentManager = getSupportFragmentManager();
        //开启事务
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        //添加一个Fragment
        fragmentTransaction.add(R.id.holder, mMyFragment2);
        viewControl();
        //提交事务
        fragmentTransaction.commit();
        //Activity传递数据给Fragment
        sendDataToFragment();
        //Fragment传递数据给Activity，回调接受
        receiveDataFromFragment();
    }

    public void viewControl() {
        mBtnChange1 = findViewById(R.id.btn_change1);
        mBtnChange2 = findViewById(R.id.btn_change2);
        mBtnChange1.setOnClickListener(this);
        mBtnChange2.setOnClickListener(this);
    }


    public void sendDataToFragment(){
        //创建bundle数据包
        Bundle bundle = new Bundle();
        bundle.putString("str","StringData");
        bundle.putChar("char",'c');
        bundle.putInt("int",1);
        //调用fragment实例的setArguments(bundle)
        mMyFragment1.setArguments(bundle);
    }

    public void receiveDataFromFragment(){
        mMyFragment1.getData(new MyFragment1.CallBack() {
            @Override
            public void getResult(String result) {
                Toast.makeText(DynamicFragmentActivity.this,result,Toast.LENGTH_SHORT).show();
            }
        });
    }



    @Override
    public void onClick(View v) {
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        switch (v.getId()){
            case R.id.btn_change1:
                fragmentTransaction.replace(R.id.holder, mMyFragment1);
                break;
            case R.id.btn_change2:
                fragmentTransaction.replace(R.id.holder, mMyFragment2);
                break;
        }
        fragmentTransaction.commit();
    }

}
