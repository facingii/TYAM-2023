package com.outlook.gonzasosa.firstappdemo;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private final static String NAME = "name";
    private final static String LASTNAME  = "lastname";
    private final static String PHONE  = "phone";
    private final static String IMAGELOADED = "loaded";

    EditText edtName;
    EditText edtLastname;
    EditText edtPhone;

    ImageView imageView;
    boolean imageLoaded;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i ("FIEE", "OnCreate");
        setContentView (R.layout.activity_main);

        edtName = findViewById (R.id.edtName);
        edtLastname = findViewById (R.id.edtLastname);
        edtPhone = findViewById (R.id.edtPhone);

        Button btnSend = findViewById (R.id.btnSend);
        btnSend.setOnClickListener (view -> Toast.makeText (this, edtName.getText().toString(), Toast.LENGTH_LONG ).show());

        imageView = findViewById (R.id.ivPicture);

        Button btnCamera = findViewById(R.id.btnOpenCamera);
        btnCamera.setOnClickListener (view -> {
            imageView.setImageResource (R.mipmap.ic_launcher_round);
            imageLoaded = true;
        });

    }

    @Override
    protected void onSaveInstanceState (@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString (NAME, edtName.getText().toString());
        outState.putString (LASTNAME, edtLastname.getText().toString());
        outState.putString (PHONE, edtPhone.getText().toString());
        outState.putBoolean (IMAGELOADED, imageLoaded);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        String name = savedInstanceState.getString (NAME, "");
        edtName.setText (name);

        String lastName = savedInstanceState.getString (LASTNAME, "");
        edtLastname.setText (lastName);

        String phone = savedInstanceState.getString (PHONE, "");
        edtPhone.setText (phone);

        Boolean imageLoaded = savedInstanceState.getBoolean (IMAGELOADED, false);
        if (imageLoaded) {
            imageView.setImageResource (R.mipmap.ic_launcher_round);
            imageLoaded = true;
        }
    }
}