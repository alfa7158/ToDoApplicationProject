package com.example.todoapplicationproject.fragment

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.icu.util.Calendar
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.annotation.RequiresApi
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.todoapplicationproject.R
import com.example.todoapplicationproject.ViewModels.ToDoViewModelAdapter
import com.example.todoapplicationproject.data.ToDoModel
import java.text.SimpleDateFormat

/**
 * This class is to edit(Update) the tasks edited
 */
class editFragment : Fragment() {
    private lateinit var selectedTasks: ToDoModel

    private val editViewModel: ToDoViewModelAdapter by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_edit, container, false)
    }



    @SuppressLint("CutPasteId", "SimpleDateFormat")
    @RequiresApi(Build.VERSION_CODES.N)
    /**
     * In the function below, we are sitting the view of delete class
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val titleToEdit: EditText = view.findViewById(R.id.editEditeText_title)
        val descToEdit: EditText = view.findViewById(R.id.editEditeText_decrip)
        val dateToEdit: EditText = view.findViewById(R.id.editEditeText_date)
        val timeToEdit: EditText = view.findViewById(R.id.editEditeText_time)
        val editButton: Button = view.findViewById(R.id.editButton)
        val DatePicker_edit = view.findViewById<EditText>(R.id.editEditeText_date)
        val mPickTimeBtn = view.findViewById<EditText>(R.id.editEditeText_time)


        /**
         * here we are observe selected date
         */

        editViewModel.selectedLiveData.observe(viewLifecycleOwner, Observer { it?.let { task ->

            titleToEdit.setText(task.title)
            descToEdit.setText(task.description)
            dateToEdit.setText(task.date)
            timeToEdit.setText(task.time)
            selectedTasks = task

        }

        })
        /**
         * here we using the edit ImageView as button to edit the tasks
         */
        editButton.setOnClickListener() {

            selectedTasks.title = titleToEdit.text.toString()
            selectedTasks.description = descToEdit.text.toString()
            selectedTasks.date = dateToEdit.text.toString()
            selectedTasks.time = timeToEdit.text.toString()

            editViewModel.updateTask(selectedTasks)
            findNavController().navigate(R.id.action_editFragment_to_to_Do_List_Fragment)

        }

        /**
         * here we are taking an Instance of the Calendar class
         */
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        DatePicker_edit.setOnClickListener {
           // editViewModel.updateTask()
            val dpd = DatePickerDialog(requireContext(), { view, year, monthOfYear, dayOfMonth ->
                c.set(year,monthOfYear,dayOfMonth)
                dateToEdit.setText(SimpleDateFormat("dd/MM/yyyy").format(c.timeInMillis))

            }, year, month, day)
            dpd.show()


        }
        /**
         * here we are sitting the time picker Button
         */
        mPickTimeBtn.setOnClickListener {
            val cal = Calendar.getInstance()
            val timeSetListener = TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
                cal.set(Calendar.HOUR_OF_DAY, hour)
                cal.set(Calendar.MINUTE, minute)
                timeToEdit.setText( android.icu.text.SimpleDateFormat("HH:mm").format(cal.time))
            }
            TimePickerDialog(context, timeSetListener, cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), true).show()
        }

    }


}