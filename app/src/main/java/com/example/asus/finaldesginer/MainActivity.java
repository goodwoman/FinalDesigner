package com.example.asus.finaldesginer;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;

    private Aphorism[] aphorisms={new Aphorism("Aphorosm 1",R.mipmap.photo1),
            new Aphorism("Aphorosm 2",R.mipmap.photo2),
            new Aphorism("Aphorosm 3",R.mipmap.photo3),
            new Aphorism("Aphorosm 4",R.mipmap.photo4),
            new Aphorism("Aphorosm 5",R.mipmap.photo5),
            new Aphorism("Aphorosm 6",R.mipmap.photo6),
            new Aphorism("Aphorosm 7",R.mipmap.photo7),
            new Aphorism("Aphorosm 8",R.mipmap.photo8),
            new Aphorism("Aphorosm 9",R.mipmap.photo9),
            new Aphorism("Aphorosm 10",R.mipmap.photo10),
            new Aphorism("Aphorosm 11",R.mipmap.photo11),
            new Aphorism("Aphorosm 12",R.mipmap.photo12),
            new Aphorism("Aphorosm 13",R.mipmap.photo13)
    };
 private List<Aphorism> aphorismList=new ArrayList<>();
 private AphorismAdapter adapter;

 private SwipeRefreshLayout swipeRefresh;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView navView = (NavigationView) findViewById(R.id.nav_view);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.mipmap.ic_menu);
        }
        //navView.setCheckedItem(R.id.nav_camera);
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                //mDrawerLayout.closeDrawers();
                switch (item.getItemId()){
                    case R.id.nav_camera:
                        Intent intent=new Intent(MainActivity.this,CamreaActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.nav_favorite:
                        Intent intent1=new Intent(MainActivity.this,FavoriteActivity.class
                        );
                        startActivity(intent1);
                        break;
                    case R.id.nav_more:
                        Intent intent2=new Intent(MainActivity.this,MoreActivity.class);
                        startActivity(intent2);
                        break;
                        default:
                            break;

                }

                return true;
            }
        });

        FloatingActionButton fab=(FloatingActionButton)findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view,"Data deleted ",Snackbar.LENGTH_SHORT).
                        setAction("Undo", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Toast.makeText(MainActivity.this,"Data restored",Toast.LENGTH_SHORT)
                                        .show();
                            }
                        }).show();

            }
        });
      initAphorism();
        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.recycler_view);
        GridLayoutManager layoutManager=new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        adapter=new AphorismAdapter(aphorismList);
        recyclerView.setAdapter(adapter);
        swipeRefresh=(SwipeRefreshLayout)findViewById(R.id.swip_refresh);
        swipeRefresh.setColorSchemeResources(R.color.colorPrimary);
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshAphorisms();
            }
        });
    }
    private void refreshAphorisms(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        initAphorism();
                        adapter.notifyDataSetChanged();
                        swipeRefresh.setRefreshing(false);
                    }
                });
            }
        }).start();
    }



    private void initAphorism() {
        aphorismList.clear();
        for (int i = 0; i <50 ; i++) {
            Random random=new Random();
            int index=random.nextInt(aphorisms.length);
            aphorismList.add(aphorisms[index]);

        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;
            case R.id.backup:
                Toast.makeText(this, "You click Backup", Toast.LENGTH_LONG)
                        .show();
                break;
            case R.id.delete:

                break;
            case R.id.setting:
                Toast.makeText(this, "You click Setting", Toast.LENGTH_SHORT)
                        .show();
                break;


            default:
        }

    return true;

    }

}
