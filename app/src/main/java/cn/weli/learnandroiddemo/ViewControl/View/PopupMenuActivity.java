package cn.weli.learnandroiddemo.ViewControl.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

import cn.weli.learnandroiddemo.R;

public class PopupMenuActivity extends AppCompatActivity {

    private Button mBtnPopupMenu;
    private PopupMenu mPopupMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_menu);
        mBtnPopupMenu = findViewById(R.id.popupmenu);
        //创建PopMenu对象
        mPopupMenu = new PopupMenu(this, mBtnPopupMenu);
        //将R.menu.popupmenu菜单资源加载到popup菜单中
        getMenuInflater().inflate(R.menu.popup_menu, mPopupMenu.getMenu());
        //为popup菜单的菜单项单击事件绑定时监听器
        mPopupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                switch (item.getItemId()){
                    //隐藏该对话框
                    case R.id.hide:
                        mPopupMenu.dismiss();
                        break;
                        default:
                            Toast.makeText(PopupMenuActivity.this,"您单击了【"+item.getTitle()+"】菜单项",Toast.LENGTH_SHORT).show();
                            break;
                }

                return true;
            }
        });

        mBtnPopupMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPopupMenu.show();
            }
        });

    }


}
