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
        //requestCategoryData();
        //requestBannerData();
        //initRefreshLayout();
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




//    private  void initRefreshLayout(){
//
//        mRefreshLaout.setLoadMore(true);
//        mRefreshLaout.setMaterialRefreshListener(new MaterialRefreshListener() {
//            @Override
//            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
//
//                refreshData();
//
//            }
//
//            @Override
//            public void onRefreshLoadMore(MaterialRefreshLayout materialRefreshLayout) {
//
//                if(currPage <=totalPage)
//                    loadMoreData();
//                else{
//                    mRefreshLaout.finishRefreshLoadMore();
//                }
//            }
//        });
//    }


//    private  void refreshData(){
//
//        currPage =1;
//
//        state=STATE_REFREH;
//        requestWares(category_id);
//
//    }
//
//    private void loadMoreData(){
//
//        currPage = ++currPage;
//        state = STATE_MORE;
//        requestWares(category_id);
//
//    }


//    private  void requestCategoryData(){
//
//
//
//        mHttpHelper.get(Contants.API.CATEGORY_LIST, new SpotsCallBack<List<Category>>(getActivity()) {
//
//
//            @Override
//            public void onSuccess(Response response, List<Category> categories) {
//
//                showCategoryData(categories);
//
//                if(categories !=null && categories.size()>0)
//                    category_id = categories.get(0).getId();
//                    requestWares(category_id);
//            }
//
//            @Override
//            public void onError(Response response, int code, Exception e) {
//
//            }
//        });
//
//    }

//    private  void showCategoryData(List<Category> categories){
//
//
//        mCategoryAdapter = new CategoryAdapter(getActivity(),categories);
//
//        mCategoryAdapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
//            @Override
//            public void onItemClick(View view, int position) {
//
//                Category category = mCategoryAdapter.getItem(position);
//
//                category_id = category.getId();
//                currPage=1;
//                state=STATE_NORMAL;
//
//                requestWares(category_id);
//
//
//            }
//        });
//
//        mRecyclerView.setAdapter(mCategoryAdapter);
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
//        mRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL_LIST));
//
//
//    }





//    private void requestBannerData( ) {



 //      String url = Contants.API.BANNER+"?type=1";

//        mHttpHelper.get(url, new SpotsCallBack<List<Banner>>(getActivity()){
//
//
//            @Override
//            public void onSuccess(Response response, List<Banner> banners) {
//
//                showSliderViews(banners);
//            }
//
//            @Override
//            public void onError(Response response, int code, Exception e) {
//
//            }
//        });
//
//    }


//
//    private void showSliderViews(List<Banner> banners){
//
//
//
//
//        if(banners !=null){
//
//            for (Banner banner : banners){
//
//
//                DefaultSliderView sliderView = new DefaultSliderView(this.getActivity());
//                sliderView.image(banner.getImgUrl());
//                sliderView.description(banner.getName());
//                sliderView.setScaleType(BaseSliderView.ScaleType.Fit);
//                mSliderLayout.addSlider(sliderView);
//
//            }
//        }



//        mSliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
//
//        mSliderLayout.setCustomAnimation(new DescriptionAnimation());
//        mSliderLayout.setPresetTransformer(SliderLayout.Transformer.Default);
//        mSliderLayout.setDuration(3000);




//    }



//    private void requestWares(long categoryId){
//
//        String url = Contants.API.WARES_LIST+"?categoryId="+categoryId+"&curPage="+currPage+"&pageSize="+pageSize;
//
//        mHttpHelper.get(url, new SimpleCallback<Page<Wares>>(getActivity()) {
//
//
//
//
//            @Override
//            public void onSuccess(Response response, Page<Wares> waresPage) {
//
//
//                currPage = waresPage.getCurrentPage();
//                totalPage =waresPage.getTotalPage();
//
//                showWaresData(waresPage.getList());
//
//
//            }
//
//            @Override
//            public void onError(Response response, int code, Exception e) {
//
//            }
//
//
//        });
//
//    }



//    private  void showWaresData(List<Wares> wares){
//
//
//
//        switch (state){
//
//            case  STATE_NORMAL:
//
//                if(mWaresAdatper ==null) {
//                    mWaresAdatper = new WaresAdapter(getActivity(), wares);
//                    mWaresAdatper.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
//                        @Override
//                        public void onItemClick(View view, int position) {
//                            Wares wares = mWaresAdatper.getItem(position);
//
//                            Intent intent = new Intent(getActivity(), WareDetailActivity.class);
//
//                            intent.putExtra(Contants.WARE,wares);
//                            startActivity(intent);
//
//                        }
//                    });
//
//                    mRecyclerviewWares.setAdapter(mWaresAdatper);
//
//                    mRecyclerviewWares.setLayoutManager(new GridLayoutManager(getActivity(), 2));
//                    mRecyclerviewWares.setItemAnimator(new DefaultItemAnimator());
//                }
//                else{
//                    mWaresAdatper.clear();
//                    mWaresAdatper.addData(wares);
//                }
//
//
//
//
//                break;
//
//            case STATE_REFREH:
//                mWaresAdatper.clear();
//                mWaresAdatper.addData(wares);
//
//                mRecyclerviewWares.scrollToPosition(0);
//                mRefreshLaout.finishRefresh();
//                break;
//
//            case STATE_MORE:
//                mWaresAdatper.addData(mWaresAdatper.getDatas().size(),wares);
//                mRecyclerviewWares.scrollToPosition(mWaresAdatper.getDatas().size());
//                mRefreshLaout.finishRefreshLoadMore();
//                break;
//
//
//        }
//
//
//
//    }
//
//
}



