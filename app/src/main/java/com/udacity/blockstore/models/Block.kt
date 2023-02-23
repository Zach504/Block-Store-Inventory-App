package com.udacity.blockstore.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Block(var name: String, var weight: Double, var company: String, var description: String, val images: List<String> = mutableListOf()) : Parcelable
