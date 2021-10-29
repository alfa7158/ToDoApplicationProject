package com.example.todoapplicationproject.ViewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todoapplicationproject.data.ToDoModel
import com.example.todoapplicationproject.repoistries.TodDoRepoistory
import kotlinx.coroutines.launch

class AddViewModel:ViewModel() {
private val todoRepoistory = TodDoRepoistory.getInstance()

var todoTasks = todoRepoistory.getTasks()

var selectedLiveData = MutableLiveData<ToDoModel>()

fun addToDO(title:String, description:String, date:String, isChecked:Boolean, categories:String,time:Double)   {

    viewModelScope.launch {
        todoRepoistory.addTasks(
            ToDoModel(
            title,
            description,
            date,
            isChecked,
            categories,
            time
            )
        )
    }
}

}

