package com.buzzware.ropstamapplication.activties;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.buzzware.ropstamapplication.R;
import com.buzzware.ropstamapplication.fragment.Cart;
import com.buzzware.ropstamapplication.fragment.Home;
import com.buzzware.ropstamapplication.fragment.Products;
import com.buzzware.ropstamapplication.fragment.Profile;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class Rentickle extends AppCompatActivity  implements
        BottomNavigationView.OnNavigationItemSelectedListener {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rentickle);
        initialzation();
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    private void initialzation() {
        bottomNavigationView = findViewById ( R.id.bottomnav );

        loadFragment(new Home());
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_home:
                loadFragment(new Home());
                break;
            case R.id.nav_products :
                loadFragment(new Products());
                break;
            case R.id.nav_carts:
                loadFragment(new Cart());
                break;
            case R.id.nav_profile :
                loadFragment(new Profile());
                break;
        }
        return true;
    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.home_fragment, fragment);
        transaction.commit();
    }
}