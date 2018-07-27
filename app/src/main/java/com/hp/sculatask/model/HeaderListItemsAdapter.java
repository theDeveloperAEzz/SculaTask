package com.hp.sculatask.model;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hp.sculatask.MainActivity;
import com.hp.sculatask.R;

import java.util.ArrayList;

public class HeaderListItemsAdapter extends RecyclerView.Adapter<HeaderListItemsAdapter.ViewHolder> {
    Context context;
    private ArrayList<ItemRecycleHeader> objects;
    private int row_index = -1;

    //
    public HeaderListItemsAdapter(ArrayList<ItemRecycleHeader> objects) {
        this.objects = objects;
    }

    @NonNull
    @Override
    public HeaderListItemsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rec_header_item, parent, false);

        return new HeaderListItemsAdapter.ViewHolder(v);
    }

    @SuppressLint({"SetTextI18n", "ResourceAsColor"})
    @Override
    public void onBindViewHolder(@NonNull final HeaderListItemsAdapter.ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.textViewTitle.setText(objects.get(position).getTitle());
        if (!objects.get(position).getNotification().equals("")) {
            holder.textViewNotification.setVisibility(View.VISIBLE);
            holder.textViewNotification.setText(objects.get(position).getNotification());
        }
        holder.imageViewItem.setImageResource(objects.get(position).getImageId());
        itemBackground(holder, position);

    }


    @Override
    public int getItemCount() {
        return objects.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageViewItem;
        TextView textViewTitle, textViewNotification;
        LinearLayout rowRelativeLayout;

        ViewHolder(View v) {
            super(v);
            textViewTitle = v.findViewById(R.id.text_title);
            imageViewItem = v.findViewById(R.id.image_item);
            textViewNotification = v.findViewById(R.id.text_notification);
            rowRelativeLayout = v.findViewById(R.id.relative_item);
        }
    }

    private void itemBackground(final HeaderListItemsAdapter.ViewHolder holder, final int position) {
        if (objects.get(0).getTitle().equals("Contact Us")) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MainActivity.drawer.closeDrawer(Gravity.START);
                }
            });
        } else {
            holder.rowRelativeLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    row_index = position;
                    MainActivity.drawer.closeDrawer(Gravity.START);
                    notifyDataSetChanged();
                }
            });
            if (row_index == position) {
                holder.rowRelativeLayout.setBackgroundColor(R.color.color2);
            } else {
                holder.rowRelativeLayout.setBackgroundColor(android.R.color.transparent);
            }
        }

    }
}
