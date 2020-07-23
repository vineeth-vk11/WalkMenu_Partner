package com.walkmenuvendor.shopservicesprovider.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.walkmenuvendor.R
import com.walkmenuvendor.databinding.FragmentAcceptedShopBinding
import com.walkmenuvendor.databinding.FragmentDeliveryAcceptedBinding


class AcceptedBookingsFragment : Fragment() {
    private lateinit var viewModel: ShopBookingsViewModel
    private lateinit var binding: FragmentAcceptedShopBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding=
            DataBindingUtil.inflate(inflater,R.layout.fragment_accepted_shop,container,false)
        viewModel =
            ViewModelProvider(this,
                ShopBookingsViewModelFactory(requireActivity().application)
            ).get(
                ShopBookingsViewModel::class.java
            )

        return binding.root
    }


}