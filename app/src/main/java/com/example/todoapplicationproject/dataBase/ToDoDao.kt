package com.example.todoapplicationproject.dataBase

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.todoapplicationproject.data.ToDoModel
import kotlinx.coroutines.selects.select

/**
 * This the Dao Interface
 * In this class we have three functions
 * 1. addToDo,  its job is to insert the task or
 * todo in the the database
 * 2. getTodo, its job is to get the added tasks
 * 3. updateToDo, its job is to update the tasks
 * 4. deleteToDo, its job is to delete the tasks
 */
@Dao
interface ToDoDao {
@Insert
suspend fun addToDo(toDoModel: ToDoModel)
@Query( "SELECT*FROM todomodel WHERE category = :category")
 fun getTodo(category: String):LiveData<List<ToDoModel>>

@Update
suspend fun updateToDo(toDoModel: ToDoModel)


@Delete
suspend fun deleteToDo(toDoModel: ToDoModel)
}