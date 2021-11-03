package com.example.todoapplicationproject.data

import android.widget.CheckBox
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * In this the the date class where we have the Entity and the primaryKey to make sure that
 * every raw has unique value
 */
@Entity
data class ToDoModel(

    var title:String,
    var description:String,
    var checkBox: Boolean,
    var date:String,
    var category: String,
    var time:String,
    @PrimaryKey(autoGenerate = true)
    val id:Int = 0
)
