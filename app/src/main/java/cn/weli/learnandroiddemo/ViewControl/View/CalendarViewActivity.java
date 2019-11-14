package cn.weli.learnandroiddemo.ViewControl.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.NumberPicker;
import android.widget.Toast;

import cn.weli.learnandroiddemo.R;

public class CalendarViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_view);
        CalendarView mCalendarView = findViewById(R.id.calendarview);
        mCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                Toast.makeText(CalendarViewActivity.this,"您的生日为："+year+"-"+month+"-"+dayOfMonth,Toast.LENGTH_SHORT).show();
            }
        });

        NumberPicker mNumberPicker = findViewById(R.id.numpick);
        mNumberPicker.setMaxValue(100);
        mNumberPicker.setMinValue(0);
        mNumberPicker.setValue(20);
        mNumberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                Toast.makeText(CalendarViewActivity.this,"当前的值为："+newVal,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
