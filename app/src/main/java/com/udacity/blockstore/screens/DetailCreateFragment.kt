package com.udacity.blockstore.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.blockstore.BlocksViewModel
import com.udacity.blockstore.R
import com.udacity.blockstore.databinding.FragmentDetailCreateBinding

/**
 * Block Detail Screen (Create)
 */
class DetailCreateFragment : Fragment() {

    private lateinit var binding: FragmentDetailCreateBinding

    private val blocksViewModel: BlocksViewModel by activityViewModels()

    private val KEY_NAME = "key_name"
    private val KEY_COMPANY = "key_company"
    private val KEY_WEIGHT = "key_weight"
    private val KEY_DESCRIPTION = "key_description"

    private var name : String = ""
    private var company : String = ""
    private var weight : String = ""
    private var description : String = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //Inflate view and get instance of binding class
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail_create, container, false)
        binding.lifecycleOwner = this

        binding.createBlockButton.setOnClickListener {
            blocksViewModel.addBlock(binding.blockNameEditText.text.toString(), binding.weightEditText.text.toString(), binding.companyEditText.text.toString(), binding.descriptionEditText.text.toString())
            findNavController().navigate(DetailCreateFragmentDirections.actionDetailCreateFragmentToListingFragment())
        }

        binding.cancelButton.setOnClickListener {
            findNavController().navigate(DetailCreateFragmentDirections.actionDetailCreateFragmentToListingFragment())
        }

        if(savedInstanceState != null){
            name = savedInstanceState.getString(KEY_NAME).toString()
            company = savedInstanceState.getString(KEY_COMPANY).toString()
            weight = savedInstanceState.getString(KEY_WEIGHT).toString()
            description = savedInstanceState.getString(KEY_DESCRIPTION).toString()
        }

        binding.name = name
        binding.company = company
        binding.weight = weight
        binding.description = description

        return binding.root
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(KEY_NAME, name)
        outState.putString(KEY_COMPANY, company)
        outState.putString(KEY_WEIGHT, weight)
        outState.putString(KEY_DESCRIPTION, description)
    }
}