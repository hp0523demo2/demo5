package com.bawey.kgf.zhibo.view.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;

import com.bawey.kgf.zhibo.R;
import com.bawey.kgf.zhibo.model.CategroyBean;
import com.bawey.kgf.zhibo.utils.Api;
import com.bawey.kgf.zhibo.utils.CommObserver;
import com.bawey.kgf.zhibo.view.adapter.MyPagerAdapter;
import com.bawey.kgf.zhibo.view.fragment.MyFragment;
import com.flyco.tablayout.SlidingTabLayout;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends BaseActivity {

    private final String[] mTitles = {
            "热门", "iOS", "Android"
            , "前端", "后端", "设计", "工具资源"
    };
    private ArrayList<Fragment> mList = new ArrayList<>();
    private ArrayList<String> sList = new ArrayList<>();
    private ViewPager vp;
    private SlidingTabLayout tabLayout;
   Handler handler=new Handler(){

   };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//handler.sendMessage()
        //Activityth
        OkHttpClient okHttpClient=new OkHttpClient();
        Request request=new Request.Builder().url("").build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

            }
        });
        Map<String,String> map = new HashMap<>();
        map.put("act","goods_class");

        initView();
        initData();
        Api.getRequest(Api.getRetrofitInstance().getAllCategoryRx(map), new CommObserver<CategroyBean>() {
            @Override
            public void onNextTo(CategroyBean bean) {

                Log.e("TAG",""+bean.getDatas().getClass_list().get(0).getGc_name());

            }
        });




    }
    public void initView(){
        vp = (ViewPager) findViewById(R.id.vp);
        tabLayout = (SlidingTabLayout) findViewById(R.id.tl_1);
    }

    public void initData(){
        /**
         * 查看共有多少个标签就new出几个fragment
         */
        for (String title:mTitles){
            mList.add(new MyFragment());
            sList.add(title);
        }
        /**
         * 设置适配器
         */
        vp.setAdapter(new MyPagerAdapter(getSupportFragmentManager(),mList, mTitles));
        tabLayout.setViewPager(vp);

    }

}
