package com.practice.gadsaaleaderboard.common.room;

import android.content.Context;

import com.practice.gadsaaleaderboard.ui.main.Leader;
import com.practice.gadsaaleaderboard.ui.main.LeaderDao;
import com.practice.gadsaaleaderboard.ui.projectsubmission.LeaderPayloadAttr;
import com.practice.gadsaaleaderboard.ui.projectsubmission.ProjectsDao;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Leader.class, LeaderPayloadAttr.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase instance;
    public abstract LeaderDao leaders();
    public abstract ProjectsDao projects();

    public static AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class,
                    "gads_aad_database_2020.db").fallbackToDestructiveMigration()
                    .addCallback(callback).build();
        }
        return instance;
    }

    private static RoomDatabase.Callback callback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
        }
    };

    public static void destroy() {
        instance = null;
    }
}
