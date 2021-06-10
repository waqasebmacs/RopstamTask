package com.buzzware.ropstamapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.buzzware.ropstamapplication.R;
import com.buzzware.ropstamapplication.model.TrendingProducts;
import java.util.ArrayList;
public class TrendingProductsAdapter extends RecyclerView.Adapter<TrendingProductsAdapter.MyViewHolder> {
    private ArrayList<TrendingProducts> trendingProducts;
    Context mContext;
    public TrendingProductsAdapter(ArrayList<TrendingProducts> trendingProductsArrayList, Context context) {
        this.trendingProducts = trendingProductsArrayList;
        this.mContext = context;
    }
    @Override
    public TrendingProductsAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.trending_layout, parent, false);

        return new TrendingProductsAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TrendingProductsAdapter.MyViewHolder holder, int position) {
        TrendingProducts trendingProduct = trendingProducts.get(position);
        holder.trending_Item_IV.setImageResource(trendingProduct.getTrending_IV());
        holder.trending_Item_Tv.setText(trendingProduct.getTrending_title());
    }

    @Override
    public int getItemCount() {
        return trendingProducts.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView trending_Item_Tv;
        ImageView trending_Item_IV;

        public MyViewHolder(View view) {
            super(view);
            trending_Item_Tv = view.findViewById(R.id.trending_Item_Tv);
            trending_Item_IV = view.findViewById(R.id.trending_Item_IV);

        }
    }
}


