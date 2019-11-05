package cn.weli.learnandroiddemo.DataStorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import cn.weli.learnandroiddemo.R;

public class SpStoreActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mEdSp;
    private Button mBtnWriteSp;
    private Button mBtnReadSp;
    private TextView mTvData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sp_store);
        bindView();
        setListener();

    }

    public void bindView() {

        mEdSp = findViewById(R.id.ed_sp);
        mBtnWriteSp = findViewById(R.id.write_sp);
        mBtnReadSp = findViewById(R.id.read_sp);
        mTvData = findViewById(R.id.tv_data);
    }

    public void setListener() {
//        mEdSp.setOnClickListener(this);
        mBtnWriteSp.setOnClickListener(this);
        mBtnReadSp.setOnClickListener(this);
//        mTvData.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.write_sp:
                String str = mEdSp.getText().toString().trim();
                //1.创建一个SharePreferences.Editor接口对象，lock表示要写入的xml文件名，MODE_WORLD_WRITEABLE写操作
                SharedPreferences.Editor editor = getSharedPreferences("lock", MODE_WORLD_WRITEABLE).edit();
                //2. 将获取的值存入文件
                editor.putString("str", str);
                //3. 提交
                editor.commit();
                Toast.makeText(this, "sp存储成功!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.read_sp:
                //1.创建一个SharePrefence接口对象
                SharedPreferences read = getSharedPreferences("lock", MODE_WORLD_READABLE);
                //2.获取文件中的值
                String value = read.getString("str", "");
                mTvData.setText("获取成功存储的值为：" + value);
                break;
        }
    }
}
