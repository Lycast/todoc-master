package com.cleanup.todoc.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.cleanup.todoc.model.Project;

import java.util.List;

/**
 * Created by Lycast on 13/12/2021.
 */
@Dao
public interface ProjectDao {

    @Query("SELECT * FROM projects")
    LiveData<List<Project>> getProjects();

    @Insert
    void insertProjects(Project... projects);


}
