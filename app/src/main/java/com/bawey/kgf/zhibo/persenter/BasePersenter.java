package com.bawey.kgf.zhibo.persenter;

import com.bawey.kgf.zhibo.view.interfaces.BaseView;

/**
 *   康国璠
 * Created by Administrator on 2017/2/20 0020.
 */

public class BasePersenter <T extends BaseView>{
    private T mBaseView;

    public void attachView(T mBaseView){
        this.mBaseView = mBaseView;
    }
    public T getView(){
        return mBaseView;
    }
}
