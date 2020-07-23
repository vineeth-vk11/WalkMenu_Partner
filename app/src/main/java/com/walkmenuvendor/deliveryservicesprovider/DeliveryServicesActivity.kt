package com.walkmenuvendor.deliveryservicesprovider

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.walkmenuvendor.R
import com.walkmenuvendor.databinding.ActivityDeliveryServicesBinding

class DeliveryServicesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDeliveryServicesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_delivery_services
        )

       val navController=findNavController(R.id.delivery_nav_host)
       binding.navViewDelivery.setupWithNavController(navController)

    }
}