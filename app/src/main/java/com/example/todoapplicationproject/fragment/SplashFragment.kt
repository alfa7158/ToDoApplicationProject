package com.example.todoapplicationproject.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.todoapplicationproject.R
import com.example.todoapplicationproject.mainActivity.MainActivity
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext
import androidx.appcompat.app.AppCompatActivity






class SplashFragment : Fragment(), CoroutineScope {
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + Job()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_splash, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()
        launch {
            delay(3000)
            withContext(Dispatchers.Main){
                (activity as MainActivity)
                findNavController().navigate(R.id.action_splashFragment_to_main_select_Fragment2)       }
        }
    }
}