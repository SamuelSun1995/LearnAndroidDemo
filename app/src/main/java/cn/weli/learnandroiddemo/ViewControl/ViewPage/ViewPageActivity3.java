package cn.weli.learnandroiddemo.ViewControl.ViewPage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import cn.weli.learnandroiddemo.R;
import cn.weli.learnandroiddemo.ViewControl.ViewPage.Fragment.Fragment1;
import cn.weli.learnandroiddemo.ViewControl.ViewPage.Fragment.Fragment2;
import cn.weli.learnandroiddemo.ViewControl.ViewPage.Fragment.Fragment3;

public class ViewPageActivity3 extends AppCompatActivity {

    private FragmentPagerAdapter mFragmentPagerAdapter;
    private List<Fragment> mFragmentList;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_page3);

        //fragment清单
        mFragmentList= new ArrayList<Fragment>();
        mFragmentList.add(new Fragment1());
        mFragmentList.add(new Fragment2());
        mFragmentList.add(new Fragment3());
        //构造适配器
        MyViewPageAdapter adapter = new MyViewPageAdapter(getSupportFragmentManager(), mFragmentList);
        mViewPager = findViewById(R.id.viewpage3);
        //设置设配器
        mViewPager.setAdapter(adapter);

    }




}
