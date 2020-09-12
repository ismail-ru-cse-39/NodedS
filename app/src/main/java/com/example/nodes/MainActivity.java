package com.example.nodes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

   private Toolbar mToolbar;
   private ViewPager mViewPager;
   private TabLayout mTablLayout;
   private TabAccessorAdopter mTabAccesorAdopter;
   private FirebaseUser currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = (Toolbar) findViewById(R.id.main_page_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("NodedS");

        mViewPager = (ViewPager) findViewById(R.id.main_tabs_pager);
        mTabAccesorAdopter = new TabAccessorAdopter(getSupportFragmentManager());
        mViewPager.setAdapter(mTabAccesorAdopter);

        mTablLayout = (TabLayout) findViewById(R.id.main_tabs);
        mTablLayout.setupWithViewPager(mViewPager);
    }

    @Override
    protected void onStart() {
        super.onStart();
        
        if(currentUser == null) {
            sendUserToLoginActicity();
        }
    }

    private void sendUserToLoginActicity() {
        Intent loginIntent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(loginIntent);
    }
}