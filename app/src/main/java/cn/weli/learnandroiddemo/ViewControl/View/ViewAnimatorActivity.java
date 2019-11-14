package cn.weli.learnandroiddemo.ViewControl.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ViewSwitcher;

import java.util.ArrayList;

import cn.weli.learnandroiddemo.R;

public class ViewAnimatorActivity extends AppCompatActivity {

    //定义一个常量，用于显示每屏显示的应用程序数
    public static final int NUMBER_PER_SCREEN = 12;
    //保存系统所有应用程序的List集合
//    private List<DayaItem> items = new ArrayList<>();
    //记录当前显示第几个屏幕的程序
    private int screenNo = -1;
    //保存屏幕所占的总屏数
    private int screenCount = 0;

    private ViewSwitcher mViewSwitcher;

    //创建LayoutInflater对象
    private LayoutInflater mInflater;
    //该BaseAdapter负责为每屏显示的GridView提供列表项
    private BaseAdapter adapter =new BaseAdapter() {

        @Override
        public int getCount() {
            //如果已经到了最后一屏幕，且应用程序的数量不能整除每屏幕的应用程序数
//            if(screenNo == screenCount-1&& items.size()%  NUMBER_PER_SCREEN!=0){
//
//            }
            return 0;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            return null;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_animator);
    }

    public void prev(View view) {
    }

    public void next(View view) {
    }
}
