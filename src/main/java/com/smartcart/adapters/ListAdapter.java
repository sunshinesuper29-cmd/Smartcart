package com.smartcart.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.smartcart.ItemActivity;
import com.smartcart.R;
import com.smartcart.data.ListEntity;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder> {
    private List<ListEntity> lists = new ArrayList<>();
    private Context context;

    public ListAdapter(Context context) {
        this.context = context;
    }

    public void setList(List<ListEntity> listData) {
        this.lists = listData;
        notifyDataSetChanged();
    }

    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_card, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ListViewHolder holder, int position) {
        ListEntity list = lists.get(position);
        holder.title.setText(list.title);
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, ItemActivity.class);
            intent.putExtra("LIST_ID", list.listId);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return lists.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ListViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.textListTitle);
        }
    }
}