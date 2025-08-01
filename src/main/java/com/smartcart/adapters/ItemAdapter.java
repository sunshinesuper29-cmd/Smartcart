package com.smartcart.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.smartcart.R;
import com.smartcart.data.ItemEntity;

import java.util.ArrayList;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {
    private List<ItemEntity> items = new ArrayList<>();
    private Context context;
    private int listId;

    public ItemAdapter(Context context, int listId) {
        this.context = context;
        this.listId = listId;
    }

    public void setItems(List<ItemEntity> itemData) {
        this.items = itemData;
        notifyDataSetChanged();
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_card, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        ItemEntity item = items.get(position);
        holder.name.setText(item.name);
        holder.checkBox.setChecked(item.isChecked);
        holder.checkBox.setOnCheckedChangeListener((b, c) -> item.isChecked = c);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        CheckBox checkBox;
        ItemViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.textItemName);
            checkBox = itemView.findViewById(R.id.checkboxItem);
        }
    }
}