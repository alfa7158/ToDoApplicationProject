package com.example.todoapplicationproject.fragment

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.icu.text.SimpleDateFormat
import android.icu.util.Calendar
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.fragment.app.activityViewModels
import com.example.todoapplicationproject.R
import com.example.todoapplicationproject.ViewModels.AddViewModel
import com.example.todoapplicationproject.data.ToDoModel


class Add_todo_Fragment : Fragment() {
    private lateinit var selectedTasks: ToDoModel
    private val addViewModel: AddViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_todo_, container, false)

    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onViewCreated(view: android.view.View, savedInstanceState: android.os.Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        val spinnerCategories = listOf("Important", "Mid-important", "less-Important")
//        val arrayAdapter =
//            ArrayAdapter(this, android.R.layout.simple_spinner_item, )


        val spinner:Spinner = view.findViewById(R.id.spinner4)
        val mPickTimeBtn = view.findViewById<Button>(R.id.pickTimeBtn)
        val textViewTime   = view.findViewById<TextView>(R.id.timeTv)
        val DatePicker = view.findViewById<Button>(R.id.pickDateBtn)
        val DatetextView  = view.findViewById<TextView>(R.id.dateTv)
        val saveButton:Button = view.findViewById(R.id.save_button)
        val titleEditText:EditText = view.findViewById(R.id.titleEditText)
        val descriptionEditText:EditText = view.findViewById(R.id.decriptionEditText)
        val isDoneCheckBox:CheckBox = view.findViewById(R.id.checkBoxView)


        mPickTimeBtn.setOnClickListener {
            val cal = Calendar.getInstance()
            val timeSetListener = TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
                cal.set(Calendar.HOUR_OF_DAY, hour)
                cal.set(Calendar.MINUTE, minute)
                textViewTime.text = SimpleDateFormat("HH:mm").format(cal.time)
            }
            TimePickerDialog(context, timeSetListener, cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), true).show()
        }


        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        DatePicker.setOnClickListener {

            val dpd = DatePickerDialog(requireContext(), DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                DatetextView.setText("" + dayOfMonth + "/" + month + "/ " + year)
            }, year, month, day)
            dpd.show()

        }

//            var title:String,
//    var description:String,
//    var checkBox: Boolean,
//    val date:String,
//    var category: String,
//    var time:Double,
        saveButton.setOnClickListener(){
            val title = titleEditText.text.toString()
            val  description = descriptionEditText.text.toString()
            val isdone = isDoneCheckBox.isChecked
            val date = DatetextView.text.toString()
            val spiner = spinner.toString()
            val time = textViewTime.text.toString()



            addViewModel.addToDO(title, description, date,isdone,spiner,time)

        }










//        val spinnerArrayAdapter = ArrayAdapter(
//            spinner, android.R.layout.simple_spinner_item,
//            spinnerCategories
//        ) //selected item will look like a spinner set from XML
//
//        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
//        spinner.adapter = spinnerArrayAdapter


    }
}