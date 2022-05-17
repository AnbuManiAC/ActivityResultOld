package com.example.activityrestoreinstancesample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("msg","Created");

        View shareButton = findViewById(R.id.buttonShare);
        shareButton.setOnClickListener(view -> {
            Intent share = new Intent(Intent.ACTION_SEND);
            share.setType("*/*");
            startActivity(share);
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("msg","Started");

    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d("msg","Resumed");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("msg","Paused");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("msg","Restarted");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("msg","Stopped");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("msg","Destroyed");

    }
}