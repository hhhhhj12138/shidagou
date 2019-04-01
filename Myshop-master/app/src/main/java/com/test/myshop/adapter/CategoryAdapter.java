package com.test.myshop.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.test.myshop.R;
import com.test.myshop.bean.Category;
import com.test.myshop.bean.Goods;

import java.util.ArrayList;
import java.util.List;


public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    private ArrayList<Category> kindList;
    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView kind;

        public ViewHolder(View view){
            super(view);
            kind= (TextView) view.findViewById(R.id.kind);
        }
    }

    public CategoryAdapter(ArrayList<Category> kindList){
        this.kindList= kindList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.kind_item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return  holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position){
        Category category = kindList.get(position);
        holder.kind.setText(category.getName());
    }

    @Override
    public int getItemCount(){
        if (kindList == null) return 0;
        return kindList.size();
    }


}
