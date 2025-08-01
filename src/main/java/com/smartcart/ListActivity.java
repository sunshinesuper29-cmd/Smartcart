package com.smartcart;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.smartcart.data.ListEntity;
import com.smartcart.data.SmartCartDatabase;
import com.smartcart.util.ThemeManager;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ListActivity extends AppCompatActivity {
    private EditText titleField;
    private Button saveButton;
    private SmartCartDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ThemeManager.applyTheme(this);
        setContentView(R.layout.activity_list);

        db = SmartCartDatabase.getInstance(this);

        titleField = findViewById(R.id.editListTitle);
        saveButton = findViewById(R.id.btnSaveList);

        saveButton.setOnClickListener(v -> {
            String title = titleField.getText().toString();
            ListEntity list = new ListEntity();
            list.title = title;
            list.creationDate = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
            list.isShared = false;
            list.priorityLevel = "Medium";
            db.listDao().insertList(list);
            finish();
        });
    }
}