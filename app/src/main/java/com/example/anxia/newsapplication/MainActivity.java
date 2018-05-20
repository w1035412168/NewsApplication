package com.example.anxia.newsapplication;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.example.anxia.newsapplication.fragment.FindFragment;
import com.example.anxia.newsapplication.fragment.MainFragment;
import com.example.anxia.newsapplication.fragment.MeFragment;
import com.example.anxia.newsapplication.fragment.MessageFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements BottomNavigationBar
        .OnTabSelectedListener {
    private BottomNavigationBar bottomNavigationBar;
    private List<Fragment> fragmentList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        init();

    }

    private void init() {
        fragmentList=new ArrayList<>();
        fragmentList.add(new MainFragment());
        fragmentList.add(new FindFragment());
        fragmentList.add(new MessageFragment());
        fragmentList.add(new MeFragment());

        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.drawable.nav_circle_selector,"动态"))
                .addItem(new BottomNavigationItem(R.drawable.nav_find_selector,"查找"))
                .addItem(new BottomNavigationItem(R.drawable.nav_message_selector,"消息"))
                .addItem(new BottomNavigationItem(R.drawable.nav_me_selector,"我的"))
                .setMode(BottomNavigationBar.MODE_FIXED)
                .initialise();
        bottomNavigationBar.setTabSelectedListener(this);
        setFragment(0);
    }

    private void initView() {
        bottomNavigationBar=findViewById(R.id.bottom_navigation_bar);

    }

    @Override
    public void onTabSelected(int position) {
       setFragment(position);
    }

    private void setFragment(int position) {
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.main_container,fragmentList.get(position))
                .commit();
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }
}
