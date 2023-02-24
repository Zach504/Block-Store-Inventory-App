package com.udacity.blockstore.screens

import android.os.Bundle
import android.view.*
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.blockstore.BlocksViewModel
import com.udacity.blockstore.R
import com.udacity.blockstore.databinding.BlockItemBinding
import com.udacity.blockstore.databinding.FragmentListBinding
import timber.log.Timber

/**
 * Block List Screen
 */
class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding

    val blocksViewModel: BlocksViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        //Inflate view and get instance of binding class
        binding = FragmentListBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this

        //Create List Click Listener
        binding.addBlockButton.setOnClickListener {
            findNavController().navigate(ListFragmentDirections.actionListingFragmentToDetailCreateFragment())
        }

        //Link list items to view model
        //This seems like a cleaner way to go about adding the views rather than calling addView
        blocksViewModel.blocks.observe(viewLifecycleOwner, Observer { blocks ->
            Timber.i("<<<<<<<<<<Recreating List>>>>>>>>>>")
            binding.blockList.removeAllViews()
            for(i in 0..blocks.size - 1) {
                var blockBinding: BlockItemBinding =
                    DataBindingUtil.inflate(inflater, R.layout.block_item, binding.blockList, true)
                blockBinding.position = i
                blockBinding.blocksViewModel = blocksViewModel
                blockBinding.blockLayout.setOnClickListener {
                    val pos : Int = blockBinding.position ?: 0
                    findNavController().navigate(ListFragmentDirections.actionListingFragmentToDetailReadFragment(pos))
                }
            }
        })
        //binding.blockList.removeAllViews()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(object: MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.logout_menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return when (menuItem.itemId) {
                    R.id.menuLogout -> {
                        findNavController().navigate(ListFragmentDirections.actionListingFragmentToLoginFragment())
                        true
                    }
                    else -> {
                        false
                    }
                }
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }
}