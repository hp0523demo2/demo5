package com.bawey.kgf.zhibo.view.interfaces;



import com.bawey.kgf.zhibo.model.CategroyBean;


import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Administrator on 2017/2/20 0020.
 */

public interface ApiDataService {

    @FormUrlEncoded
    @POST("mobile/index.php")
    Observable<CategroyBean> getAllCategoryRx(@FieldMap Map<String,String> map);

}
