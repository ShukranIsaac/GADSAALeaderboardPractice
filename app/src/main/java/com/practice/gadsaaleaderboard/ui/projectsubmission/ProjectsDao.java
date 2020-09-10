package com.practice.gadsaaleaderboard.ui.projectsubmission;

import com.practice.gadsaaleaderboard.ui.projectsubmission.models.LeaderPayloadAttr;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import io.reactivex.Completable;

@Dao
public interface ProjectsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable insert(List<LeaderPayloadAttr> items);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable insert(LeaderPayloadAttr payloadAttr);

    @Query("SELECT * FROM projects")
    List<LeaderPayloadAttr> projects();

    @Query("SELECT * FROM projects ORDER BY firstName, lastName, email DESC")
    LiveData<List<LeaderPayloadAttr>> findAll();
}
