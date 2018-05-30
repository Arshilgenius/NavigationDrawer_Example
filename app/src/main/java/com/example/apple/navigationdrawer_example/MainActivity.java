package com.example.apple.navigationdrawer_example;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    Toolbar toolbar;
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupToolbar();

        navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.nav_home:
                        Toast.makeText(MainActivity.this, "nav home selection", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_android:
                        Toast.makeText(MainActivity.this, "Nav Android Selected", Toast.LENGTH_SHORT).show();
                        break;
                }

                return false;

            }
        });
    }


    private void setupToolbar() {
        drawerLayout = findViewById(R.id.drawerlayout);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name, R.string.app_name);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }
}

/*
1. add design library
2. make theme in manifest to no action bar
3. in the xml file make the parent viewgroup to drawerlayout
4. then make 2 childs of these layout
5. 1 child is the things that is to be displayed on the screen
6. the other child is what is hidden and is the drawer.
7. in the java file make a method setuptoolbar and call it from oncreate
8 in this java file first get the drawer and toolbar and make an object of action bar drawer toggle
9. connect the drawer to this action bar drawer toggle
10. sync the action bar drawer toggle
12. in the second child add the app:menu and app:header and make those layouts
13. make all the items you want to list in navtigation drawer with the help of group then item
14. make header layout
15. then in the mainactivity call the navigation view and put setNavigationItemSelected listener and your work is done.
 */
