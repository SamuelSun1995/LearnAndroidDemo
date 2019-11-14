package cn.weli.learnandroiddemo.ViewControl.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import cn.weli.learnandroiddemo.R;

public class ActionBarActivity extends AppCompatActivity {

    private ActionBar mActionBar;

    private Button mShowActionBar;
    private Button mHideActionBar;

    private TextView mTvActionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_bar);

        initView();
        onClick();
        setmActionBar();
    }

    public void setmActionBar(){

        //设置是否显示应用程序图标
        mActionBar.setDisplayShowHomeEnabled(true);
        //将应用程序图标设置为可点击按钮，并在图标上添加向左的箭头
        mActionBar.setDisplayHomeAsUpEnabled(true);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        //装填menu到对应菜单中
        getMenuInflater().inflate(R.menu.actionbar_menu,menu);

        return super.onCreateOptionsMenu(menu);
    }

    //菜单被单击后被回调
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //勾选该菜单
        if(item.isCheckable()){
            item.setChecked(true);

        }
        //判断是哪个菜单项并针对性的做出响应
        switch (item.getItemId()){
            case R.id.home:
                //创建启动FirstActivty的Intent
                Intent intent = new Intent(this, FirstActivitty.class);
                //添加额外的Flag,将activity栈中处于FristActivity之上的Activity弹出
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                break;
        }
        return true;
    }

    public void initView(){
        mTvActionBar=findViewById(R.id.tv_actionbar_txt);
        mShowActionBar = findViewById(R.id.show_actionbar);
        mHideActionBar = findViewById(R.id.hide_actionbar);

        //获取该Activity的actionbar
        //只有应用主题没有关闭actionbar才能返回
        mActionBar = getSupportActionBar();
    }

    public void onClick(){

        mShowActionBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mActionBar.show();
            }
        });
        mHideActionBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mActionBar.hide();
            }
        });

    }

}
