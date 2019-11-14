package cn.weli.learnandroiddemo.ViewControl.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import cn.weli.learnandroiddemo.R;

public class ActionViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_view);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        //装填menu到对应菜单中
        getMenuInflater().inflate(R.menu.actionbarview_menu,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.search:
                Toast.makeText(ActionViewActivity.this,"点击了搜索按钮！",Toast.LENGTH_SHORT).show();
                break;
            case R.id.progress:

                break;
        }
        return true;
    }
}
