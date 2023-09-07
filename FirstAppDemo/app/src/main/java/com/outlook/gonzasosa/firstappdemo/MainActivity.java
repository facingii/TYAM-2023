package com.outlook.gonzasosa.firstappdemo;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i ("FIEE", "OnCreate");
        setContentView (R.layout.activity_main);

        EditText edtName = findViewById (R.id.edtName);

        Button btnSend = findViewById (R.id.btnSend);
        btnSend.setOnClickListener (view -> Toast.makeText (this, edtName.getText().toString(), Toast.LENGTH_LONG ).show());

        ImageView imageView = findViewById (R.id.ivPicture);

        Button btnCamera = findViewById(R.id.btnOpenCamera);
        btnCamera.setOnClickListener (view -> {
            imageView.setImageResource (R.mipmap.ic_launcher_round);
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i ("FIEE", "OnStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i ("FIEE", "OnResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i ("FIEE", "OnPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i ("FIEE", "OnStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i ("FIEE", "OnDestroy");
    }
}