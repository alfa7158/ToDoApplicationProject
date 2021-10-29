package com.example.todoapplicationproject.ViewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todoapplicationproject.data.ToDoModel
import com.example.todoapplicationproject.repoistries.TodDoRepoistory
import kotlinx.coroutines.launch

class ToDoViewModelAdapter:ViewModel() {

    private val todoRepoistory = TodDoRepoistory.getInstance()

    var todoTasks = todoRepoistory.getTasks()

    var selectedLiveData = MutableLiveData<ToDoModel>()

    fun updateItem(toDoModel: ToDoModel) {

        viewModelScope.launch {
            todoRepoistory.updateTasks(toDoModel)
        }
    }

    fun deleteItem(toDoModel: ToDoModel) {
        viewModelScope.launch {
            todoRepoistory.deleteTasks(toDoModel)
        }
    }
}