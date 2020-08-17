package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.myapplication.dao.EducationDao;

public class MainActivity extends AppCompatActivity {

    private StudentRecyclerAdapter adapter;
    private EducationSource educationSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        initRecyclerView();
    }

    // инициализация списка
    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        EducationDao educationDao = App
                .getInstance()
                .getEducationDao();
        educationSource = new EducationSource(educationDao);

        adapter = new StudentRecyclerAdapter(educationSource, this);
        recyclerView.setAdapter(adapter);
    }
}