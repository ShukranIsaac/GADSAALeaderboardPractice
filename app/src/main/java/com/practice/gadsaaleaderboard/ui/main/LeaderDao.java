package com.practice.gadsaaleaderboard.ui.main;

import com.practice.gadsaaleaderboard.ui.main.models.Leader;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import io.reactivex.Completable;
import io.reactivex.Observable;

@Dao
public interface LeaderDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable insert(List<Leader> items);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable insert(Leader leader);

    @Query("SELECT * FROM leaders ORDER BY name, country DESC")
    Observable<List<Leader>> leaders();

    @Query("SELECT * FROM leaders ORDER BY name, country DESC")
    LiveData<List<Leader>> findAll();
}
