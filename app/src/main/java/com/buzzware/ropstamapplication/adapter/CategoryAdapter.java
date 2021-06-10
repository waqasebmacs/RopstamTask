package com.buzzware.ropstamapplication.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.buzzware.ropstamapplication.utils.CategoryProduct;
import com.buzzware.ropstamapplication.R;
import com.buzzware.ropstamapplication.model.Category;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyViewHolder> {
    private ArrayList<Category> categories;
    Context mContext;
    CategoryProduct categoryProductInterface;
    public CategoryAdapter(ArrayList<Category> trendingProductsArrayList, Context context,CategoryProduct categoryProduct) {
        this.categories = trendingProductsArrayList;
        this.mContext = context;
        this.categoryProductInterface = categoryProduct;
    }

    @Override
    public CategoryAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.category_layout, parent, false);

        return new CategoryAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CategoryAdapter.MyViewHolder holder, int position) {
        Category trendingProduct = categories.get(position);
        holder.category_Item_IV.setImageResource(trendingProduct.getCategoryIV());
        holder.category_Item_Tv.setText(trendingProduct.getCategory_Title());

        holder.categorycard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                categoryProductInterface.onItemCategoryClick(categories.get(position).getCategory_Title());

            }
        });
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView category_Item_Tv;
        ImageView category_Item_IV;
        CardView categorycard;

        public MyViewHolder(View view) {
            super(view);
            category_Item_Tv = view.findViewById(R.id.category_Item_Tv);
            category_Item_IV = view.findViewById(R.id.category_Item_IV);
            categorycard = view.findViewById(R.id.categorycard);

        }
    }

    public void setfilter(ArrayList<Category> newList) {
        categories = new ArrayList<>();
        categories.addAll(newList);
        notifyDataSetChanged();
    }
}



