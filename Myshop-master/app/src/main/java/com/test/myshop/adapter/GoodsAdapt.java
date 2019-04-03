package com.test.myshop.adapter;

import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.test.myshop.R;
import com.test.myshop.bean.Goods;

import java.util.ArrayList;
import java.util.List;

public class GoodsAdapt extends RecyclerView.Adapter<GoodsAdapt.ViewHolder> {


    private List<Goods> goodsList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView goodimage;
        TextView goodname;
        TextView goodprice;
        public ViewHolder(View view){
            super(view);
            goodimage = (ImageView) view.findViewById(R.id.image);
            goodname = (TextView) view.findViewById(R.id.name);
            goodprice = (TextView) view.findViewById(R.id.price);
        }

    }


    public GoodsAdapt ( ArrayList<Goods> goodsList){
        goodsList = goodsList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.goods_item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return  holder;
    }

    @Override
    public void onBindViewHolder (ViewHolder holder, int position){
        Goods goods = goodsList.get(position);
        holder.goodname.setText(goods.getName());
        holder.goodprice.setText((int) goods.getPrice());
 //       holder.goodimage.setImageBitmap();

    }

    @Override
    public int getItemCount(){
        return goodsList.size();
    }

}
