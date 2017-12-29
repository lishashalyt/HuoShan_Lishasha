package com.bawei.hslss.huoshan_lishasha;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    int time=3;
    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                time--;
                if(time==0){
                  /*欢迎页面，倒计时跳转*/
                    Intent intent = new Intent(MainActivity.this,LiveVedioActivity.class);
                    startActivity(intent);
                    return;
                }
                handler.postDelayed(this,1000);
            }
        },1000);
    }
    }

