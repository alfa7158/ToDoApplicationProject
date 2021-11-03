package com.example.todoapplicationproject.ViewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todoapplicationproject.data.ToDoModel
import com.example.todoapplicationproject.repoistries.TodDoRepoistory
import kotlinx.coroutines.launch

class AddViewModel : ViewModel() {
    private val todoRepoistory = TodDoRepoistory.getInstance()

    var selectedLiveData = MutableLiveData<ToDoModel>()

    /**
     * here below we are creating a function that takes the task details value
     */
    fun addToDO(
        title: String, description: String, isChecked: Boolean, date: String, categories: String,
        time: String
    ) {
        //here we are passing the values to make it work in the background
        viewModelScope.launch {
            todoRepoistory.addTasks(
                ToDoModel(
                    title,
                    description,
                    isChecked,
                    date,
                    categories,
                    time
                )
            )
        }
    }

}

