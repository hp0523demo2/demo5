package com.bawey.kgf.zhibo.view.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawey.kgf.zhibo.R;
import com.bawey.kgf.zhibo.view.adapter.CommonAdapter;
import com.bawey.kgf.zhibo.view.adapter.ViewHolder;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/2/20 0020.
 */
@SuppressLint("ValidFragment")
public class MyFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.test_layout, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        ArrayList<String> list = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        for (int i = 0; i < 100; i++) {
            list.add("我是数据--"+i);
        }
        recyclerView.setAdapter(new CommonAdapter<String>(getActivity(),R.layout.test_item,list) {
            @Override
            public void conver(ViewHolder viewHodler, String o) {
                viewHodler.setText(R.id.data,o);
            }
        });
        return view;
    }

}
