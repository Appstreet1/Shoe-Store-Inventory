package de.myprojects.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import de.myprojects.shoestore.models.Shoe

class MainViewModel : ViewModel() {

    private val _shoes = MutableLiveData<MutableList<Shoe>>()
    val shoes: LiveData<MutableList<Shoe>>
        get() = _shoes

    private var _eventAddOrCancel  = MutableLiveData<Boolean>()
    val eventAddOrCancel: LiveData<Boolean>
        get() = _eventAddOrCancel

    private var _list :MutableList<Shoe> = mutableListOf()

    fun addShoe(shoe: Shoe?) {

        if (shoe != null) {
            _list.add(shoe)
        }

        _shoes.value = _list
        _eventAddOrCancel.value = true
    }

    fun cancelAddingShoe(){
        _eventAddOrCancel.value = true
    }

    fun onAddComplete(){
        _eventAddOrCancel.value = false
    }
}