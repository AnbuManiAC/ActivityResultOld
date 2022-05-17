package com.example.restorestatesample;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button submit;
    Button share;
    TextView textView;
    int count=0;
    Bitmap photo;

    static final int REQUEST_IMAGE_CAPTURE = 1;
    ImageView profileImage;
    Button capture;

    public boolean hasCamera(){
        return getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY);
    }

    public void launchCamera(View view){
        Intent camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(camera, REQUEST_IMAGE_CAPTURE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            photo = (Bitmap) extras.get("data");
            profileImage.setImageBitmap(photo);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("msg","OnCreate");
        submit = findViewById(R.id.submit);
        textView = findViewById(R.id.counter);
        textView.setText(String.valueOf(count));
        share = findViewById(R.id.share);
        capture = findViewById(R.id.capture);
        profileImage = findViewById(R.id.imageView);

        if(!hasCamera())
            capture.setEnabled(false);



        if(savedInstanceState!=null){
            Log.d("msg","Restoring in Create");
            EditText text = findViewById(R.id.name);
            text.setText(savedInstanceState.getString("saved"));
            photo = savedInstanceState.getParcelable("bitmap");
            profileImage.setImageBitmap(photo);
        }

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count = Integer.valueOf(textView.getText().toString())+1;
                textView.setText(String.valueOf(count));
            }
        });
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent share = new Intent(Intent.ACTION_SEND);
                share.setType("*/*");
                startActivity(share);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("msg","OnStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("msg","OnResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("msg","OnPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("msg","OnStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("msg","OnRestart");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("msg","OnSave");
        EditText text = findViewById(R.id.name);
        String textToSave = text.getText().toString();
        outState.putString("saved",textToSave);
        outState.putParcelable("bitmap",photo);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d("msg","OnRestore");

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("msg","OnDestroy");

    }
}