package cn.weli.learnandroiddemo.Net;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import cn.weli.learnandroiddemo.R;

public class MyObject {

    private Context mContext;

    public MyObject(Context context){

        mContext = context;
    }

    //该方法将会暴露给JavaScript调用
    @JavascriptInterface    public void showToast(String name){

        Toast.makeText(mContext,name+"您好！",Toast.LENGTH_SHORT).show();

    }

    //该方法将会暴露给JavaScript调用
    @JavascriptInterface
    public void showList(){
        //显示一个普通的列表对话框
        new AlertDialog.Builder(mContext)
                .setTitle("图书列表")
                .setIcon(R.mipmap.ic_launcher)
                .setItems(new String[] {"Java","Android","Html"},null)
                .setPositiveButton("确定",null)
                .create()
                .show();
    }
}
