package com.example.asus.finaldesginer;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ASUS on 2018/3/1.
 */

public class MsgAdapter extends RecyclerView.Adapter<MsgAdapter.ViewHolder>{

   private List<String> mMsgList;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate
                (R.layout.comment_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String msg=mMsgList.get(position);
        holder.centerLayout.setVisibility(View.VISIBLE);
        holder.comment.setText(msg);

    }

    @Override
    public int getItemCount() {
        return mMsgList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        LinearLayout centerLayout;

        TextView comment;

        public ViewHolder(View itemView) {
            super(itemView);
            centerLayout=(LinearLayout)itemView.findViewById(R.id.center_layout);
            comment=(TextView)itemView.findViewById(R.id.center_comment);

        }
    }
    public MsgAdapter(List<String> msgList){
        mMsgList=msgList;
    }
}
