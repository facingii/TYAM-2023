package com.outlook.gonzasosa.firstappdemo.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database (entities = {Profile.class}, version = 2)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ProfileDao getProfileDao ();
}
