package com.example.asus.finaldesginer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

import java.util.ArrayList;
import java.util.List;

public class FavoriteActivity extends AppCompatActivity {

    private List<Aphorism> aphorismListl=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);
        initAphorisms();
        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.favorite_view);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        AphorismAdapter adapter=new AphorismAdapter(aphorismListl);
        recyclerView.setAdapter(adapter);
    }

    private void initAphorisms() {
        Aphorism aphorism13=new Aphorism("aphorism 13",R.mipmap.photo13);
        aphorismListl.add(aphorism13);
        Aphorism aphorism12=new Aphorism("aphorism 12",R.mipmap.photo12);
        aphorismListl.add(aphorism12);
        Aphorism aphorism1=new Aphorism("aphorism 1",R.mipmap.photo1);
        aphorismListl.add(aphorism1);
        Aphorism aphorism2=new Aphorism("aphorism 2",R.mipmap.photo2);
        aphorismListl.add(aphorism2);
        Aphorism aphorism3=new Aphorism("aphorism 3",R.mipmap.photo3);
        aphorismListl.add(aphorism3);
        Aphorism aphorism4=new Aphorism("aphorism 4",R.mipmap.photo4);
        aphorismListl.add(aphorism4);
        Aphorism aphorism5=new Aphorism("aphorism 5",R.mipmap.photo5);
        aphorismListl.add(aphorism5);
        Aphorism aphorism6=new Aphorism("aphorism 6",R.mipmap.photo6);
        aphorismListl.add(aphorism6);
        Aphorism aphorism7=new Aphorism("aphorism 7",R.mipmap.photo7);
        aphorismListl.add(aphorism7);
        Aphorism aphorism8=new Aphorism("aphorism 8",R.mipmap.photo8);
        aphorismListl.add(aphorism8);
        Aphorism aphorism9=new Aphorism("aphorism 9",R.mipmap.photo9);
        aphorismListl.add(aphorism9);
        Aphorism aphorism10=new Aphorism("aphorism 10",R.mipmap.photo10);
        aphorismListl.add(aphorism10);
        Aphorism aphorism11=new Aphorism("aphorism 11",R.mipmap.photo11);
        aphorismListl.add(aphorism11);












    }
}
