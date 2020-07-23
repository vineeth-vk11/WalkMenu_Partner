package com.walkmenuvendor.deliveryservicesprovider.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.walkmenuvendor.R
import com.walkmenuvendor.databinding.FragmentProfileDeliveryBinding


class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileDeliveryBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_profile_delivery,container,false)

        return binding.root
    }


}