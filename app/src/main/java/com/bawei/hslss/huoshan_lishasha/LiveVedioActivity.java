package com.bawei.hslss.huoshan_lishasha;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class LiveVedioActivity extends AppCompatActivity {

    private ViewPager mViewPager02;
    private ViewPagerIndicate mIndicate02;
    private int[] mTextColors = {0xFFA0A0A0, 0xFF000000};
    private int mUnderlineColor = 0xFF168EFF;
    private String[] mTitles = new String[] {
            "直播", "视频"
    };
    private ArrayList<TextView> mTextViews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_vedio);
        initViewPgaer();
        initViewPagerIndicate();
    }
    private void initViewPgaer() {
        mTextViews = new ArrayList<TextView>();
        for (int i = 0; i < mTitles.length; i++) {
            TextView tv = new TextView(this);
            tv.setGravity(Gravity.CENTER);
            tv.setText(mTitles[i]);
            mTextViews.add(tv);
        }
        mViewPager02 = (ViewPager) findViewById(R.id.viewPager02);
        mViewPager02.setAdapter(new PagerAdapter() {
            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                TextView tv = mTextViews.get(position);
                container.addView(tv);
                return tv;
            }

            @Override
            public void destroyItem(ViewGroup container, int position,
                                    Object object) {
                container.removeView(mTextViews.get(position));
            }

            @Override
            public boolean isViewFromObject(View arg0, Object arg1) {
                return arg0 == arg1;
            }

            @Override
            public int getCount() {
                return mTextViews.size();
            }
        });
    }

    private void initViewPagerIndicate() {
        mIndicate02 = (ViewPagerIndicate) findViewById(R.id.indicate02);
        //设置标签样式、文本和颜色
        mIndicate02.resetText(R.layout.layout_text_indicata02, mTitles, mTextColors);
        //设置下划线粗细和颜色
        mIndicate02.resetUnderline(4, mUnderlineColor);
        //设置ViewPager
        mIndicate02.resetViewPager(mViewPager02);
        //设置初始化完成
        mIndicate02.setOk();
    }
}
