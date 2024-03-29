package com.outlook.gonzasosa.firstappdemo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    final static String NAME = "name";
    final static String LASTNAME  = "lastname";
    final static String PHONE  = "phone";
    private final static String IMAGELOADED = "loaded";

    EditText edtName;
    EditText edtLastName;
    EditText edtPhone;

    Button btnSearch;

    ImageView imageView;
    boolean imageLoaded;

    SharedPreferences preferences;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i ("FIEE", "OnCreate");
        setContentView (R.layout.activity_main);

        edtName = findViewById (R.id.edtName);
        edtLastName = findViewById (R.id.edtLastname);
        edtPhone = findViewById (R.id.edtPhone);
        btnSearch = findViewById(R.id.btnSearch);

        Button btnSend = findViewById (R.id.btnSend);
        btnSend.setOnClickListener (view -> Toast.makeText (this, edtName.getText().toString(), Toast.LENGTH_LONG ).show());

        imageView = findViewById (R.id.ivPicture);

        Button btnCamera = findViewById(R.id.btnOpenCamera);
        btnCamera.setOnClickListener (view -> {
            imageView.setImageResource (R.mipmap.ic_launcher_round);
            imageLoaded = true;
        });

        btnSearch.setOnClickListener (view -> {
            Intent intent = new Intent (getBaseContext (), DetailsActivity.class);
            intent.putExtra (NAME, edtName.getText().toString ());
            intent.putExtra (LASTNAME, edtLastName.getText().toString ());
            intent.putExtra (PHONE, edtPhone.getText().toString ());

            startActivity (intent);
        });
    }


    @Override
    protected void onStop() {
        super.onStop();

        preferences = getPreferences (MODE_PRIVATE);
        var editor = preferences.edit ();
        editor.putString (NAME, edtName.getText().toString ());
        editor.putString (LASTNAME, edtLastName.getText().toString ());
        editor.putString (PHONE, edtPhone.getText().toString ());
        editor.apply ();
    }

    @Override
    protected void onSaveInstanceState (@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString (NAME, edtName.getText().toString());
        outState.putString (LASTNAME, edtLastName.getText().toString());
        outState.putString (PHONE, edtPhone.getText().toString());
        outState.putBoolean (IMAGELOADED, imageLoaded);
    }

    @Override
    protected void onResume () {
        super.onResume ();

        preferences = getPreferences (MODE_PRIVATE);
        if (preferences.contains (NAME)) {
            var name = preferences.getString (NAME, "");
            edtName.setText (name);
        }

        if (preferences.contains (LASTNAME)) {
            var lastname = preferences.getString (LASTNAME, "");
            edtLastName.setText (lastname);
        }

        if (preferences.contains (PHONE)) {
            var phone = preferences.getString (PHONE, "");
            edtPhone.setText (phone);
        }
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        String name = savedInstanceState.getString (NAME, "");
        edtName.setText (name);

        String lastName = savedInstanceState.getString (LASTNAME, "");
        edtLastName.setText (lastName);

        String phone = savedInstanceState.getString (PHONE, "");
        edtPhone.setText (phone);

        boolean imageLoaded = savedInstanceState.getBoolean (IMAGELOADED, false);
        if (imageLoaded) {
            imageView.setImageResource (R.mipmap.ic_launcher_round);
            imageLoaded = true;
        }
    }
}