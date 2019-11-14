package cn.weli.learnandroiddemo.ViewControl.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import cn.weli.learnandroiddemo.R;

public class ToastActivity extends AppCompatActivity {

    private TextView mTvToast;
    private Button mBtnToast;
    private LinearLayout mLl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);

//        mLl = new LinearLayout(this);
//        mTvToast = findViewById(R.id.tv_toast);
        mBtnToast = findViewById(R.id.btn_cus_toast);


        mBtnToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = new Toast(ToastActivity.this);
                LinearLayout ll = new LinearLayout(ToastActivity.this);
                ImageView imageView = new ImageView(ToastActivity.this);
                imageView.setImageResource(R.mipmap.ic_launcher);
                TextView textView = new TextView(ToastActivity.this);
                textView.setText("带图片的Toast！");
                ll.addView(imageView);
                ll.addView(textView);
//                mTvToast.setText("点击自定义Toast！");
                toast.setGravity(Gravity.CENTER,0,0);
                toast.setView(ll);
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }
}
