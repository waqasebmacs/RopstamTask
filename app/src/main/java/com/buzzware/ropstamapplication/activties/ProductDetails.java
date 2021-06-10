package com.buzzware.ropstamapplication.activties;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.buzzware.ropstamapplication.R;
import com.buzzware.ropstamapplication.utils.Constant;

public class ProductDetails extends AppCompatActivity {
    ImageView backarrow_icon;
    TextView sizeoneTv,sizetwoTv,sizethreeTv,sizefourTv;
    String categoryID="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        initialzation();
        setListner();

    }


    private void initialzation() {
        backarrow_icon=findViewById(R.id.backarrow_icon);
        sizeoneTv=findViewById(R.id.sizeoneTv);
        sizetwoTv=findViewById(R.id.sizetwoTv);
        sizethreeTv=findViewById(R.id.sizethreeTv);
        sizefourTv=findViewById(R.id.sizefourTv);
        selectedSizeFirst(sizeoneTv,sizetwoTv,sizethreeTv,sizefourTv);
        //todo gett id which click in previous screen using interfae
            if (getIntent().getExtras() != null) {
                categoryID = getIntent().getStringExtra(Constant.CATEGORY_ID_KEY);
            }


    }
    private void setListner() {
        backarrow_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        sizeoneTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedSizeFirst(sizeoneTv,sizetwoTv,sizethreeTv,sizefourTv);

            }
        });
        sizetwoTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedSizeSecond(sizeoneTv,sizetwoTv,sizethreeTv,sizefourTv);

            }
        });
        sizethreeTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedSizeThree(sizeoneTv,sizetwoTv,sizethreeTv,sizefourTv);
            }
        });
        sizefourTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedSizeFour(sizeoneTv,sizetwoTv,sizethreeTv,sizefourTv);
            }
        });

    }

    public void selectedSizeFirst(TextView sizeOne, TextView sizeTwo, TextView sizeThree, TextView sizeFour)
    {
        sizeOne.setBackground(getResources().getDrawable(R.drawable.round_shadow_button));
        sizeTwo.setBackground(getResources().getDrawable(R.drawable.roundwhite_shadow_button));
        sizeThree.setBackground(getResources().getDrawable(R.drawable.roundwhite_shadow_button));
        sizeFour.setBackground(getResources().getDrawable(R.drawable.roundwhite_shadow_button));

        sizeOne.setTextColor(getResources().getColor(R.color.yellowcolor));
        sizeTwo.setTextColor(getResources().getColor(R.color.appcolor));
        sizeThree.setTextColor(getResources().getColor(R.color.appcolor));
        sizeFour.setTextColor(getResources().getColor(R.color.appcolor));


    }
    public void selectedSizeSecond(TextView sizeOne, TextView sizeTwo, TextView sizeThree, TextView sizeFour)
    {
        sizeOne.setBackground(getResources().getDrawable(R.drawable.roundwhite_shadow_button));
        sizeTwo.setBackground(getResources().getDrawable(R.drawable.round_shadow_button));
        sizeThree.setBackground(getResources().getDrawable(R.drawable.roundwhite_shadow_button));
        sizeFour.setBackground(getResources().getDrawable(R.drawable.roundwhite_shadow_button));

        sizeOne.setTextColor(getResources().getColor(R.color.appcolor));
        sizeTwo.setTextColor(getResources().getColor(R.color.yellowcolor));
        sizeThree.setTextColor(getResources().getColor(R.color.appcolor));
        sizeFour.setTextColor(getResources().getColor(R.color.appcolor));

    }

    public void selectedSizeThree(TextView sizeOne, TextView sizeTwo, TextView sizeThree, TextView sizeFour)
    {
        sizeOne.setBackground(getResources().getDrawable(R.drawable.roundwhite_shadow_button));
        sizeTwo.setBackground(getResources().getDrawable(R.drawable.roundwhite_shadow_button));
        sizeThree.setBackground(getResources().getDrawable(R.drawable.round_shadow_button));
        sizeFour.setBackground(getResources().getDrawable(R.drawable.roundwhite_shadow_button));

        sizeOne.setTextColor(getResources().getColor(R.color.appcolor));
        sizeTwo.setTextColor(getResources().getColor(R.color.appcolor));
        sizeThree.setTextColor(getResources().getColor(R.color.yellowcolor));
        sizeFour.setTextColor(getResources().getColor(R.color.appcolor));

    }

    public void selectedSizeFour(TextView sizeOne, TextView sizeTwo, TextView sizeThree, TextView sizeFour)
    {
        sizeOne.setBackground(getResources().getDrawable(R.drawable.roundwhite_shadow_button));
        sizeTwo.setBackground(getResources().getDrawable(R.drawable.roundwhite_shadow_button));
        sizeThree.setBackground(getResources().getDrawable(R.drawable.roundwhite_shadow_button));
        sizeFour.setBackground(getResources().getDrawable(R.drawable.round_shadow_button));


        sizeOne.setTextColor(getResources().getColor(R.color.appcolor));
        sizeTwo.setTextColor(getResources().getColor(R.color.appcolor));
        sizeThree.setTextColor(getResources().getColor(R.color.appcolor));
        sizeFour.setTextColor(getResources().getColor(R.color.yellowcolor));

    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}