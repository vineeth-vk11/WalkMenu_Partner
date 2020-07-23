package com.walkmenuvendor.shopservicesprovider

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.walkmenuvendor.R
import com.walkmenuvendor.databinding.ActivityShopServicesBinding

class ShopServicesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityShopServicesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_shop_services
        )
        val navController=findNavController(R.id.shop_nav_host)
        binding.navViewShop.setupWithNavController(navController)

    }
}