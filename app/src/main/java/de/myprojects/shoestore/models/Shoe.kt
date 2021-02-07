package de.myprojects.shoestore.models

import android.util.Log
import androidx.databinding.Bindable
import androidx.databinding.Observable

data class Shoe(
    var _name: String = "Air Force",
    var _price: String = "40$",
    var _company: String? = "NIKE",
    var _description: String? = "",
    val _images: List<String>? = mutableListOf()
) : Observable {

    @Bindable
    fun getName(): String {
        return this._name
    }

    fun setName(name: String) {
        _name = name
    }

    @Bindable
    fun getSize(): String {
        return this._price
    }

    fun setSize(size: String) {
        _price = size
    }

    @Bindable
    fun getCompany(): String? {
        return this._company
    }

    fun setCompany(company: String) {
        _company = company
    }


    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        Log.i("TEST", "")
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        Log.i("TEST", "")
    }
}
