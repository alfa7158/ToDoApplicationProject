package com.example.todoapplicationproject.ViewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todoapplicationproject.data.ToDoModel
import com.example.todoapplicationproject.repoistries.TodDoRepoistory
import kotlinx.coroutines.launch

class ToDoViewModelAdapter:ViewModel() {

    private val todoRepoistory = TodDoRepoistory.getInstance()

    var selectedCategory = ""
    fun todoTasks(category: String) = todoRepoistory.getTasks(category)

    var selectedLiveData = MutableLiveData<ToDoModel>()

    fun updateTask(toDoModel: ToDoModel) {

        viewModelScope.launch {
            todoRepoistory.updateTasks(toDoModel)
        }
    }
    fun deleteTask(toDoModel: ToDoModel) {
        viewModelScope.launch {
            todoRepoistory.deleteTasks(toDoModel)
        }
    }


}