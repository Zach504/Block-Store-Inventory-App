package com.udacity.blockstore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.blockstore.models.Block
import timber.log.Timber

class BlocksViewModel : ViewModel(){

    //Blocks available in the store
    private val _blocks = MutableLiveData<ArrayList<Block>>()
    val blocks : LiveData<ArrayList<Block>>
        get() = _blocks

    init {
        _blocks.value = ArrayList<Block>()
        val b1 = Block("Dirt",50.0, "Nestle", "A block of dirt.")
        val b2 = Block("Stone",200.0, "Marathon", "A block of solid stone.")
        _blocks.value!!.add(b1)
        _blocks.value!!.add(b2)
    }

    fun addBlock(name: String, weight: String, company: String, description: String){
        val block = Block(name,weight.toDoubleOrNull()?:0.0,company,description)
        _blocks.value?.add(block)
        Timber.i("<<<<<<<<<<Block Added>>>>>>>>>>")
    }

    //Get the values for individual block items - used for binding the list screen UI tightly
    fun getName(position: Int) : String{
        return _blocks.value?.get(position)?.name.toString()
    }

    fun getWeight(position: Int): String {
        return _blocks.value?.get(position)?.weight.toString() + " kg"
    }

    fun getCompany(position: Int) : String{
        return _blocks.value?.get(position)?.company.toString()
    }

    fun getDescription(position: Int) : String{
        return _blocks.value?.get(position)?.description.toString()
    }
}