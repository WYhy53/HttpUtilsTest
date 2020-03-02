package com.coolweather.httputilstest;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.net.URL;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class HttpUtils  {
    final private String ERROR01 = "请求失败！";
    final private String ERROR02 = "请求异常！";
   // private OnHttpUrlLisent onHttpUrlLisent;
    private static HttpUtils httpUtils = new HttpUtils();
    private HttpUtils() {
    }

    public static HttpUtils getHttpUtils() {
        if (httpUtils == null) {
            httpUtils = new HttpUtils();
        }
        return httpUtils;
    }
    public void get(URL url){
        AsyncTask1 asyncTask1=new AsyncTask1();
        asyncTask1.dosomething(url);
        asyncTask1.customThreadPool();
    }


//一个封装了的内部类
    static class AsyncTask1{
        //handler
    final Handler handler=new Handler(Looper.getMainLooper()){
        @Override
        public void handleMessage(Message msg){
            super.handleMessage(msg);
            switch (msg.what){
                case 1:
                    Log.d("this","请求成功！更新UI");
                    //具体操作
                    break;
            }
        }
    };
    protected void dosomething(final URL url) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setConnectTimeout(5000);
                    connection.setReadTimeout(5000);
                    int code = connection.getResponseCode();
                    if (code == 200) {
                        InputStream inputStream = connection.getInputStream();
                        InputStreamReader streamReader = new InputStreamReader(inputStream);
                        BufferedReader reader = new BufferedReader(streamReader);
                        StringBuilder builder = new StringBuilder();
                        String s = "";
                        while ((s = reader.readLine()) != null) {
                            builder.append(s);
                        }
                        Message msg = Message.obtain();
                        msg.what = 1;
                        handler.sendMessage(msg);
                        streamReader.close();
                        reader.close();
                        //  return builder.toString();
                        Log.d("thiswwwwwwwwwwwwwwwwww", builder.toString());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
    //线程池
        public void customThreadPool() {
            final MyThreadPool myThreadPool = new MyThreadPool(3, 5,
                    1, TimeUnit.MINUTES, new LinkedBlockingDeque<Runnable>());
            for (int i = 0; i < 10; i++) {
                final int finalI = i;
                Runnable runnable = new Runnable(){
                    @Override
                    public void run() {
                        SystemClock.sleep(100);
                        Log.d("google_lenve_fb", "run: " + finalI);
                    }
                };
                myThreadPool.execute(runnable);
            }
        }
        class MyThreadPool extends ThreadPoolExecutor {
            public MyThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime,
                                TimeUnit unit, BlockingDeque<Runnable> workQueue) {
                super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
            }

            @Override
            protected void beforeExecute(Thread t, Runnable r) {
                super.beforeExecute(t, r);
                Log.d("google_lenve_fb", "beforeExecute: 开始执行任务！");
            }

            @Override
            protected void afterExecute(Runnable r, Throwable t) {
                super.afterExecute(r, t);
                Log.d("google_lenve_fb", "afterExecute: 任务执行结束！");
            }

            @Override
            protected void terminated() {
                super.terminated();
                Log.d("google_lenve_fb", "terminated: 线程池关闭！");
            }

        }
    }
}
