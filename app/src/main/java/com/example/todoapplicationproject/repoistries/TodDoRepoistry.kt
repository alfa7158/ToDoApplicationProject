package com.example.todoapplicationproject.repoistries

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.todoapplicationproject.data.ToDoModel
import com.example.todoapplicationproject.dataBase.ToDoDatabase
import java.lang.Exception

private const val Database_toDo = "todo"
class TodDoRepoistory(context: Context) {
    private val database:ToDoDatabase = Room.databaseBuilder(context,ToDoDatabase::class.java, Database_toDo
    ).fallbackToDestructiveMigration().build()

   private val toDoDao = database.toDoDao()
    fun getTasks() = toDoDao.getTodo()

    suspend fun addTasks(toDoModel: ToDoModel) = toDoDao.addToDo(toDoModel)
    suspend fun updateTasks(toDoModel: ToDoModel) = toDoDao.updateToDo(toDoModel)
    suspend fun deleteTasks(toDoModel: ToDoModel) = toDoDao.deleteToDo(toDoModel)


    companion object{

        private var companionInstance:TodDoRepoistory?=null
        fun init(context: Context){
            if(companionInstance==null){
                companionInstance = TodDoRepoistory(context)
            }
        }
        fun getInstance():TodDoRepoistory{

            return companionInstance?:throw Exception("Repository is Empty")
        }

    }

}