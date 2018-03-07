package com.example.asus.finaldesginer;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by ASUS on 2018/2/25.
 */

public  class AphorismAdapter extends RecyclerView.Adapter<AphorismAdapter.ViewHolder> {

    private Context mContext;

    private List<Aphorism> mAphorismList;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(mContext==null) {
            mContext=parent.getContext();
        }
        View view= LayoutInflater.from(mContext).inflate(R.layout.aphorism_item,parent,false
        );
        final ViewHolder holder=new ViewHolder(view);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position=holder.getAdapterPosition();
                Aphorism aphorism=mAphorismList.get(position);
                Intent intent=new Intent(mContext,AphorismActivity.class);
                intent.putExtra(AphorismActivity.APHORISM_NAME,aphorism.getName());
                intent.putExtra(AphorismActivity.APHORISM_IMAGE_ID,aphorism.getImageId());
                mContext.startActivity(intent);
            }
        });

        return holder;

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Aphorism aphorism=mAphorismList.get(position);
        holder.aphorismName.setText(aphorism.getName());
        Glide.with(mContext).load(aphorism.getImageId()).into(holder.aphorismImage);
    }

    @Override
    public int getItemCount() {
        return mAphorismList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        ImageView aphorismImage;
        TextView aphorismName;
        CheckBox checkBox;

        public ViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView;
            aphorismImage = (ImageView) itemView.findViewById(R.id.aphorism_image);
            aphorismName = (TextView) itemView.findViewById(R.id.aphorism_name);
            checkBox=(CheckBox)itemView.findViewById(R.id.id_check);
        }
    }
        public AphorismAdapter(List<Aphorism> aphorismList){

            mAphorismList=aphorismList;

        }

    }

