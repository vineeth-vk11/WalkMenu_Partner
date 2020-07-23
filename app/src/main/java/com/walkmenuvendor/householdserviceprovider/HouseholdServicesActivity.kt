package com.walkmenuvendor.householdserviceprovider

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.walkmenuvendor.R
import com.walkmenuvendor.databinding.ActivityHouseholdServicesBinding

class HouseholdServicesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHouseholdServicesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_household_services
        )

        val navController = findNavController(R.id.nav_host_fragment)
        binding.navView.setupWithNavController(navController)
    }
}
