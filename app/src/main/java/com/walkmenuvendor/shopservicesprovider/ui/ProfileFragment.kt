package com.walkmenuvendor.shopservicesprovider.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.walkmenuvendor.R
import com.walkmenuvendor.databinding.FragmentProfileDeliveryBinding
import com.walkmenuvendor.databinding.FragmentProfileShopBinding

class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileShopBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_profile_shop,container,false)

        return binding.root
    }


}