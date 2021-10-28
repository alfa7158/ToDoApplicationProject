package com.example.todoapplicationproject.dataBase
import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.todoapplicationproject.data.ToDoModel

@Database(entities = [ToDoModel::class],version = 1)
abstract class ToDoDatabase: RoomDatabase() {

    abstract fun toDoDao(): ToDoDao

}
