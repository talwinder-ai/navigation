package com.aman.againnavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_setting.view.*

class SettingFragment : Fragment(R.layout.fragment_setting) {

    lateinit var editText: EditText

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        editText = view.findViewById(R.id.edittextsetting)

        view.savebutton.setOnClickListener {
            val data = editText.text.toString().toLong()
            Sampleclass.data.value = data
        }

        view.aboutappbutton.setOnClickListener {
            val action = MyNavDirections.actionGlobalAboutAppFragment()
            findNavController().navigate(action)
        }
    }

}