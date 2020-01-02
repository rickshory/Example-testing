package com.example.android.architecture.blueprints.todoapp.source

import androidx.lifecycle.MutableLiveData
import com.example.android.architecture.blueprints.todoapp.data.Task
import com.example.android.architecture.blueprints.todoapp.data.source.TasksRepository

class FakeAndroidTestRepository : TasksRepository {
    var tasksServiceData: LinkedHashMap<String, Task> = LinkedHashMap()
    private var shouldReturnError = false
    private val observableTasks = MutableLiveData<Result<List<Task>>>()

}