package cn.weli.learnandroiddemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;

import cn.weli.learnandroiddemo.Animation.AnimationActivity;
import cn.weli.learnandroiddemo.Communication.IntentActivity;
import cn.weli.learnandroiddemo.DataStorage.DataStoreMainActivity;
import cn.weli.learnandroiddemo.Event.EventActivity;
import cn.weli.learnandroiddemo.FourMajorComponents.FourMainActivity;
import cn.weli.learnandroiddemo.Resource.ResActivity;
import cn.weli.learnandroiddemo.ViewControl.ViewActivity;

public class RealMainActivity extends AppCompatActivity {

    private Button mBtnFour;
    private Button mStore;
    private Button mViewCon;
    private Button mBtnEvent;
    private Button mBtnContact;
    private Button mBtnRes;
    private Button mBtnAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_real_main);

        bindView();
        onClick();


    }

    public void bindView() {
        mStore = findViewById(R.id.store);
        mBtnFour = findViewById(R.id.four_comp);
        mViewCon = findViewById(R.id.view_control);

        mBtnEvent = findViewById(R.id.event);
        mBtnContact = findViewById(R.id.intent_and_intentfilter);
        mBtnRes = findViewById(R.id.res);
        mBtnAnim =findViewById(R.id.btn_anim_enter);
    }

    public void onClick() {


        mBtnFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RealMainActivity.this, FourMainActivity.class);
                startActivity(intent);
            }
        });
        mStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RealMainActivity.this, DataStoreMainActivity.class);
                startActivity(intent);
            }
        });
        mViewCon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RealMainActivity.this, ViewActivity.class);
                startActivity(intent);
            }
        });

        mBtnEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RealMainActivity.this, EventActivity.class);
                startActivity(intent);
            }
        });

        mBtnContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RealMainActivity.this, IntentActivity.class);
                startActivity(intent);
            }
        });

        mBtnRes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RealMainActivity.this, ResActivity.class);
                startActivity(intent);
            }
        });

        mBtnAnim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RealMainActivity.this, AnimationActivity.class);
                startActivity(intent);
            }
        });
    }
}
