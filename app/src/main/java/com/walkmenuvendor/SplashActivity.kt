package com.walkmenuvendor

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.walkmenuvendor.deliveryservicesprovider.DeliveryServicesActivity
import com.walkmenuvendor.helper.SharedPreferencesHelper
import com.walkmenuvendor.householdserviceprovider.HouseholdServicesActivity
import com.walkmenuvendor.shopservicesprovider.ShopServicesActivity
import com.google.firebase.auth.FirebaseAuth

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val sharedPref = SharedPreferencesHelper(this)
        val user = FirebaseAuth.getInstance().currentUser

        if (user == null) {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            when (sharedPref.getValueLong(SharedPreferencesHelper.PREFS_FIELD_TYPE)) {
                SharedPreferencesHelper.DELIVERY_SERVICE -> {
                    startActivity(Intent(this, DeliveryServicesActivity::class.java))
                    finish()
                }
                SharedPreferencesHelper.HOUSEHOLD_SERVICE -> {
                    startActivity(Intent(this, HouseholdServicesActivity::class.java))
                    finish()
                }
                SharedPreferencesHelper.SHOP_SERVICE -> {
                    startActivity(Intent(this, ShopServicesActivity::class.java))
                    finish()
                }
            }
        }
    }
}
