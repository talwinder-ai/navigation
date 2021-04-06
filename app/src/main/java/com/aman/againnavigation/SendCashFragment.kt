package com.aman.againnavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.core.view.doOnAttach
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_send_cash.view.*

class SendCashFragment : Fragment(R.layout.fragment_send_cash) {

    val args : SendCashFragmentArgs by navArgs()
    lateinit var  displayname: TextView
    lateinit var editText: EditText

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        displayname = view.findViewById(R.id.displaynameoreciver)
        editText = view.findViewById(R.id.rupessedittext)

            val nameofreviever =  args.receivername

            displayname.text = nameofreviever
             val amounts = view.rupessedittext.text


        view.send.setOnClickListener {

            if (amounts==null){
                return@setOnClickListener
            }
            val action = SendCashFragmentDirections.actionSendCashFragmentToDialogFragment2(displayname.toString(),amounts.toString().toLong())
             findNavController().navigate(action)
        }

        view.btn_done.setOnClickListener {

            val action = SendCashFragmentDirections.actionSendCashFragmentToHomeFragment()
              findNavController().navigate(action)
        }

        view.cancelmoney.setOnClickListener {

            findNavController().popBackStack(R.id.homeFragment,true)
        }



    }
}