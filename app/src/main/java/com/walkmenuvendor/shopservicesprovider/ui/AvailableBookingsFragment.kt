package com.walkmenuvendor.shopservicesprovider.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.walkmenuvendor.R
import com.walkmenuvendor.databinding.FragmentAvailableDeliveryBinding
import com.walkmenuvendor.databinding.FragmentAvailableShopBinding


class AvailableBookingsFragment : Fragment() {
    private lateinit var binding: FragmentAvailableShopBinding

    private lateinit var viewModel: ShopBookingsViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=
            DataBindingUtil.inflate(inflater,R.layout.fragment_available_shop,container,false)
        viewModel= ViewModelProvider(this,
            ShopBookingsViewModelFactory(requireActivity().application)
        ).get(
            ShopBookingsViewModel::class.java
        )





        return binding.root
    }


}