package cn.weli.learnandroiddemo.Resource;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Telephony;
import android.view.View;
import android.widget.Button;

import cn.weli.learnandroiddemo.Animation.PropertyAnimationActivity;
import cn.weli.learnandroiddemo.R;

public class ResActivity extends AppCompatActivity {
    private Button mBtnShowEdit;
    private Button mBtnCus;
    private Button mBtnShape;
    private Button mBtnClip;
    private Button mBtnAnimation;
    private Button mBtnAnim;
    private Button mBtnXml;
    private Button mBtnStyleAndTheme;
    private Button mBtnAttribute;
    private Button mBtnUseOri;
    private Button mBtnInternational;
    private Button mBtnPhoneInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_res);
        mBtnShowEdit = findViewById(R.id.show_edit);
        mBtnCus = findViewById(R.id.btn_cus_img_bar);
        mBtnShape = findViewById(R.id.btn_shapedrawable);
        mBtnClip = findViewById(R.id.btn_clipdrawable);
        mBtnAnimation = findViewById(R.id.btn_animationdrawable);
        mBtnAnim = findViewById(R.id.btn_anim);
        mBtnXml = findViewById(R.id.btn_xml);
        mBtnStyleAndTheme = findViewById(R.id.btn_styleandtheme);
        mBtnInternational = findViewById(R.id.btn_international);
        mBtnAttribute = findViewById(R.id.btn_attribute);
        mBtnUseOri = findViewById(R.id.btn_ori);
        mBtnPhoneInfo = findViewById(R.id.btn_req_phoneInfo);

        mBtnPhoneInfo.setOnClickListener((v) -> {
            Intent intent = new Intent(ResActivity.this, TelephonyActivity.class);
            startActivity(intent);
        });

        mBtnShowEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResActivity.this, ResEditActivity.class);
                startActivity(intent);
            }
        });

        mBtnCus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResActivity.this, LayerDrawableActivity.class);
                startActivity(intent);
            }
        });

        mBtnShape.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResActivity.this, ShapeDrawableActivity.class);
                startActivity(intent);
            }
        });

        mBtnClip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResActivity.this, ClipDrawableActivity.class);
                startActivity(intent);
            }
        });

        mBtnAnimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResActivity.this, AnimationDrawableActivity.class);
                startActivity(intent);
            }
        });

        mBtnAnim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResActivity.this, PropertyAnimationActivity.class);
                startActivity(intent);
            }
        });
        mBtnXml.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResActivity.this, XmlActivity.class);
                startActivity(intent);
            }
        });

        mBtnStyleAndTheme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResActivity.this, StyleAndThemeActivity.class);
                startActivity(intent);
            }
        });

        mBtnAttribute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResActivity.this, AttributeActivity.class);
                startActivity(intent);
            }
        });

        mBtnUseOri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResActivity.this, UseOriActivity.class);
                startActivity(intent);
            }
        });
        mBtnInternational.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResActivity.this, InternationalActivity.class);
                startActivity(intent);
            }
        });
    }
}
