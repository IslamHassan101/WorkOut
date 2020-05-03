package com.example.workout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListner);
        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.nav_host,
                    new FragmentHome()).commit();
        }
    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListner=
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedfragment=null;

                    switch (menuItem.getItemId()){
                        case R.id.fragment_home:
                            selectedfragment=new FragmentHome();
                        case R.id.fragment_calender:
                            selectedfragment=new FragmentCalender();
                        case R.id.fragment_plus:
                            selectedfragment=new FragmentAdd();
                        case R.id.fragment_analysis:
                            selectedfragment=new FragmentAnalysis();
                        case R.id.fragment_profile:
                            selectedfragment=new FragmentProfile();
                    }
                    return true;
                }
            };
}
