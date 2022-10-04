package com.parth.bottombarwithfragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.parth.bottombarwithfragment.fregment.AboutFragment;
import com.parth.bottombarwithfragment.fregment.HomeFragment;
import com.parth.bottombarwithfragment.fregment.ProfileFragment;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    HomeFragment homeFragment = new HomeFragment();
    AboutFragment aboutFragment = new AboutFragment();
    ProfileFragment profileFragment = new ProfileFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomnav);

//        set default fregment
        getSupportFragmentManager().beginTransaction().replace(R.id.container, homeFragment).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        item.setChecked(true);
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, homeFragment).commit();
//                        return true
                    break;

                    case R.id.about:
                        item.setChecked(true);
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, aboutFragment).commit();
//                        return true
                        break;

                    case R.id.profile:
                        item.setChecked(true);
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, profileFragment).commit();
//                        return true
                        break;
                }
                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.topbar,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.seach:
                Toast.makeText(this, "Search Click", Toast.LENGTH_SHORT).show();
                break;

            case R.id.myaccount:
                Toast.makeText(this, "My Account Click", Toast.LENGTH_SHORT).show();
                break;

            case R.id.logout:
                Toast.makeText(this, "Logout Click", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}