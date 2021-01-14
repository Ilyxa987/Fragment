package com.example.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button currTasks, comlTasks, impTasks;


    CurrentTasks currentTasks;
    CompleteTasks completeTasks;
    ImportatntTasks importatntTasks;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        currTasks = findViewById(R.id.curr_button);
        comlTasks = findViewById(R.id.compl_button);
        impTasks = findViewById(R.id.imp_button);

        currentTasks = new CurrentTasks();
        completeTasks = new CompleteTasks();
        importatntTasks = new ImportatntTasks();
        fragmentManager = getSupportFragmentManager();
        if (savedInstanceState == null){
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.container, currentTasks);
            fragmentTransaction.commit();
        }
        currTasks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container, currentTasks);
                fragmentTransaction.commit();
            }
        });
        comlTasks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container, completeTasks);
                fragmentTransaction.commit();
            }
        });
        impTasks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container, importatntTasks);
                fragmentTransaction.commit();
            }
        });
    }
}