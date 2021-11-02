package com.example.todoapplicationproject.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapplicationproject.R
import com.example.todoapplicationproject.ViewModels.ToDoViewModelAdapter
import com.example.todoapplicationproject.data.ToDoModel
import com.google.android.material.floatingactionbutton.FloatingActionButton


class Main_select_Fragment : Fragment() {
    private lateinit var selectedTasks: ToDoModel

    private val mainViewModel: ToDoViewModelAdapter by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_select_, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val importantButton:Button= view.findViewById(R.id.ImportantButton)
        val mid_importantButton:Button= view.findViewById(R.id.midImportant_button)
        val less_importantButton:Button= view.findViewById(R.id.LessImportant_button)
        val floatingAddButton: FloatingActionButton = view.findViewById(R.id.floatingActionButtonAdd)



        importantButton.setOnClickListener(){
            mainViewModel.selectedCategory = "Important"

            findNavController().navigate(R.id.action_main_select_Fragment_to_to_Do_List_Fragment)

        }
        mid_importantButton.setOnClickListener(){
            mainViewModel.selectedCategory = "Mid-Important"

            findNavController().navigate(R.id.action_main_select_Fragment_to_to_Do_List_Fragment)


        }
        less_importantButton.setOnClickListener(){
            mainViewModel.selectedCategory = "Less-Important"
            findNavController().navigate(R.id.action_main_select_Fragment_to_to_Do_List_Fragment)
            view
        }
        floatingAddButton.setOnClickListener(){
            findNavController().navigate(R.id.action_main_select_Fragment_to_add_todo_Fragment)
        }


    }


}