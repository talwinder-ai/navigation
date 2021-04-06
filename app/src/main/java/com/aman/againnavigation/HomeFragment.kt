package com.aman.againnavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_home.view.*


class HomeFragment : Fragment(R.layout.fragment_home) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

         val navController = findNavController()
        view.btn_sendmoney.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToChooseReciverFragment()
            navController.navigate(action)
        }
        view.btn_view_transaction.setOnClickListener {
            navController.navigate(R.id.action_homeFragment_to_viewTransactionFragment)
            val action = HomeFragmentDirections.actionHomeFragmentToViewTransactionFragment()
            navController.navigate(action)
        }
        view.btn_viewbalance.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToViewBalanceFragment()
            navController.navigate(action)
        }
    }
}