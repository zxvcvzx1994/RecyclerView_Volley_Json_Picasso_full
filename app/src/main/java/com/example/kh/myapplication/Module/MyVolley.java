package com.example.kh.myapplication.Module;

import android.content.Context;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;

/**
 * Created by kh on 6/14/2017.
 */

public class MyVolley {
    private Context context;
    private static MyVolley myVolley;
    private RequestQueue requestQueue;

    public MyVolley(Context context){
        this.context  =context;

    }

    public synchronized static MyVolley getInstance(Context context){
        if(myVolley==null)
            myVolley = new MyVolley(context);
        return myVolley;
    }

    public void StartVolley(){
        Network network = new BasicNetwork(new HurlStack());
        Cache cache = new DiskBasedCache(context.getCacheDir(), 1024*1024);
        requestQueue = new RequestQueue(cache, network);
        requestQueue.start();
    }

    public void StopVolley(){
        requestQueue.stop();
    }

    public <T> void AddRequest(Request<T> request){
        requestQueue.add(request);

    }
}
