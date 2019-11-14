package cn.weli.learnandroiddemo.ViewControl.View;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import cn.weli.learnandroiddemo.R;

public class DialogActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mTv;

    private Button mSimple;
    private Button mList;
    private Button mSingle;
    private Button mMulti;
    private Button mCusList;
    private Button mCusView;

    private String[] mData =new String[]{"列表1", "列表2", "列表3", "列表4"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        bindView();
        setListener();

    }


    public void bindView() {

        mTv = findViewById(R.id.tv_dialog);

        mSimple = findViewById(R.id.simple_dialog);
        mList = findViewById(R.id.simple_list_dialog);
        mSingle = findViewById(R.id.single_select);
        mMulti = findViewById(R.id.simple_multiple_dialog);
        mCusList = findViewById(R.id.cus_list);
        mCusView = findViewById(R.id.cus_view);
    }

    public void setListener() {
        mSimple.setOnClickListener(this);
        mList.setOnClickListener(this);
        mSingle.setOnClickListener(this);
        mMulti.setOnClickListener(this);
        mCusList.setOnClickListener(this);
        mCusView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.simple_dialog:
                //1. 创建AlertDialog.Builder 对象
                AlertDialog.Builder builder1 = new AlertDialog.Builder(this)
                        //2.调用AlertDialog.Builder setTitle或setCustomTitle， setIcon
                        .setTitle("简单的对话框")
                        .setIcon(R.mipmap.ic_launcher);
                builder1.setMessage("简单对话框测试内容\n第二行内容！");
                //设置确定按钮
                setPositiveButton(builder1);
                //设置取消按钮
                setNegativeButton(builder1).create().show();
                break;
            case R.id.simple_list_dialog:

                //1. 创建AlertDialog.Builder 对象
                AlertDialog.Builder builder2 = new AlertDialog.Builder(this)
                        //2.调用AlertDialog.Builder setTitle或setCustomTitle， setIcon
                        .setTitle("简单的列表对话框")
                        .setIcon(R.mipmap.ic_launcher);
                builder2.setItems(mData, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(DialogActivity.this,"你选中了：《"+mData[which]+"》",Toast.LENGTH_SHORT).show();
                    }
                });
                //设置确定按钮
                setPositiveButton(builder2);
                //设置取消按钮
                setNegativeButton(builder2).create().show();

                break;
            case R.id.single_select:
                //1. 创建AlertDialog.Builder 对象
                AlertDialog.Builder builder3 = new AlertDialog.Builder(this)
                        //2.调用AlertDialog.Builder setTitle或setCustomTitle， setIcon
                        .setTitle("简单的单选对话框")
                        .setIcon(R.mipmap.ic_launcher);

                builder3.setSingleChoiceItems(mData, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(DialogActivity.this,"你选中了：《"+mData[which]+"》",Toast.LENGTH_SHORT).show();
                    }
                });
                //设置确定按钮
                setPositiveButton(builder3);
                //设置取消按钮
                setNegativeButton(builder3).create().show();
                break;
            case R.id.simple_multiple_dialog:

                //1. 创建AlertDialog.Builder 对象
                AlertDialog.Builder builder4 = new AlertDialog.Builder(this)
                        //2.调用AlertDialog.Builder setTitle或setCustomTitle， setIcon
                        .setTitle("简单的多选对话框")
                        .setIcon(R.mipmap.ic_launcher);

                builder4.setMultiChoiceItems(mData, new boolean[]{false, false, true, false}, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        Toast.makeText(DialogActivity.this,"你选中了：《"+mData[which]+"》",Toast.LENGTH_SHORT).show();
                    }
                });
                //设置确定按钮
                setPositiveButton(builder4);
                //设置取消按钮
                setNegativeButton(builder4).create().show();

                break;
            case R.id.cus_list:
                //1. 创建AlertDialog.Builder 对象
                AlertDialog.Builder builder5 = new AlertDialog.Builder(this)
                        //2.调用AlertDialog.Builder setTitle或setCustomTitle， setIcon
                        .setTitle("简单的自定义列表对话框")
                        .setIcon(R.mipmap.ic_launcher);

                builder5.setAdapter(new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, mData), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(DialogActivity.this,"你选中了：《"+mData[which]+"》",Toast.LENGTH_SHORT).show();
                    }
                });

                //设置确定按钮
                setPositiveButton(builder5);
                //设置取消按钮
                setNegativeButton(builder5).create().show();
                break;
            case R.id.cus_view:
                View login = getLayoutInflater().inflate(R.layout.login, null);

                //1. 创建AlertDialog.Builder 对象
                AlertDialog.Builder builder6 = new AlertDialog.Builder(this)
                        //2.调用AlertDialog.Builder setTitle或setCustomTitle， setIcon
                        .setTitle("简单的自定义View对话框")
                        .setIcon(R.mipmap.ic_launcher);
                builder6.setView(login);

                //设置确定按钮
                setPositiveButton(builder6);
                //设置取消按钮
                setNegativeButton(builder6).create().show();
                break;
        }
    }


    public AlertDialog.Builder setPositiveButton(AlertDialog.Builder builder) {
        return builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
              mTv.setText("单击了【确定】按钮！");
            }
        });
    }
    public AlertDialog.Builder setNegativeButton(AlertDialog.Builder builder) {
        return builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mTv.setText("单击了【取消】按钮！");
            }
        });
    }
}
