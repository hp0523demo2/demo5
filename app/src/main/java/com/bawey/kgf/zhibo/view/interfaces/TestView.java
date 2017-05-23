package com.bawey.kgf.zhibo.view.interfaces;

import com.bawey.kgf.zhibo.model.CategroyBean;

/**
 * Created by Administrator on 2017/2/20 0020.
 */

public interface TestView extends BaseView{

    void onSuccess(CategroyBean bean);
    void onFail();
}
