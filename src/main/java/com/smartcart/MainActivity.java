package com.smartcart;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.smartcart.data.ListDao;
import com.smartcart.data.ListEntity;
import com.smartcart.data.SmartCartDatabase;
import com.smartcart.util.ThemeManager;
import com.smartcart.adapters.ListAdapter;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private SmartCartDatabase db;
    private ListDao listDao;
    private RecyclerView recyclerView;
    private ListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ThemeManager.applyTheme(this);
        setContentView(R.layout.activity_main);

        db = SmartCartDatabase.getInstance(this);
        listDao = db.listDao();

        recyclerView = findViewById(R.id.listRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new ListAdapter(this);
        recyclerView.setAdapter(adapter);

        listDao.getAllLists().observe(this, lists -> adapter.setList(lists));

        findViewById(R.id.btnAddList).setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, ListActivity.class));
        });
    }
}