package com.example.todoapplicationproject.Adapter

import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapplicationproject.R
import com.example.todoapplicationproject.ViewModels.ToDoViewModelAdapter
import com.example.todoapplicationproject.data.ToDoModel
import it.emperor.animatedcheckbox.AnimatedCheckBox
import java.text.SimpleDateFormat
import java.util.*

class ToDoAdapter(val tasks: List<ToDoModel>,
                  val viewModel:ToDoViewModelAdapter):
    RecyclerView.Adapter<ToDoAdapter.ToDoViewHolder>() {


    class ToDoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val taskTitle: TextView = view.findViewById(R.id.titleTextView)
        val taskDescription: TextView = view.findViewById(R.id.descripTextView)
        val taskDate:TextView = view.findViewById(R.id.TextViewDate)
        val taskTime:TextView = view.findViewById(R.id.timeTextView)
        val isDone: AnimatedCheckBox = view.findViewById(R.id.checkBoxView)
        val toDelete: ImageView = view.findViewById(R.id.DeleteImageView)
        val toEdit: ImageView = view.findViewById(R.id.editeImageView)
        val faceImage:ImageView = view.findViewById(R.id.faceImageView)


    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onBindViewHolder(holder: ToDoViewHolder, position: Int) {
        val theTasks = tasks[position]
        holder.taskTitle.text = theTasks.title
        holder.taskDescription.text = theTasks.description
        holder.isDone.setChecked(theTasks.checkBox,true)
        holder.taskDate.text = theTasks.date
        holder.taskTime.text = theTasks.time
        val simpleFormat = SimpleDateFormat("dd/MM/yyyy")
        val currentDate = simpleFormat.format(Date())
       Log.d("Date_here",currentDate)
        Log.d("Date_secNormalhere", theTasks.date)

        Log.d("spaceCheck",theTasks.date.toString().substring(0,2))
        Log.d("spaceCurrentSpace",currentDate.substring(0,1))



        var f_current = currentDate.indexOf("/")
        var s_taskDate = currentDate.lastIndexOf("/")


        println("I am here" + theTasks.date.toString())
        println("I am here currentDate" + currentDate.toString())


        if(theTasks.date.toString().substring(s_taskDate+1).toInt()>currentDate.toString().substring(s_taskDate+1).toInt()){
                       holder.faceImage.setImageResource(R.drawable.img_3)

        }else if( theTasks.date.toString().substring(f_current+1,s_taskDate).toInt()>=
            currentDate.toString().substring(f_current+1,s_taskDate).toInt() &&  theTasks.date.toString().substring(s_taskDate+1).toInt()>=
            currentDate.toString().substring(s_taskDate+1).toInt()){
                        holder.faceImage.setImageResource(R.drawable.img_3)


        }else{

                 holder.faceImage.setImageResource(R.drawable.img_1)

        }


//        if(theTasks.date.substring(0,f_current)<=
//            currentDate.toString().substring(0,f_current)
//            &&
//
//            theTasks.date.toString().substring(f_current+1,s_taskDate).toInt()>=
//            currentDate.toString().substring(f_current+1,s_taskDate).toInt()
//            &&
//            theTasks.date.toString().substring(s_taskDate+1).toInt()>=
//            currentDate.toString().substring(s_taskDate+1).toInt()
//
//        )  {
//
//            holder.faceImage.setImageResource(R.drawable.img_3)
//
//
//        }else{
//            holder.faceImage.setImageResource(R.drawable.img_1)
//
//        }



        holder.isDone.setOnClickListener() {

            theTasks.checkBox = !holder.isDone.isChecked()
            holder.isDone.setChecked(theTasks.checkBox)
            viewModel.updateTask(theTasks)

        }


        holder.toEdit.setOnClickListener() {
            viewModel.selectedLiveData.postValue(theTasks)
            it.findNavController().navigate(R.id.action_to_Do_List_Fragment_to_editFragment)

        }
        holder.toDelete.setOnClickListener() {
            viewModel.selectedLiveData.postValue(theTasks)
            it.findNavController().navigate(R.id.action_to_Do_List_Fragment_to_deletFragment)

        }




    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoViewHolder {
        return ToDoViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.fragment_to_do_text_,
                parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return tasks.size
    }


}


