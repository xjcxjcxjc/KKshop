package com.example.kkshop;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.kkshop.Base.BaseActivity;
import com.example.kkshop.Utils.ViewUtil;
import com.example.kkshop.View.CategoryFragment;
import com.example.kkshop.View.HomeFragment;
import com.example.kkshop.View.MineFragment;
import com.example.kkshop.View.ShopFragment;
import com.example.kkshop.View.ViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements ViewPager.OnPageChangeListener, RadioGroup.OnCheckedChangeListener {
    private HomeFragment homeFragment;
    private CategoryFragment categoryFragment;
    private ShopFragment shopFragment;
    private MineFragment mineFragment;
    private ViewUtil viewUtil;

    RadioGroup rg;
    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;
    List<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initViewPager();

    }

    private void initView(){

        viewUtil=ViewUtil.Instance();
        //设置状态栏上的图标颜色是否为黑色
        viewUtil.changeStatusBarTextImgColor(true,this);

        rg=findViewById(R.id.rg);
        viewPager=findViewById(R.id.viewpager);
    }

    private void initViewPager() {
        fragments=new ArrayList<>();
        homeFragment =new HomeFragment();
        categoryFragment =new CategoryFragment();
        shopFragment =new ShopFragment();
        mineFragment =new MineFragment();

        fragments.add(homeFragment);
        fragments.add(categoryFragment);
        fragments.add(shopFragment);
        fragments.add(mineFragment);
        viewPagerAdapter=new ViewPagerAdapter(getSupportFragmentManager(),fragments);
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.addOnPageChangeListener(this);
        //默认选中第一个
        rg.check(R.id.rb_1);
        rg.setOnCheckedChangeListener(this);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {
        switch (position){
            case 0:
                rg.check(R.id.rb_1);
                break;
            case 1:
                rg.check(R.id.rb_2);
                break;
            case 2:
                rg.check(R.id.rb_3);
                break;
            case 3:
                rg.check(R.id.rb_4);
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.rb_1:
                viewPager.setCurrentItem(0);
                break;
            case R.id.rb_2:
                viewPager.setCurrentItem(1);
                break;
            case R.id.rb_3:
                viewPager.setCurrentItem(2);
                break;
            case R.id.rb_4:
                viewPager.setCurrentItem(3);
                break;
        }
    }
}

