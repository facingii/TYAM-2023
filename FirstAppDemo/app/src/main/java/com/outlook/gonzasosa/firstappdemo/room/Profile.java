package com.outlook.gonzasosa.firstappdemo.room;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Profile {
    @PrimaryKey (autoGenerate = true)
    public int uid;

    @ColumnInfo (name = "name")
    public String Name;

    @ColumnInfo (name = "last_name")
    public String LastName;

    @ColumnInfo (name = "phone")
    public String Phone;
}
