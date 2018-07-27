package com.hp.sculatask.model;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hp.sculatask.R;

import java.util.ArrayList;

public class HeaderListNotificationAdapter extends RecyclerView.Adapter<HeaderListNotificationAdapter.ViewHolder> {
    Context context;
    ArrayList<NotificationItemRecycleHeader> objects;

    //
    public HeaderListNotificationAdapter(ArrayList<NotificationItemRecycleHeader> objects) {
        this.objects = objects;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;

        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rec_header_notification_item, parent, false);

        return new ViewHolder(v);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.textViewHeader.setText(objects.get(position).getNumber());
        holder.imageViewHeader.setImageResource(objects.get(position).getImageId());
    }

    @Override
    public int getItemCount() {
        return objects.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageViewHeader;
        TextView textViewHeader;

        ViewHolder(View v) {
            super(v);
            textViewHeader=v.findViewById(R.id.textHeader);
            imageViewHeader=v.findViewById(R.id.imageViewItemHeader);

        }
    }

}
