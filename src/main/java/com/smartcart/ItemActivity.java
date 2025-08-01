package com.smartcart;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.smartcart.adapters.ItemAdapter;
import com.smartcart.data.SmartCartDatabase;
import com.smartcart.util.ThemeManager;

public class ItemActivity extends AppCompatActivity {
    private int listId;
    private SmartCartDatabase db;
    private RecyclerView recyclerView;
    private ItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ThemeManager.applyTheme(this);
        setContentView(R.layout.activity_items);

        listId = getIntent().getIntExtra("LIST_ID", -1);
        db = SmartCartDatabase.getInstance(this);

        recyclerView = findViewById(R.id.itemRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new ItemAdapter(this, listId);
        recyclerView.setAdapter(adapter);

        db.itemDao().getItemsByList(listId).observe(this, adapter::setItems);
    }
}