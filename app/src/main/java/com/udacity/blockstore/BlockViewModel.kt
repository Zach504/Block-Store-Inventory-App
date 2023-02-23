package com.udacity.blockstore

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BlockViewModel : ViewModel(){

    var name = MutableLiveData<String>()
    var weight = MutableLiveData<String>()
    var company = MutableLiveData<String>()
    var description = MutableLiveData<String>()

    init {
        name.value = ""
        weight.value = ""
        company.value = ""
        description.value = ""
    }
}