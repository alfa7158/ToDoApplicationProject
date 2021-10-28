package com.example.todoapplicationproject.ViewModels

import androidx.lifecycle.ViewModel
import com.example.todoapplicationproject.repoistries.TodDoRepoistory

class TODoViewModel:ViewModel() {
    /**
     *    the line below to pass from Repository to view model.
     *     It is also, a variable for the data

     */
    var todoTasks = TodDoRepoistory.getInstance()
    //

}