package com.bawey.kgf.zhibo.utils;


import com.bawey.kgf.zhibo.view.interfaces.ApiDataService;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2017/2/20 0020.
 */

public class Api {

    public static ApiDataService getRetrofitInstance(){
        return RetrogitInstance.service;
    }

    public static class RetrogitInstance{
        public static ApiDataService service = new Retrofit.Builder()
                .baseUrl("http://169.254.170.241")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiDataService.class);
    }
    public  static <T> void getRequest(Observable<T> observable, CommObserver<T> observer){
        observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);

    }


}
