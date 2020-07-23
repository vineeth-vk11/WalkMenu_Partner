package com.walkmenuvendor.deliveryservicesprovider.ui

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class DeliveryBookingsViewModel (private val application: Application) : ViewModel(){

}
@Suppress("UNCHECKED_CAST")
class DeliveryBookingsViewModelFactory(private val application: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return DeliveryBookingsViewModel(application) as T
    }
}
