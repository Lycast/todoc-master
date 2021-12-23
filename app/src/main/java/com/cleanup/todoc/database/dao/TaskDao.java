package com.cleanup.todoc.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.cleanup.todoc.model.Task;

import java.util.List;

/**
 * Created by Lycast on 30/11/2021.
 */
@Dao
public interface TaskDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertTask(Task task);

    @Delete
    void deleteTask(Task task);

    @Query("SELECT * FROM Task")
    LiveData<List<Task>> getTasks();
}
