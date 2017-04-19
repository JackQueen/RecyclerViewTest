package com.wjq.recyclerviewtest;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017-04-19.
 */

public class Adapters {

    public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyHolder>{
        private ArrayList<Person> mPersons;
        private Context mContext;
        public MyRecyclerViewAdapter(ArrayList persons,Context context) {
            mPersons=persons;
            mContext=context;
        }

        @Override
        public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            return new MyHolder(LayoutInflater.from(mContext).inflate(R.layout.item, parent,false));
        }

        @Override
        public void onBindViewHolder(MyHolder holder, int position) {
            holder.mName.setText(mPersons.get(position).getName());
            Glide.with(mContext).load(mPersons.get(position).getPhoto()).into(holder.mPhoto);
        }

        @Override
        public int getItemCount() {
            return mPersons.size();
        }

        public class MyHolder extends RecyclerView.ViewHolder{
            private TextView mName;
            private ImageView mPhoto;
            public MyHolder(View itemView) {
                super(itemView);
                mPhoto= (ImageView) itemView.findViewById(R.id.img_photo);
                mName= (TextView) itemView.findViewById(R.id.tv_name);
            }
        }


    }
}
