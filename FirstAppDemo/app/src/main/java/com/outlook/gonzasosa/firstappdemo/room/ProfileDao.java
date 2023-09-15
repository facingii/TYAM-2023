package com.outlook.gonzasosa.firstappdemo.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ProfileDao {
    @Query ("SELECT * FROM profile")
    List<Profile> getAllProfiles ();

    @Query ("SELECT * FROM Profile WHERE name LIKE :name AND last_name LIKE :lastname LIMIT 1")
    Profile findByName (String name, String lastname);

    @Insert
    void insertAll (Profile...profiles);

    @Delete
    void delete (Profile profile);

}
