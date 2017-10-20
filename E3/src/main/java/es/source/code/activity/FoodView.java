package es.source.code.activity;


/*import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;

import java.util.ArrayList;
import java.util.List;

public class FoodView extends AppCompatActivity  {
    private OneFragment oneFragment;
    private TwoFragment twoFragment;
    private ThreeFragment threeFragment;
    private FouthFragment fouthFragment;
    private android.support.v4.view.ViewPager vp;
    private List<Fragment> mFragmentList = new ArrayList<Fragment>();
    private FragmentAdapter mFragmentAdapter;
    private android.support.design.widget.TabLayout mTableLayout;//是一个可切换的布局
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {//加载menu
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViews();
        setContentView(R.layout.activity_food_view);

        mFragmentAdapter = new FragmentAdapter(this.getSupportFragmentManager(), mFragmentList);
        vp = (ViewPager) this.findViewById(R.id.main_viewpager);

        vp.setOffscreenPageLimit(4);//ViewPager的缓存为4帧
        vp.setAdapter(mFragmentAdapter);
        vp.setCurrentItem(0);//初始设置ViewPager选中第一帧

        mTableLayout = (TabLayout) findViewById(R.id.main_tab);
        mTableLayout.setupWithViewPager(vp);// tab_layout.setupWithViewPager(viewPager);//这两句是将ViewPager和TabLayout联系起来
        mTableLayout.setTabMode(android.support.design.widget.TabLayout.MODE_FIXED);// tab_layout.setTabsFromPagerAdapter(mAdapter); 这三个方法。

    }

     //初始化布局View
    private void initViews() {
        vp = (ViewPager) this.findViewById(R.id.main_viewpager);
        oneFragment = new OneFragment();
        twoFragment = new TwoFragment();
        threeFragment = new ThreeFragment();
        fouthFragment = new FouthFragment();
        //给FragmentList添加数据
        mFragmentList.add(oneFragment);
        mFragmentList.add(twoFragment);
        mFragmentList.add(threeFragment);
        mFragmentList.add(fouthFragment);
    }
    public class FragmentAdapter extends FragmentPagerAdapter {//配适器算法

        List<Fragment> fragmentList = new ArrayList<Fragment>();

        public FragmentAdapter(FragmentManager fm, List<Fragment> fragmentList) {
            super(fm);
            this.fragmentList = fragmentList;
        }
        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }//返回当前Fragment的位置
        @Override
        public int getCount() {
            return fragmentList.size();
        }//返回fragment的大小
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "冷菜";
                case 1:
                    return "热菜";
                case 2:
                    return "海鲜";
                default:
                    return "酒水";
            }
        }
    }
}*/

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.Window;

import java.util.ArrayList;
import java.util.List;

public class FoodView extends AppCompatActivity  {
    private ViewPager vp;
    private OneFragment oneFragment;
    private TwoFragment twoFragment;
    private ThreeFragment threeFragment;
    private FouthFragment fouthFragment;
    private List<Fragment> mFragmentList = new ArrayList<Fragment>();
    private FragmentAdapter mFragmentAdapter;
    private android.support.design.widget.TabLayout mTableLayout;//是一个可切换的布局
    private Toolbar mToolbar;


    //////String[] titles = new String[]{"微信", "通讯录", "发现", "我"};

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {//加载menu
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //去除工具栏
        ////getSupportActionBar().hide();
        requestWindowFeature(Window.FEATURE_CONTEXT_MENU);
        setContentView(R.layout.activity_food_view);

        mToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(mToolbar);



        initViews();
        mFragmentAdapter = new FragmentAdapter(this.getSupportFragmentManager(), mFragmentList);
        vp.setOffscreenPageLimit(4);//ViewPager的缓存为4帧
        vp.setAdapter(mFragmentAdapter);
        vp.setCurrentItem(0);//初始设置ViewPager选中第一帧

        mTableLayout = (TabLayout) findViewById(R.id.main_tab_foodview);
        mTableLayout.setupWithViewPager(vp);// tab_layout.setupWithViewPager(viewPager);//这两句是将ViewPager和TabLayout联系起来
        mTableLayout.setTabMode(android.support.design.widget.TabLayout.MODE_FIXED);// tab_layout.setTabsFromPagerAdapter(mAdapter); 这三个方法。

        ////item_weixin.setTextColor(Color.parseColor("#66CDAA"));

        //ViewPager的监听事件

            /*public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                /*此方法在页面被选中时调用*/
               /* 自己删的title.setText(titles[position]);
                changeTextColor(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                /*此方法是在状态改变的时候调用，其中arg0这个参数有三种状态（0，1，2）。
                arg0 ==1的时辰默示正在滑动，
                arg0==2的时辰默示滑动完毕了，
                arg0==0的时辰默示什么都没做。*/
           /*自己删的 }
        /*自己删的});*/
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
// TODO Auto-generated method stub
        if(item.getItemId() == R.id.menu_under_order){
            Intent intent1=new Intent(FoodView.this,FoodOrderView.class);
            intent1.putExtra("page",1);
            startActivity(intent1);
        }
        else if(item.getItemId() ==R.id.menu_view_order){
            Intent intent2=new Intent(FoodView.this,FoodOrderView.class);
            intent2.putExtra("page",0);
            startActivity(intent2);
        }
        return true;
    }

    /**
     * 初始化布局View
     */
    private void initViews() {
        /*自己删的title = (TextView) findViewById(R.id.title);
        item_weixin = (TextView) findViewById(R.id.item_weixin);
        item_tongxunlu = (TextView) findViewById(R.id.item_tongxunlu);
        item_faxian = (TextView) findViewById(R.id.item_faxian);
        item_me = (TextView) findViewById(R.id.item_me);*/

        /*自己删的item_weixin.setOnClickListener(this);
        item_tongxunlu.setOnClickListener(this);
        item_faxian.setOnClickListener(this);
        item_me.setOnClickListener(this);*/

        vp = (ViewPager) findViewById(R.id.mainViewPager_foodview);
        oneFragment = new OneFragment();
        twoFragment = new TwoFragment();
        threeFragment = new ThreeFragment();
        fouthFragment = new FouthFragment();
        //给FragmentList添加数据
        mFragmentList.add(oneFragment);
        mFragmentList.add(twoFragment);
        mFragmentList.add(threeFragment);
        mFragmentList.add(fouthFragment);
    }

    /**
     * 点击底部Text 动态修改ViewPager的内容
     */
    /*自己删的@Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.item_weixin:
                vp.setCurrentItem(0, true);
                break;
            case R.id.item_tongxunlu:
                vp.setCurrentItem(1, true);
                break;
            case R.id.item_faxian:
                vp.setCurrentItem(2, true);
                break;
            case R.id.item_me:
                vp.setCurrentItem(3, true);
                break;
        }
    }自己删的*/


    public class FragmentAdapter extends FragmentPagerAdapter {//配适器算法

        List<Fragment> fragmentList = new ArrayList<Fragment>();

        public FragmentAdapter(FragmentManager fm, List<Fragment> fragmentList) {
            super(fm);
            this.fragmentList = fragmentList;
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }//返回当前Fragment的位置

        @Override
        public int getCount() {
            return fragmentList.size();
        }//返回fragment的大小

        ////////////////////////////自己加的
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "冷菜";
                case 1:
                    return "热菜";
                case 2:
                    return "海鲜";
                default:
                    return "酒水";
            }
        }

    }

    /*
     *由ViewPager的滑动修改底部导航Text的颜色
     */

}






