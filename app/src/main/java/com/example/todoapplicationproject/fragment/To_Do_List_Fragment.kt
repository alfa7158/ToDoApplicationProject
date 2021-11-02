package com.example.todoapplicationproject.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapplicationproject.Adapter.ToDoAdapter
import com.example.todoapplicationproject.R
import com.example.todoapplicationproject.ViewModels.EditViewModel
import com.example.todoapplicationproject.ViewModels.ToDoViewModelAdapter
import com.example.todoapplicationproject.data.ToDoModel
import com.example.todoapplicationproject.repoistries.TodDoRepoistory
import com.google.android.material.floatingactionbutton.FloatingActionButton


class To_Do_List_Fragment : Fragment() {
private val toDoTasks = mutableListOf<ToDoModel>()
    private val listVieWModel:ToDoViewModelAdapter  by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_to__do__list_, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val ListFloatingButton:FloatingActionButton = view.findViewById(R.id.floatingButtonDes)
        val theBackButton:ImageView = view.findViewById(R.id.backButton)
        val toDoRecyclerView:RecyclerView = view.findViewById(R.id.toDo_Recyclerview)

        val layout: ConstraintLayout = view.findViewById(R.id.frameLayout3)
        val toDoAdapter = ToDoAdapter(toDoTasks,listVieWModel)
        when(listVieWModel.selectedCategory) {
            "Important" -> layout.setBackgroundResource(R.color.red)
            "Mid-Important" -> layout.setBackgroundResource(R.color.orange)
            "Less-Important" -> layout.setBackgroundResource(R.color.green)
        }

        toDoRecyclerView.adapter = toDoAdapter
        listVieWModel.todoTasks(listVieWModel.selectedCategory).observe(viewLifecycleOwner, Observer { it?.let{
            task ->
            toDoTasks.clear()
            toDoTasks.addAll(task)
            toDoAdapter.notifyDataSetChanged()

        } })

        ListFloatingButton.setOnClickListener(){

            findNavController().navigate(R.id.action_to_Do_List_Fragment_to_add_todo_Fragment)
        }
        theBackButton.setOnClickListener(){
            findNavController().navigate(R.id.action_to_Do_List_Fragment_to_main_select_Fragment)


        }

    }


}