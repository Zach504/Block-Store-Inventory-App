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
import androidx.navigation.fragment.navArgs
import com.udacity.blockstore.BlocksViewModel
import com.udacity.blockstore.R
import com.udacity.blockstore.databinding.FragmentDetailReadBinding

/**
 * Block Detail Screen (Read Only)
 */
class DetailReadFragment : Fragment() {

    private lateinit var binding: FragmentDetailReadBinding

    private val blocksViewModel: BlocksViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //Inflate view and get instance of binding class
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail_read, container, false)
        binding.blocksViewModel = blocksViewModel
        binding.lifecycleOwner = this

        //Get Position
        // Get args using by navArgs property delegate
        val detailReadFragmentArgs by navArgs<DetailReadFragmentArgs>()
        binding.position = detailReadFragmentArgs.position

        binding.returnButton.setOnClickListener {
            findNavController().navigate(DetailReadFragmentDirections.actionDetailReadFragmentToListingFragment())
        }

        return binding.root
    }
}