package cn.weli.learnandroiddemo.ViewControl.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.TextView;
import android.widget.Toast;

import cn.weli.learnandroiddemo.R;

public class MenuActivity extends AppCompatActivity {

    private TextView mTV;

    //定义“字体大小”菜单项的标识
    private static final int FONT_10 = 0x111;
    private static final int FONT_12 = 0x112;
    private static final int FONT_14 = 0x113;
    private static final int FONT_16 = 0x114;
    private static final int FONT_18 = 0x115;

    //定义普通菜单项标识
    private static final int PLAIN_ITEM = 0x11b;
    //定义“字体颜色”菜单项标识
    private static final int FONT_RED = 0x116;
    private static final int FONT_BLUE = 0x117;
    private static final int FONT_GREEN = 0x118;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        mTV =findViewById(R.id.txt);


    }


    //当用户点击Menu按键触发该方法
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //添加跳转页面的菜单
        SubMenu toActivity = menu.addSubMenu("跳转Activity");
        toActivity.setIcon(R.mipmap.ic_launcher);
        toActivity.setHeaderIcon(R.mipmap.ic_launcher);
        toActivity.setHeaderTitle("选择跳转页面");
        MenuItem item = toActivity.add("查看Swift");




        //向menu中添加字体大小的子菜单
        SubMenu fontMenu = menu.addSubMenu("字体大小");
        //设置菜单的图标
        fontMenu.setIcon(R.mipmap.ic_launcher);
        //设置菜单头的图标
        fontMenu.setHeaderIcon(R.mipmap.ic_launcher);
        //设置菜单头的标题
        fontMenu.setHeaderTitle("选择字体大小");
        fontMenu.add(0, FONT_10, 0, "10号字体");
        fontMenu.add(0, FONT_12, 0, "12号字体");
        fontMenu.add(0, FONT_14, 0, "14号字体");
        fontMenu.add(0, FONT_16, 0, "16号字体");
        fontMenu.add(0, FONT_18, 0, "18号字体");
        //设置菜单组是否可以勾选
        fontMenu.setGroupCheckable(0,true,false);

        //向menu中添加“普通菜单项”
        menu.add(0, PLAIN_ITEM, 0, "普通菜单项");
        //向menu中添加“字体颜色”的子菜单
        SubMenu colorMenu = menu.addSubMenu("字体颜色");
        colorMenu.setIcon(R.mipmap.ic_launcher);
        //设置菜单头的图标
        colorMenu.setHeaderIcon(R.mipmap.ic_launcher);
        //设置菜单头的标题
        colorMenu.setHeaderTitle("选择文字颜色");
        colorMenu.add(0, FONT_RED, 0, "红色");
        colorMenu.add(0, FONT_GREEN, 0, "绿色");
        colorMenu.add(0, FONT_BLUE, 0, "蓝色");



        item.setIntent(new Intent(MenuActivity.this, OtherActivity.class));            //重写onOptionsItemSelected方法会使其失效

        return super.onCreateOptionsMenu(menu);
    }

    //选项菜单的菜单项被单击后的回调


//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        //判断单击的是哪个菜单项，并有针对性的做出响应
//        switch (item.getItemId()) {
//            case FONT_10:
//                mTV.setTextSize(10*2);
//                break;
//            case FONT_12:
//                mTV.setTextSize(12*2);
//                break;
//            case FONT_14:
//                mTV.setTextSize(14*2);
//                break;
//            case FONT_16:
//                mTV.setTextSize(16*2);
//                break;
//            case FONT_18:
//                mTV.setTextSize(18*2);
//                break;
//            case FONT_RED:
//                mTV.setTextColor(Color.RED);
//                break;
//            case FONT_GREEN:
//                mTV.setTextColor(Color.GREEN);
//                break;
//            case FONT_BLUE:
//                mTV.setTextColor(Color.BLUE);
//                break;
//            case PLAIN_ITEM:
//                Toast.makeText(this,"您单击了普通菜单项！",Toast.LENGTH_SHORT).show();
//                break;
//
//        }
//        return true;
//    }
}
