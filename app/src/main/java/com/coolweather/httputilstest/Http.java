package com.coolweather.httputilstest;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Http {
//    public class HttpUtils  {
//        StringBuilder builder;
//        private static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
//        private static final int CORE_POOL_SIZE = CPU_COUNT + 1;
//        private static final int MAXIMUM_POOL_SIZE = CPU_COUNT * 2 + 1;
//        private static final int KEEP_ALIVE = 1;
//
//        private static final BlockingDeque<Runnable> sPoolWorkQueue =
//                new LinkedBlockingDeque<>(128);
//
//        private static HttpUtils httpUtils = new HttpUtils();
//
//        public HttpUtils() {
//
//        }
//
//        public static HttpUtils getHttpUtils() {
//            if (httpUtils == null) {
//                httpUtils = new HttpUtils();
//            }
//            return httpUtils;
//        }
//        public String get(URL url){
//            AsyncTask1 asyncTask1=new AsyncTask1();
//            asyncTask1.customThreadPool();
//            return asyncTask1.dosomething(url);
//        }
//
//        //一个封装了的内部类
//        static class AsyncTask1 implements Runnable{
//            StringBuilder builder;
//            public void run(){
//
//            }
//
//            //具体网络请求
//            protected String dosomething (final URL url) {
//                new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        try {
//                            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//                            connection.setRequestMethod("GET");
//                            connection.setConnectTimeout(5000);
//                            connection.setReadTimeout(5000);
//                            int code = connection.getResponseCode();
//                            if (code == 200) {
//                                InputStream inputStream = connection.getInputStream();
//                                InputStreamReader streamReader = new InputStreamReader(inputStream);
//                                BufferedReader reader = new BufferedReader(streamReader);
//                                builder=new StringBuilder();
//                                String s = "";
//                                while ((s = reader.readLine()) != null) {
//                                    builder.append(s);
//                                }
////                            streamReader.close();
////                            reader.close();
//                                //  return builder.toString();
//                                Log.d("thiswwwwwwwwwwwwwwwwww", builder.toString());
//                            }
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }).start();
//                return builder.toString();
//            }
//            //线程池
//            class MyThreadPool extends ThreadPoolExecutor {
//                public MyThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime,
//                                    TimeUnit unit, BlockingDeque<Runnable> workQueue) {
//                    super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
//                }
//
//                @Override
//                protected void beforeExecute(Thread t, Runnable r) {
//                    super.beforeExecute(t, r);
//                    Log.d("google_lenve_fb", "beforeExecute: 开始执行任务！");
//                }
//
//                @Override
//                protected void afterExecute(Runnable r, Throwable t) {
//                    super.afterExecute(r, t);
//                    Log.d("google_lenve_fb", "afterExecute: 任务执行结束！");
//                }
//
//                @Override
//                protected void terminated() {
//                    super.terminated();
//                    Log.d("google_lenve_fb", "terminated: 线程池关闭！");
//                }
//            }
//            final public void customThreadPool() {
//                MyThreadPool myThreadPool = new MyThreadPool(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, KEEP_ALIVE,
//                        TimeUnit.SECONDS, sPoolWorkQueue);
//                AsyncTask1 task1=new AsyncTask1();
//                new Thread(task1).start();
//                myThreadPool.execute(task1);
//            }
//        }
//    }
//public void requestalbum(){
//    HttpUtils httpUtils = HttpUtils.getHttpUtils();
//    try {
//        URL url1=new URL(" http://47.99.165.194/album/newest");
//        URL url2=new URL("https://www.baidu.com");
//        final String albumText=httpUtils.get(url1);
//        final Albums albums= Utility.handleAlbumResponse(albumText);
//        runOnUiThread(new Runnable() {
//            @Override
//            public void run() {
//                if (albums!=null){
//                    SharedPreferences.Editor editor= PreferenceManager.
//                            getDefaultSharedPreferences(BannerActivity.this).edit();
//                    editor.putString("album",albumText);
//                    editor.apply();
//                    showAlbum1(albums);
//                    showAlbum2(albums);
//                }
//            }
//        });
//    }catch (Exception e){
//        e.printStackTrace();
//    }
//}
}
