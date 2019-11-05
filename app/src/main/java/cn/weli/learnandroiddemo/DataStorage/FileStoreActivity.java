package cn.weli.learnandroiddemo.DataStorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

import cn.weli.learnandroiddemo.R;

public class FileStoreActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mEdFile;
    private Button mBtnWriteFile;
    private Button mBtnReadFile;
    private TextView mTvDataFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_store);
        bindView();
        setListener();
    }

    public void bindView() {

        mEdFile = findViewById(R.id.ed_file);
        mBtnWriteFile = findViewById(R.id.write_file);
        mBtnReadFile = findViewById(R.id.read_file);
        mTvDataFile = findViewById(R.id.tv_data_file);
    }

    public void setListener() {
//        mEdSp.setOnClickListener(this);
        mBtnWriteFile.setOnClickListener(this);
        mBtnReadFile.setOnClickListener(this);
//        mTvData.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.write_file:
                String str = mEdFile.getText().toString().trim();
                writeFile(str);
                break;
            case R.id.read_file:
                String read = readFile();
                mTvDataFile.setText(read);
                break;
        }
    }

    public void write(String msg) {
        //步骤1：获取输入值
        if (msg == null) {
            return;
        }

        try {
            //步骤2：创建一个FileOutputStream对象，MODE_APPEND追加模式
            FileOutputStream fos = openFileOutput("message.txt", MODE_APPEND);
            //步骤3：将获取过来的值放入文件
            fos.write(msg.getBytes());
            //步骤4：关闭数据流
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String read() {
        try {
            FileInputStream inStream = openFileInput("message.txt");
            byte[] buffer = new byte[1024];
            int hasRead = 0;
            StringBuilder sb = new StringBuilder();
            while ((hasRead = inStream.read(buffer)) != -1) {
                sb.append(new String(buffer, 0, hasRead));
            }
            inStream.close();
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void writeFile(String content) {
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {   //如果sdcard存在
            File file = new File(Environment.getExternalStorageDirectory().toString() + File.separator + "szx_test" + File.separator + "file_store.txt");   //定义File类对象
            if (!file.getParentFile().exists()) { //父文件夹不存在
                file.getParentFile().mkdirs();  //创建文件夹
            }
            PrintStream out = null; //打印流对象用于输出
            try {
                out = new PrintStream(new FileOutputStream(file, true));    //追加文件
                out.println(content);
                Toast.makeText(this, "保存到SDCard成功！", Toast.LENGTH_SHORT).show();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } finally {
                if (out != null) {
                    out.close();    //关闭打印流
                }
            }
        } else { //SDCard不存在
            Toast.makeText(this, "保存失败，SD不存在！", Toast.LENGTH_SHORT).show();

        }
    }

    //文件读操作函数
    public String readFile() {
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {    //如果sdcard存在
            File file = new File(Environment.getExternalStorageDirectory().toString() + File.separator + "szx_test" + File.separator + "file_store.txt");   //定义File类对象
            if (!file.getParentFile().exists()) { //父文件夹不存在
                file.getParentFile().mkdirs();  //创建文件夹
            }
            Scanner scan = null;    //扫描输入
            StringBuilder sb = new StringBuilder();
            try {
                scan = new Scanner(new FileInputStream(file));
                while (scan.hasNext()) {
                    sb.append(scan.next() + "\n");  //设置文本
                }
                Toast.makeText(FileStoreActivity.this, "读取成功！", Toast.LENGTH_SHORT).show();
                return sb.toString();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } finally {
                if (scan != null) {
                    scan.close();
                }
            }

        }else {
            Toast.makeText(this, "读取失败，SD不存在！", Toast.LENGTH_SHORT).show();
        }
        return null;
    }

}
