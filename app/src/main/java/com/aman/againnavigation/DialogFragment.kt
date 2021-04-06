package com.aman.againnavigation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.fragment_dialog.view.*

class DialogFragment : BottomSheetDialogFragment() {


     val args  : DialogFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dialog,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)

        val receivername = args.receivername
        val amount = args.amout

        view.tv_msg.setText("do you want to send this $amount to $receivername")

        view.btn_yes.setOnClickListener {
            Toast.makeText(requireContext(), "successfully send", Toast.LENGTH_SHORT).show()
            dismiss()
        }
        view.btn_no.setOnClickListener {
            dismiss()
        }
    }

}