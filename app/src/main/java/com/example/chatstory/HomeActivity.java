package com.example.chatstory;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {
    long back;
    Toast backToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        BottomNavigationView bottomNavigationView=findViewById(R.id.navigation_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(listener);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame,new Home()).commit();


    }
    BottomNavigationView.OnNavigationItemSelectedListener listener= new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedfragment=null;
            switch (item.getItemId())
            {
                case R.id.home :
                    selectedfragment=new Home();
                    break;

                case R.id.bookmark:
                    selectedfragment=new Bookmark();
                    break;
                case R.id.fav :
                    selectedfragment=new Favourite();
                    break;
                case R.id.profile:
                    selectedfragment=new Profile();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.frame,selectedfragment).commit();
            return true;
        }
    };

    @Override
    public void onBackPressed() {

        if (back+2000>System.currentTimeMillis()){
            backToast.cancel();
            super.onBackPressed();
            return;
        }else {
            backToast= Toast.makeText(getApplicationContext(),"please back again to exit",Toast.LENGTH_SHORT);
            backToast.show();
        }
        back=System.currentTimeMillis();
    }
}
