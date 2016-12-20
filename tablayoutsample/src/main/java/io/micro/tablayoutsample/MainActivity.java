package io.micro.tablayoutsample;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 使用方式1:

        // 代码控制Tab
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.addTab(tabLayout.newTab().setText("Tab1"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab2").setIcon(R.mipmap.ic_launcher));
        // 自定义Tab的布局
        TabLayout.Tab customTab = tabLayout.newTab();
        TextView textView = new TextView(this);
        textView.setText("custom");
        textView.setBackgroundColor(Color.RED);
        textView.setTextColor(Color.BLUE);
        customTab.setCustomView(textView);
        tabLayout.addTab(customTab);


        // 使用方式2:
        // 和ViewPager搭配使用
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        mTitles = getResources().getStringArray(R.array.tabTitles);
        mFragmentList = new ArrayList<>();
        mFragmentList.add(MyFragment.newInstance(0));
        mFragmentList.add(MyFragment.newInstance(1));

        viewPager.setAdapter(new TabPagerAdapter(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);
    }

    private String[] mTitles;
    private List<Fragment> mFragmentList;

    private class TabPagerAdapter extends FragmentPagerAdapter {
        public TabPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        // 获取对应的Tab Title
        public CharSequence getPageTitle(int position) {
            return mTitles[position];
        }

        // 返回对应位置的Fragment
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        // 返回Tab的个数,也是ViewPager的页数
        public int getCount() {
            return mFragmentList.size();
        }
    }
}
