package com.aman.againnavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_choose_reciver.view.*


class ChooseReciverFragment : Fragment(R.layout.fragment_choose_reciver) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = findNavController()

        view.next.setOnClickListener {
            val receivername = view.recivername.text.toString()

            val action = ChooseReciverFragmentDirections.actionChooseReciverFragmentToSendCashFragment(receivername)
            navController.navigate(action)


            view.cancelbutons.setOnClickListener {
                findNavController().popBackStack()
            }
        }



    }

}