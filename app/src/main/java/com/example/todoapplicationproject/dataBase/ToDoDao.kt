package com.example.todoapplicationproject.dataBase

import androidx.room.*
import com.example.todoapplicationproject.data.ToDoModel
import kotlinx.coroutines.selects.select

@Dao
interface ToDoDao {
@Insert
suspend fun addToDo(toDoModel: ToDoModel)
@Query( "SELECT*FROM todomodel")
suspend fun getTodo(toDoModel: ToDoModel)

@Update
suspend fun updateToDo(toDoModel: ToDoModel)


@Delete
suspend fun deleteToDo(toDoModel: ToDoModel)
}