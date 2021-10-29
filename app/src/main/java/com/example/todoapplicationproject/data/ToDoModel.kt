package com.example.todoapplicationproject.data

import android.widget.CheckBox
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ToDoModel(
    var title:String,
    var description:String,
    var checkBox: Boolean,
    val date:String,
    var category: String,
    var time:String,
    @PrimaryKey(autoGenerate = true)
    val id:Int = 0
)
