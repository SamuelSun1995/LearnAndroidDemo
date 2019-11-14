package cn.weli.learnandroiddemo.ViewControl.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import cn.weli.learnandroiddemo.R;

public class XmlMenuActivity extends AppCompatActivity {

    private TextView mTvWnl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xml_menu);

        mTvWnl = findViewById(R.id.tv_wnl);
        //为文本注册上下文菜单
        registerForContextMenu(mTvWnl);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //装填R.menu.submenu对应菜单并装填到menu中
        getMenuInflater().inflate(R.menu.submenu,menu);
        return super.onCreateOptionsMenu(menu);
    }


    //创建上下文菜单时使用

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        //装填R.menu.contextmenu对应菜单并装填到menu中

        getMenuInflater().inflate(R.menu.contextmenu,menu);

        menu.setHeaderIcon(R.mipmap.ic_launcher);
        menu.setHeaderTitle("请选择背景色");

        super.onCreateContextMenu(menu, v, menuInfo);
    }


    //上下文菜单中被单击触发该方法

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.red:
                mTvWnl.setBackgroundColor(Color.RED);
                break;
            case R.id.green:
                mTvWnl.setBackgroundColor(Color.GREEN);
                break;
            case R.id.blue:
                mTvWnl.setBackgroundColor(Color.BLUE);
                break;
        }

        return true;
    }

    //菜单项被单击后回调
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
                //判断单击的是哪个菜单项，并有针对性的做出响应
        switch (item.getItemId()) {
            case R.id.font_10:
                mTvWnl.setTextSize(10*2);
                break;
            case R.id.font_12:
                mTvWnl.setTextSize(12*2);
                break;
            case R.id.font_14:
                mTvWnl.setTextSize(14*2);
                break;
            case R.id.font_16:
                mTvWnl.setTextSize(16*2);
                break;
            case R.id.font_18:
                mTvWnl.setTextSize(18*2);
                break;
            case R.id.red_font:
                mTvWnl.setTextColor(Color.RED);
                break;
            case R.id.green_font:
                mTvWnl.setTextColor(Color.GREEN);
                break;
            case R.id.blue_font:
                mTvWnl.setTextColor(Color.BLUE);
                break;
            case R.id.plain_item:
                Toast.makeText(this,"您单击了普通菜单项！", Toast.LENGTH_SHORT).show();
                break;

        }
        return true;
    }
}


