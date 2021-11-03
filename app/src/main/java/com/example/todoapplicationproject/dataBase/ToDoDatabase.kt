package com.example.todoapplicationproject.dataBase
import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.todoapplicationproject.data.ToDoModel

/**
 * This the Database class, where we pass to it the entity and the Dao functionality
 */
@Database(entities = [ToDoModel::class],version = 1)
abstract class ToDoDatabase: RoomDatabase() {

    abstract fun toDoDao(): ToDoDao

}
