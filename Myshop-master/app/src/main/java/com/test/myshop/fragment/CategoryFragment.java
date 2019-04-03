package com.test.myshop.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.cjj.MaterialRefreshLayout;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.test.myshop.R;
import com.test.myshop.adapter.CategoryAdapter;
import com.test.myshop.adapter.WaresAdapter;
import com.test.myshop.bean.Category;

import java.util.ArrayList;
import java.util.List;


public class CategoryFragment extends BaseFragment {

//分类

    @ViewInject(R.id.recyclerview_category)
    private RecyclerView mRecyclerView;


    @ViewInject(R.id.recyclerview_wares)
    private RecyclerView mRecyclerviewWares;

    @ViewInject(R.id.refresh_layout)
    private MaterialRefreshLayout mRefreshLaout;

    @ViewInject(R.id.recycler_view)
    private RecyclerView recyclerView;


    private WaresAdapter mWaresAdatper;

    private  ArrayList<Category> kindList = new ArrayList<>();

    private View rootView;



    @Override
    public View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_category,container,false);
        return rootView;
    }

    @Override
    public void init() {
        showkind();
        getkind();

    }


    private void getkind(){

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayout.VERTICAL);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerview_category);
        recyclerView.setLayoutManager(linearLayoutManager);
        CategoryAdapter adapter = new CategoryAdapter(kindList);
        recyclerView.setAdapter(adapter);
    }

    private void showkind(){
        Category book = new Category("书本");
        kindList.add(book);
        Category wenju = new Category("文具");
        kindList.add(wenju);
        Category manclothes = new Category("男装");
        kindList.add(manclothes);
        Category womenclothes = new Category("女装");
        kindList.add(womenclothes);
        Category shoes = new Category("鞋子");
        kindList.add(shoes);
        Category bag = new Category("箱包");
        kindList.add(bag);
        Category shiping = new Category("饰品");
        kindList.add(shiping);
        Category makeup = new Category("美妆");
        kindList.add(makeup);
        Category phone = new Category("手机数码");
        kindList.add(phone);
        Category computer = new Category("电脑办公");
        kindList.add(computer);
        Category fitnessequ = new Category("健身器材");
        kindList.add(fitnessequ);
        Category entertainment = new Category("娱乐设施");
        kindList.add(entertainment);
        Category daily = new Category("生活用品");
        kindList.add(daily);
    }


}



