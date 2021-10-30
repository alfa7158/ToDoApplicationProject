package com.example.todoapplicationproject.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.todoapplicationproject.R
import com.example.todoapplicationproject.ViewModels.EditViewModel
import com.example.todoapplicationproject.data.ToDoModel


class editFragment : Fragment() {
    private lateinit var selectedTasks:ToDoModel
    private val editViewModel:EditViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_edit, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val titleToEdit:EditText = view.findViewById(R.id.editEditeText_title)
        val descToEdit:EditText = view.findViewById(R.id.editEditeText_decrip)
        val dateToEdit:EditText = view.findViewById(R.id.editEditeText_date)
        val timeToEdit:EditText = view.findViewById(R.id.editEditeText_time)
        val editButton:Button = view.findViewById(R.id.editButton)


        editViewModel.selectedLiveData.observe(viewLifecycleOwner, Observer { it?.let{task ->


            titleToEdit.text = task.title
            descToEdit.text = task.description
            dateToEdit.text = task.date
            timeToEdit.text = task.time
            selectedTasks = task



        } })

        editButton.setOnClickListener(){
            editViewModel.updateTask(selectedTasks)
            findNavController().navigate(R.id.action_editFragment_to_to_Do_List_Fragment)

        }






    }



}