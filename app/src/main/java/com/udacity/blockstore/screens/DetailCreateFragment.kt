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
import com.udacity.blockstore.BlockViewModel
import com.udacity.blockstore.BlocksViewModel
import com.udacity.blockstore.R
import com.udacity.blockstore.databinding.FragmentDetailCreateBinding

/**
 * Block Detail Screen (Create)
 */
class DetailCreateFragment : Fragment() {

    private lateinit var binding: FragmentDetailCreateBinding
    private lateinit var blockViewModel: BlockViewModel

    private val blocksViewModel: BlocksViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //Inflate view and get instance of binding class
        binding = FragmentDetailCreateBinding.inflate(inflater, container, false)
        blockViewModel = ViewModelProvider(this).get(BlockViewModel::class.java)
        binding.blockViewModel = blockViewModel
        binding.lifecycleOwner = this

        binding.createBlockButton.setOnClickListener {
            blocksViewModel.addBlock(blockViewModel.name.value.toString(), blockViewModel.weight.value.toString(), blockViewModel.company.value.toString(), blockViewModel.description.value.toString())
            findNavController().navigate(DetailCreateFragmentDirections.actionDetailCreateFragmentToListingFragment())
        }

        binding.cancelButton.setOnClickListener {
            findNavController().navigate(DetailCreateFragmentDirections.actionDetailCreateFragmentToListingFragment())
        }

        return binding.root
    }
}