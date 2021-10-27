package com.example.todoapplicationproject.dataBase
import androidx.room.Database
import androidx.room.RoomDatabase
@Database(entities = [ToDoDatabase::class],version = 1)
abstract class ToDoDatabase: RoomDatabase() {

    abstract fun toDoDao(): ToDoDao

}
