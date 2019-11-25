package cn.weli.learnandroiddemo.Event.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cn.weli.learnandroiddemo.Event.Activity.presenter.HandlerPresenter;
import cn.weli.learnandroiddemo.Event.Activity.view.IHandlerView;
import cn.weli.learnandroiddemo.R;

public class HandlerActivity extends AppCompatActivity implements IHandlerView {

    private final static String UPPER_NUM = "upper";


    private EditText mEdNum;
    private Button mBtnCalculate;

    private CalThread mCalThread;

    private HandlerPresenter mPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_play_animation);
        mEdNum = findViewById(R.id.ed_handler);
        mBtnCalculate = findViewById(R.id.btn_handler);
        mCalThread = new CalThread();
        mPresenter = new HandlerPresenter(this);
        //启动新线程
        new Thread(mCalThread).start();


        //按钮点击事件
        mBtnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //创建消息
                Message msg = new Message();
                msg.what = 0x123;
                Bundle bundle = new Bundle();
                bundle.putInt(UPPER_NUM, Integer.parseInt(mEdNum.getText().toString().trim()));
                msg.setData(bundle);
                //向新线程发送消息
                mCalThread.mHandler.sendMessage(msg);
            }
        });


        mPresenter.initData();
    }

    @Override
    public void initDataResult(int data) {
        mEdNum.setText(String.valueOf(data));
    }


    class CalThread implements Runnable {
        private Handler mHandler;

        @Override
        public void run() {
            Looper.prepare();
            mHandler = new Handler() {
                //定义处理消息的方法
                @Override
                public void handleMessage(@NonNull Message msg) {

                    if (msg.what == 0x123) {

                        int upper = msg.getData().getInt(UPPER_NUM);
                        List<Integer> nums = new ArrayList<Integer>();
                        //从2开始、到upper的所有质数
                        outer:
                        for (int i = 2; i <= upper; i++) {
                            //用i除以从2开始、到i的平方根的所有数
                            int j = 2;
                            while (j <= Math.sqrt(i)) {
                                //如果可以整除，则表明这个数不是质数
                                if (i != 2 && i % j == 0) {
                                    continue outer;
                                }
                                j++;
                            }
                            nums.add(i);
                        }
                        //使用Toast显示统计出来的所有质数
                        Toast.makeText(HandlerActivity.this, nums.toString(), Toast.LENGTH_SHORT).show();
                    }

                }
            };
            Looper.loop();
        }
    }
}
