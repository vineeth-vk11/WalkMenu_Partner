package com.walkmenuvendor.deliveryservicesprovider.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.walkmenuvendor.R
import com.walkmenuvendor.databinding.FragmentDeliveryAcceptedBinding


class AcceptedBookingsFragment : Fragment() {
    private lateinit var viewModel: DeliveryBookingsViewModel
    private lateinit var binding: FragmentDeliveryAcceptedBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_delivery_accepted,container,false)
        viewModel =
            ViewModelProvider(this,DeliveryBookingsViewModelFactory(requireActivity().application)).get(
                DeliveryBookingsViewModel::class.java
            )

        return binding.root
    }


}