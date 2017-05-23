package com.bawey.kgf.zhibo.utils;


import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by Administrator on 2017/2/21 0021.
 */

public abstract class CommObserver<T> implements Observer<T>{
    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onComplete() {

    }

    @Override
    public void onNext(T t) {
        onNextTo(t);
    }


    public abstract void onNextTo(T t);
}
