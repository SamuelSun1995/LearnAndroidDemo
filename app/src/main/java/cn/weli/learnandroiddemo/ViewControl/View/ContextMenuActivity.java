package cn.weli.learnandroiddemo.ViewControl.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import cn.weli.learnandroiddemo.R;

public class ContextMenuActivity extends AppCompatActivity {

    //每个菜单的标识
    private static final int MENU1 = 0x111;
    private static final int MENU2 = 0x112;
    private static final int MENU3 = 0x113;
    private TextView mTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_context_menu);
        mTxt = findViewById(R.id.tv_txt);

        //为文本框注册上下文菜单
        registerForContextMenu(mTxt);


    }

    //创建上下文方法时触发该方法


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.add(0,MENU1,0,"红色");
        menu.add(0,MENU2,0,"绿色");
        menu.add(0,MENU3,0,"蓝色");
        //将三个菜单项设为单选菜单项
        menu.setGroupCheckable(0,true,true);
        //设置上下文菜单的标题、图标
        menu.setHeaderIcon(R.mipmap.ic_launcher);
        menu.setHeaderTitle("选择背景色");
    }
    //上下文菜单的菜单项被单击时触发该方法


    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case MENU1:
                mTxt.setBackgroundColor(Color.RED);
                break;
            case MENU2:
                mTxt.setBackgroundColor(Color.GREEN);
                break;
            case MENU3:
                mTxt.setBackgroundColor(Color.BLUE);
                break;
        }

        return true;
    }
}
