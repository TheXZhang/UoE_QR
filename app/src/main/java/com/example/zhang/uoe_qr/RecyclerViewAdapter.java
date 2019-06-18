package com.example.zhang.uoe_qr;

import android.content.Context;
import android.content.Intent;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;



public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext ;
    private List<Location> mData ;


    public RecyclerViewAdapter(Context mContext, List<Location> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view ;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.card_view_location,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        holder.tv_location_name.setText(mData.get(position).getName());
        holder.img_location_thumbnail.setImageResource(mData.get(position).getThumbnail());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                Display_qr_fragment qr_frag = new Display_qr_fragment();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.frag_container,qr_frag).addToBackStack(null).commit();
            }
        });



    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_location_name;
        ImageView img_location_thumbnail;
        CardView cardView ;

        public MyViewHolder(View itemView) {
            super(itemView);

            tv_location_name = (TextView) itemView.findViewById(R.id.location_name_id) ;
            img_location_thumbnail = (ImageView) itemView.findViewById(R.id.location_img_id);
            cardView = (CardView) itemView.findViewById(R.id.cardview_id);


        }
    }


}