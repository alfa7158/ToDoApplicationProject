package com.example.todoapplicationproject.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.todoapplicationproject.R
import com.example.todoapplicationproject.ViewModels.DeleteViewModel
import com.example.todoapplicationproject.ViewModels.EditViewModel
import com.example.todoapplicationproject.data.ToDoModel


class DeleteFragment : Fragment() {
    private lateinit var selectedTasks: ToDoModel
    private val deleteViewModel: DeleteViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_delet, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val titleTextView: TextView = view.findViewById(R.id.deletTextView_title)
        val descTextView: TextView = view.findViewById(R.id.deleteTextView_decrip)
        val dateTextView: TextView = view.findViewById(R.id.deleteTextView_date)
        val timeTextView: TextView = view.findViewById(R.id.deleteTextView_time)
        val deleteButton: Button = view.findViewById(R.id.editButton)


        deleteViewModel.selectedLiveData.observe(viewLifecycleOwner, Observer { it?.let{task ->


            titleTextView.text = task.title
            descTextView.text = task.description
            dateTextView.text = task.date
            timeTextView.text = task.time
            selectedTasks = task



        } })

        deleteButton.setOnClickListener(){
            deleteViewModel.deleteTask(selectedTasks)
            findNavController().navigate(R.id.action_deletFragment_to_to_Do_List_Fragment)

        }






    }
    }



