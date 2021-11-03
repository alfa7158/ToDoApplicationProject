package com.example.todoapplicationproject.ViewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todoapplicationproject.data.ToDoModel
import com.example.todoapplicationproject.repoistries.TodDoRepoistory
import kotlinx.coroutines.launch

/**
 * in this class , we are passing the values from Repository to the view model
 */
class ToDoViewModelAdapter:ViewModel() {
    //here below,we are giving the viewModel the Repository function
    private val todoRepoistory = TodDoRepoistory.getInstance()

    var selectedCategory = ""
    //here below, we are giving the viewModel the Repository function

    fun todoTasks(category: String) = todoRepoistory.getTasks(category)
    //here below, we are giving the viewModel the Repository function

    var selectedLiveData = MutableLiveData<ToDoModel>()
    //here below, we are giving the viewModel the Repository function

    fun updateTask(toDoModel: ToDoModel) {

        viewModelScope.launch {
            todoRepoistory.updateTasks(toDoModel)
        }
    }
    //here below, we are giving the viewModel the Repository function

    fun deleteTask(toDoModel: ToDoModel) {
        viewModelScope.launch {
            todoRepoistory.deleteTasks(toDoModel)
        }
    }


}