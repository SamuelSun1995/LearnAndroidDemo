package cn.weli.learnandroiddemo.ViewControl.ViewPage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import cn.weli.learnandroiddemo.R;

public class ViewPageActivity1 extends AppCompatActivity {

    private PagerAdapter mPageAdapter;
    private List<View> mViewList;
    private List<String> mTitleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_page);
        mViewList = new ArrayList<>();
        LayoutInflater inflater = getLayoutInflater();
        View view1 = inflater.inflate(R.layout.viewpage_layout1, null);
        View view2 = inflater.inflate(R.layout.viewpage_layout2, null);
        View view3 = inflater.inflate(R.layout.viewpage_layout3, null);
        mViewList.add(view1);
        mViewList.add(view2);
        mViewList.add(view3);
        ViewPager mViewpage = findViewById(R.id.viewpage);

        //viewpage标题
        mTitleList = new ArrayList<String>();
        mTitleList.add("语文");
        mTitleList.add("数学");
        mTitleList.add("英语");

        //初始化adapter
        initPageAdapter();
        mViewpage.setAdapter(mPageAdapter);
    }

    public void initPageAdapter(){
        mPageAdapter = new PagerAdapter() {
            @Override
            public int getCount() {
                return mViewList.size();
            }


            //该函数用来判断instantiateItem(ViewGroup, int)函数所返回来的Key与一个页面视图是否是代表的同一个视图(即它俩是否是对应的，对应的表示同一个View)

            /**
             *
             * @param view
             * @param object 与instantiateItem，return值类型一致
             * @return 是否为统一视图
             */
            @Override
            public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
                return view == object;      //重要
            }

            @Override
            public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
                container.removeView(mViewList.get(position));  //移除指定位置的view
            }

            //绑定并且返回View
            @NonNull
            @Override
            public Object instantiateItem(@NonNull ViewGroup container, int position) {
                container.addView(mViewList.get(position));
                return mViewList.get(position);  //可以指定唯一layout的标识
            }

            //获取标题
            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {

                SpannableStringBuilder ssb = new SpannableStringBuilder("  " + mTitleList.get(position));   //space added before text

                Drawable mDrawable = getResources().getDrawable(R.mipmap.ic_launcher);
                mDrawable.setBounds(0,0,mDrawable.getIntrinsicWidth(),mDrawable.getIntrinsicHeight());

                ImageSpan imageSpan = new ImageSpan(mDrawable, ImageSpan.ALIGN_BASELINE);

                ForegroundColorSpan fcs = new ForegroundColorSpan(Color.GREEN);     //字体颜色设置为绿色
                ssb.setSpan(imageSpan,0,1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE); //设置图标
                ssb.setSpan(fcs,1,ssb.length(),Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);     //设置字体颜色
                return ssb;
            }


        };
    }
}
