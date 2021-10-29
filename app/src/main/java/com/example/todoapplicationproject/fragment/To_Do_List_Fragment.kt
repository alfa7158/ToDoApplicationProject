package com.example.todoapplicationproject.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapplicationproject.Adapter.ToDoAdapter
import com.example.todoapplicationproject.R
import com.example.todoapplicationproject.ViewModels.EditViewModel
import com.example.todoapplicationproject.ViewModels.ToDoViewModelAdapter
import com.example.todoapplicationproject.data.ToDoModel
import com.example.todoapplicationproject.repoistries.TodDoRepoistory


class To_Do_List_Fragment : Fragment() {
private val toDoTasks = mutableListOf<ToDoModel>
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

        val toDoRecyclerView:RecyclerView = view.findViewById(R.id.toDo_Recyclerview)
        val toDoAdapter = ToDoAdapter(toDoTasks,listVieWModel)
        toDoRecyclerView.adapter = toDoAdapter
        listVieWModel.todoTasks.observe(viewLifecycleOwner, Observer { it?.let{
            task ->
            toDoTasks.clear()
            toDoTasks.addAll(task)
            toDoAdapter.notifyDataSetChanged()

        } })

    }


}