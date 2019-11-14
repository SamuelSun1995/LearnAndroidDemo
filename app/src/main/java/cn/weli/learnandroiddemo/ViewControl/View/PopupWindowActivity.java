package cn.weli.learnandroiddemo.ViewControl.View;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

import cn.weli.learnandroiddemo.R;

public class PopupWindowActivity extends AppCompatActivity {

    private Button mUpPopupWindow;
    private View root;
    private PopupWindow popupWindow;

    private Button mBtnDatePicker;
    private Button mBtnTiemPicker;
    private Button mBtnProgress;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_window);

        mUpPopupWindow = findViewById(R.id.up_popupwindow);
        mBtnDatePicker =findViewById(R.id.date_picker);
        mBtnTiemPicker = findViewById(R.id.time_picker);
        mBtnProgress =findViewById(R.id.progress_dialog);



        mBtnProgress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 progressDialog = new ProgressDialog(PopupWindowActivity.this,1);
                //设置对话框里面不显示进度值
                progressDialog.setIndeterminate(false);
                //设置进度框里面的最大值
                progressDialog.setMax(100);
                progressDialog.setMessage("进度条对话框");
                //设置进度框里面的进度值
                new Thread(){
                    @Override
                    public void run() {
                        super.run();
                        int i=1;
                        while(i<=100){
                        progressDialog.setProgress(i);
                            try {
                                Thread.sleep(100);
                                i++;
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        progressDialog.dismiss();
                    }
                }.start();

                progressDialog.setProgressStyle(1);
                progressDialog.show();

            }
        });


        mBtnDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                //直接绑定一个DatePickerDialog对话框实例并将它显示出来
                 new DatePickerDialog(PopupWindowActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        Toast.makeText(PopupWindowActivity.this,"您选择了："+year+"年"+month+"月"+dayOfMonth+"日",Toast.LENGTH_SHORT).show();
                    }
                },
                         calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)         //设置初始日期
                 ).show();
            }
        });


        mBtnTiemPicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                //创建一个TimePicker并显示出来
                new TimePickerDialog(PopupWindowActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        Toast.makeText(PopupWindowActivity.this,"您选择了："+hourOfDay+"时"+minute+"分钟",Toast.LENGTH_SHORT).show();
                    }
                },
                        calendar.get(Calendar.HOUR_OF_DAY),calendar.get(Calendar.MINUTE)        //设置初始时间
                        ,true).show();
            }
        });


        //加载popupwindow布局
        root = getLayoutInflater().inflate(R.layout.popup, null);
        popupWindow = new PopupWindow(root, 560, 720);

        mUpPopupWindow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //以下拉的方式显示
                popupWindow.showAsDropDown(v);
                //将popupwindow显示在指定位置
                popupWindow.showAtLocation(mUpPopupWindow, Gravity.CENTER, 20, 20);
                //获取popupwindow自己拍卖行的“关闭”按钮，并绑定事件监听器
                root.findViewById(R.id.pop_cancel).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popupWindow.dismiss();
                    }
                });
            }
        });
    }
}
