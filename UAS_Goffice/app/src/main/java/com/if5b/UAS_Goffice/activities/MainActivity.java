package com.if5b.UAS_Goffice.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.if5b.UAS_Goffice.R;
import com.if5b.UAS_Goffice.fragment.FeedbackFragment;
import com.if5b.UAS_Goffice.fragment.HomeFragment;
import com.if5b.UAS_Goffice.fragment.ProfileFragment;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    BottomNavigationView bnvDashboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bnvDashboard = findViewById(R.id.bnv_dashboard);

        bottomNavigationMenu();
        init();
    }

    private void init(){
        firstLoadPage();
    }


    public void bottomNavigationMenu(){
        bnvDashboard.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment fragment = null;
                switch (item.getItemId()){
                    case R.id.iHome:
                        fragment = new HomeFragment();
                        break;

                    case R.id.iProfile:
                        fragment = new ProfileFragment();
                        break;

                    case R.id.iFeedback:
                        fragment = new FeedbackFragment();
                        break;
                }

                return loadPage(fragment);
            }
        });
    }

    private void firstLoadPage(){
        Fragment fragment = new HomeFragment();
        loadPage(fragment);
    }

    private boolean loadPage(Fragment fragment){
        if (fragment != null){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frame_dashboard, fragment)
                    .commit();
            return true;
        }

        return false;
    }
}