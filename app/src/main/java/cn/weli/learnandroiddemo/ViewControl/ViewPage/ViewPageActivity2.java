package cn.weli.learnandroiddemo.ViewControl.ViewPage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import cn.weli.learnandroiddemo.R;

public class ViewPageActivity2 extends AppCompatActivity {

    private List<View> mViewList;
    private ViewPager mViewPager;
    private PagerAdapter mPageAdapter;
    private ViewPager.OnPageChangeListener mPageChangeListener;

    private ImageView mImageView;

    private int bmpw = 0;    //游标宽度
    private int offset = 0;   //动画图片偏移量
    private int currIndex = 0;    //当前页卡编号

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_page2);

        initView();

        //初始化指示器位置
        initCusorPos();

        initPageAdapter();
        //设置adapter
        mViewPager.setAdapter(mPageAdapter);
        initPageChangeListener();
        mViewPager.setOnPageChangeListener(mPageChangeListener);
    }

    public void initView() {

        mViewPager = findViewById(R.id.viewpage2);
        LayoutInflater layoutInflater = getLayoutInflater();
        View view1 = layoutInflater.inflate(R.layout.viewpage_layout1, null);
        View view2 = layoutInflater.inflate(R.layout.viewpage_layout2, null);
        View view3 = layoutInflater.inflate(R.layout.viewpage_layout3, null);

        mImageView = findViewById(R.id.img_cursor);

        mViewList = new ArrayList<View>();
        mViewList.add(view1);
        mViewList.add(view2);
        mViewList.add(view3);

    }

    public void initPageAdapter() {
        mPageAdapter = new PagerAdapter() {
            @Override
            public int getCount() {
                return mViewList.size();
            }

            @Override
            public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
                return view == mViewList.get((Integer) object);
            }

            @NonNull
            @Override
            public Object instantiateItem(@NonNull ViewGroup container, int position) {
                container.addView(mViewList.get(position));
                return position;
            }

            @Override
            public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
                container.removeView(mViewList.get(position));
            }
        };
    }

    public void initCusorPos() {
        //获取图片宽度
        bmpw = BitmapFactory.decodeResource(getResources(), R.drawable.slider).getWidth();

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int screenW = dm.widthPixels;   //获取分辨率宽度
        offset = (screenW / mViewList.size() - bmpw) / 2;   //计算偏移量

        Matrix matrix = new Matrix();
        matrix.postTranslate(offset, 0);
        mImageView.setImageMatrix(matrix);  //设置动画初始位置
    }

    public void initPageChangeListener() {

        final int one = offset * 2 + bmpw;
        final int two = one * 2;

        mPageChangeListener = new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Animation animation = null;
                switch (position) {
                    case 0:
                        if (currIndex == 1) {
                            animation = new TranslateAnimation(one, 0, 0, 0);
                        } else if (currIndex == 2) {
                            animation = new TranslateAnimation(two, 0, 0, 0);
                        }

                        break;
                    case 1:
                        if (currIndex == 0) {
                            animation = new TranslateAnimation(offset, one, 0, 0);

                        } else if (currIndex == 2) {
                            animation = new TranslateAnimation(two, one, 0, 0);
                        }
                        break;
                    case 2:
                        if (currIndex == 0) {
                            animation = new TranslateAnimation(offset, two, 0, 0);
                        } else if (currIndex == 1) {
                            animation = new TranslateAnimation(one, two, 0, 0);
                        }
                        break;

                }
                currIndex = position;
                animation.setFillAfter(true);   //true 图片停在动画结束位置
                animation.setDuration(300);
                mImageView.startAnimation(animation);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        };
    }
}
