package com.example.asus.finaldesginer;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class AphorismActivity extends AppCompatActivity {
    public static final String APHORISM_NAME = "come_on";

    public static final String APHORISM_IMAGE_ID = "aphorism_image_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aphorism);
        Intent intent = getIntent();
        String aphorismName = intent.getStringExtra(APHORISM_NAME);
        int aphorismImageId = intent.getIntExtra(APHORISM_IMAGE_ID, 0);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        ImageView aphorismImageView = (ImageView) findViewById(R.id.aphorism_image_view);
        TextView aphorismContentText = (TextView) findViewById(R.id.aphorism_content_text);
        FloatingActionButton mComment=(FloatingActionButton) findViewById(R.id.comment);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        collapsingToolbarLayout.setTitle(aphorismName);
        Glide.with(this).load(aphorismImageId).into(aphorismImageView);
        String aphorismContent = generateAphorismContent(aphorismName);
        aphorismContentText.setText(aphorismContent);
        mComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(AphorismActivity.this,CommentActivity.class);
                startActivity(intent1);
            }
        });
    }

    private String generateAphorismContent(String aphorismName) {
        StringBuilder aphorismContent = new StringBuilder();
        for (int i = 0; i < 500; i++) {
            aphorismContent.append(aphorismName);
        }
       return aphorismContent.toString();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}




