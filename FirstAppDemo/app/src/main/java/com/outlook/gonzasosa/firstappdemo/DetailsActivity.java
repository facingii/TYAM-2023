package com.outlook.gonzasosa.firstappdemo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.outlook.gonzasosa.firstappdemo.room.AppDatabase;
import com.outlook.gonzasosa.firstappdemo.room.Profile;
import com.outlook.gonzasosa.firstappdemo.room.ProfileDao;

public class DetailsActivity extends AppCompatActivity {
    private AppDatabase db;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        db = Room.databaseBuilder (getApplicationContext (), AppDatabase.class, "profiles")
                .build ();

        TextView tvName = findViewById (R.id.tvName);
        TextView tvLastName = findViewById (R.id.tvLastName);
        TextView tvPhone = findViewById (R.id.tvPhone);

//        Thread thread1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                ProfileDao dao1 = db.getProfileDao();
//                Profile prof = dao1.findByName ("Anne", "Hathaway");
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        Toast.makeText(getBaseContext(), prof.uid + " " +  prof.Name + " " + prof.LastName,
//                                Toast.LENGTH_SHORT).show();
//                    }
//                });
//            }
//        });
//        thread1.start();

        Intent intent = getIntent ();
        if (intent != null) {
            Bundle bundle = intent.getExtras ();
            if (bundle != null) {
                tvName.setText (bundle.getString (MainActivity.NAME, ""));
                tvLastName.setText (bundle.getString (MainActivity.LASTNAME, ""));
                tvPhone.setText (bundle.getString (MainActivity.PHONE, ""));
            }
        }
        
        Button btn = findViewById (R.id.btnSave);
        btn.setOnClickListener (view -> {
            Profile profile = new Profile ();
            profile.Name = tvName.getText().toString ();
            profile.LastName = tvLastName.getText().toString ();
            profile.Phone = tvPhone.getText().toString ();

            ProfileDao dao = db.getProfileDao ();

            Thread thread = new Thread(new Runnable() {
                @Override
                public void run () {
                    dao.insertAll (profile);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText (getBaseContext(), "All data saved!", Toast.LENGTH_LONG).show();
                        }
                    });
                }
            });
            thread.start ();
        });
    }
}
