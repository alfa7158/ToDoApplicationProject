package com.example.todoapplicationproject.data

import android.widget.CheckBox
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ToDoModel(
    val title:String,
    val description:String,
    val date:Int,
    val checkBox: Boolean,
    @PrimaryKey(autoGenerate = true)
    val id:Int = 0
)
