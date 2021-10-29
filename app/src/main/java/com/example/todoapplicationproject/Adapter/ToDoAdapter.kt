package com.example.todoapplicationproject.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapplicationproject.R
import com.example.todoapplicationproject.ViewModels.ToDoViewModelAdapter
import com.example.todoapplicationproject.data.ToDoModel

class ToDoAdapter(val tasks: List<ToDoModel>,
                  val viewModel:ToDoViewModelAdapter):
    RecyclerView.Adapter<ToDoAdapter.ToDoViewHolder>() {


    class ToDoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val taskTitle: TextView = view.findViewById(R.id.titleTextView)
        val taskDescription: TextView = view.findViewById(R.id.descripTextView)
        val isDone: CheckBox = view.findViewById(R.id.checkBoxView)
        val toDelete: ImageView = view.findViewById(R.id.DeleteImageView)
        val toEdit: ImageView = view.findViewById(R.id.editeImageView)


    }

    override fun onBindViewHolder(holder: ToDoViewHolder, position: Int) {
        val theTasks = tasks[position]
        holder.taskTitle.text = theTasks.title
        holder.taskDescription.text = theTasks.description
        holder.isDone.isChecked = theTasks.checkBox


        holder.isDone.setOnClickListener() {

            theTasks.checkBox = holder.isDone.isChecked
            viewModel.updateItem(theTasks)

        }

        holder.toEdit.setOnClickListener() {
            viewModel.selectedLiveData.postValue(theTasks)
            it.findNavController().navigate(R.id.action_to_do_text_Fragment_to_editFragment)

        }
        holder.toDelete.setOnClickListener() {
            viewModel.selectedLiveData.postValue(theTasks)
            it.findNavController().navigate(R.id.action_to_do_text_Fragment_to_deletFragment)

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


