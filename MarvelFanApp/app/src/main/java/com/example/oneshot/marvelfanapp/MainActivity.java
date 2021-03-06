package com.example.oneshot.marvelfanapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;

import com.example.oneshot.marvelfanapp.activity.ListCharactersActivity;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView http = (TextView) this.findViewById(R.id.marvel_http);
        http.setMovementMethod(LinkMovementMethod.getInstance());

        initDrawerLayout();
        findViewById(R.id.v_feedback_overlay).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent characters = new Intent(getApplicationContext(), ListCharactersActivity.class);
                startActivity(characters);

            }
        });
        findViewById(R.id.bt_characters).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent characters = new Intent(getApplicationContext(), ListCharactersActivity.class);
                startActivity(characters);

            }
        });
    }

    public void initDrawerLayout() {
        final DrawerLayout drawerLayout = (DrawerLayout) this.findViewById(R.id.drawer_layout);
        Toolbar toolbar = (Toolbar) this.findViewById(R.id.toolbarHome);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.home);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                toolbar,
                R.string.drawer_open,
                R.string.drawer_close
        ){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getSupportActionBar().setTitle(R.string.menu);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                getSupportActionBar().setTitle(R.string.home);
            }
        };

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }


}
