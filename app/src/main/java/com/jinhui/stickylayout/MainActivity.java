package com.jinhui.stickylayout;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * https://github.com/gm365066360/FlingBehavior
 * 反编译简书app和小红书app滑动效果sticky粘性头布局的实现CoordinatorLayout+behavior+CollapsingToolbarLayout
 */
public class MainActivity extends AppCompatActivity {


    ViewPager viewpager;
    TabLayout tablayout_user;

    List<Fragment> fragments = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewpager = ( ViewPager) findViewById(R.id.viewpager);
        tablayout_user = ( TabLayout) findViewById(R.id.tablayout_user);

        fragments.add(AFragment.newInstance("1", "0"));
        fragments.add(BFragment.newInstance("2", "0"));

        FragAdapter fragmentPagerAdapter = new FragAdapter(getSupportFragmentManager(), fragments);
        viewpager.setAdapter(fragmentPagerAdapter);
        tablayout_user.setupWithViewPager(viewpager);
    }

    public class FragAdapter extends FragmentPagerAdapter{

        String[] titles = new String[]{"动态", "文章" };
        private List<Fragment> mFragments;

        public FragAdapter(FragmentManager fm, List<Fragment> fragments) {
            super(fm);
            mFragments = fragments;
        }

        @Override
        public Fragment getItem(int i) {
            return mFragments.get(i);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return this.titles[position];
        }
    }
}
