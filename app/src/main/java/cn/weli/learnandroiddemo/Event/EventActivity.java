package cn.weli.learnandroiddemo.Event;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import cn.weli.learnandroiddemo.Event.Activity.HandlerActivity;
import cn.weli.learnandroiddemo.Event.AsyncTask.AsyncTaskActivity;
import cn.weli.learnandroiddemo.Event.Listener.PlaneActivity;
import cn.weli.learnandroiddemo.R;

public class EventActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnControlPlane;
    private Button mBtnAutoPlay;

    private Button mBtnAsyncTask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);


        bindView();
        setListener();
    }

    public void bindView() {
        mBtnControlPlane = findViewById(R.id.control_plane);
        mBtnAutoPlay = findViewById(R.id.auto_play);
        mBtnAsyncTask = findViewById(R.id.btn_asynctask);

    }

    public void setListener() {
        mBtnControlPlane.setOnClickListener(this);
        mBtnAutoPlay.setOnClickListener(this);
        mBtnAsyncTask.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.control_plane:
                Intent intent_plane = new Intent(this, PlaneActivity.class);
                startActivity(intent_plane);
                break;
            case R.id.auto_play:
                Intent intent_auto_play = new Intent(this, HandlerActivity.class);
                startActivity(intent_auto_play);
                break;
            case R.id.btn_asynctask:
                Intent intent_AsyncTask = new Intent(this, AsyncTaskActivity.class);
                startActivity(intent_AsyncTask);
                break;

        }
    }
}
