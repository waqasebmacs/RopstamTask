package com.buzzware.ropstamapplication.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.buzzware.ropstamapplication.utils.CategoryProduct;
import com.buzzware.ropstamapplication.R;
import com.buzzware.ropstamapplication.activties.ProductDetails;
import com.buzzware.ropstamapplication.adapter.CategoryAdapter;
import com.buzzware.ropstamapplication.adapter.TrendingProductsAdapter;
import com.buzzware.ropstamapplication.model.Category;
import com.buzzware.ropstamapplication.model.TrendingProducts;
import com.buzzware.ropstamapplication.utils.Constant;

import java.util.ArrayList;

public class Home extends Fragment implements CategoryProduct {
    View view;
    RecyclerView categoryrecyvlerView,trendingrecyclerView;
    CategoryAdapter categoryAdapter;
    TrendingProductsAdapter  trendingProductsAdapter;
    ArrayList<TrendingProducts> trendingProductsArrayList;
    ArrayList<Category> categoryArrayList;
    EditText productsearch_ET;
    String searchvalue;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.fragment_home, container, false);
        initialzation();

        return view;
    }

    private void initialzation() {
        categoryrecyvlerView=view.findViewById(R.id.categoryrecyvlerView);
        trendingrecyclerView=view.findViewById(R.id.trendingrecyclerView);
        productsearch_ET=view.findViewById(R.id.productsearch_ET);
        trendingProductsArrayList=new ArrayList<>();
        categoryArrayList=new ArrayList<>();
        tredningProductData();
        listCategorySearchingFilter();
    }
    public void tredningProductData()
    {
        //todo for Trending Data
        trendingProductsArrayList.add ( new TrendingProducts ( R.drawable.imgb,"Sofa Boleria\n₹ 850/Month"));
        trendingProductsArrayList.add ( new TrendingProducts ( R.drawable.imgc,"Dining Table\n₹ 850/Month"));
        trendingProductsArrayList.add ( new TrendingProducts ( R.drawable.imga,"Faberic sofa\n₹ 850/Month"));
        trendingrecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, true));
        trendingProductsAdapter = new TrendingProductsAdapter( trendingProductsArrayList,getActivity ());
        trendingrecyclerView.setAdapter(trendingProductsAdapter);
        trendingrecyclerView.scrollToPosition(0);
        trendingrecyclerView.scrollTo(0, 0);

        categoryData();

    }

    private void categoryData() {
        categoryArrayList.add ( new Category ( R.drawable.icon_c,"Bed \n Room"));
        categoryArrayList.add ( new Category( R.drawable.icon_d,"Living Room"));
        categoryArrayList.add ( new Category ( R.drawable.icon_f,"DSLR Camera"));

        categoryArrayList.add ( new Category ( R.drawable.icon_e,"Application"));
        categoryArrayList.add ( new Category ( R.drawable.icon_c,"Storage"));
        categoryArrayList.add ( new Category ( R.drawable.icon_b,"Package"));
        categoryrecyvlerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        categoryAdapter = new CategoryAdapter( categoryArrayList,getActivity (), Home.this);
        categoryrecyvlerView.setAdapter(categoryAdapter);
    }

    private void listCategorySearchingFilter() {
        productsearch_ET.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {

                searchvalue = productsearch_ET.getText().toString();
                searchvalue = searchvalue.toLowerCase();
                ArrayList<Category> newList = new ArrayList<>();

                for (Category crt : categoryArrayList) {

                    String name = crt.getCategory_Title().toLowerCase();
                    if (name.contains(searchvalue)) {
                        newList.add(crt);
                    }
                    categoryArrayList=newList;

                    categoryAdapter.setfilter(newList);
                }

            }
        });
    }



    //todo its for postion form adapter every item best way to click using interface
    @Override
    public void onItemCategoryClick(String categoryTitle) {
        Intent intent = new Intent(getContext(), ProductDetails.class);
        intent.putExtra(Constant.CATEGORY_ID_KEY, categoryTitle);
        Log.d("categoryTitle",categoryTitle);
        startActivity(intent);

    }
}