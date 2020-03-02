package com.coolweather.httputilstest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.Nullable;

import android.nfc.Tag;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

import java.net.URL;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HttpUtils httpUtils = HttpUtils.getHttpUtils();
        try {
            URL url=new URL("https://www.baidu.com");
            httpUtils.get(url);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

