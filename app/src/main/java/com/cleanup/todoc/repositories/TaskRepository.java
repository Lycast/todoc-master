package com.cleanup.todoc.repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.cleanup.todoc.database.dao.ProjectDao;
import com.cleanup.todoc.database.dao.TaskDao;
import com.cleanup.todoc.model.Project;
import com.cleanup.todoc.model.Task;
import com.cleanup.todoc.database.RoomDatabase;

import java.util.List;

/**
 * Created by Lycast on 30/11/2021.
 */
public class TaskRepository {

    private final TaskDao taskDao;
    private final LiveData<List<Task>> allTasks;
    private final ProjectDao projectDao;
    private final LiveData<List<Project>> allProjects;

    public TaskRepository(Application application) {
        RoomDatabase db = RoomDatabase.getDatabase(application);
        taskDao = db.taskDao();
        allTasks = taskDao.getTasks();
        projectDao = db.projectDao();
        allProjects = projectDao.getProjects();
    }

    public LiveData<List<Task>> getAllTasks() {
        return allTasks;
    }
    public LiveData<List<Project>> getAllProjects() { return allProjects; }

    public void insert(Task task) {
        RoomDatabase.databaseWriteExecutor.execute(() -> taskDao.insertTask(task));
    }

    public void delete(Task task) {
        RoomDatabase.databaseWriteExecutor.execute(() -> taskDao.deleteTask(task));
    }
}
