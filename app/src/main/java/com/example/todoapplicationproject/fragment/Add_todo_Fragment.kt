package com.example.todoapplicationproject.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.example.todoapplicationproject.R





class Add_todo_Fragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_todo_, container, false)

    }

    override fun onViewCreated(view: android.view.View, savedInstanceState: android.os.Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        val spinnerCategories = listOf("Important", "Mid-important", "less-Important")
//        val arrayAdapter =
//            ArrayAdapter(this, android.R.layout.simple_spinner_item, )


        val spinner: Spinner = view.findViewById(R.id.spinner4)



//        val spinnerArrayAdapter = ArrayAdapter(
//            spinner, android.R.layout.simple_spinner_item,
//            spinnerCategories
//        ) //selected item will look like a spinner set from XML
//
//        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
//        spinner.adapter = spinnerArrayAdapter


    }
}