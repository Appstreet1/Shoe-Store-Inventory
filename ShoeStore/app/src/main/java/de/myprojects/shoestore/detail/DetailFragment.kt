package de.myprojects.shoestore.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import de.myprojects.shoestore.MainViewModel
import de.myprojects.shoestore.R
import de.myprojects.shoestore.databinding.FragmentDetailBinding
import de.myprojects.shoestore.models.Shoe

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false)

        initBinding()
        observeAddOrCancel()

        return binding.root
    }

    private fun initBinding(){
        binding.mainViewModel = viewModel
        binding.shoe = Shoe()
    }

    private fun observeAddOrCancel() {
        viewModel.eventAddOrCancel.observe(viewLifecycleOwner) { addOrCancel ->
            if (addOrCancel) {
                navigateHome()
                viewModel.onAddComplete()
            }
        }
    }

    private fun navigateHome() {
        val action = DetailFragmentDirections.actionDetailFragmentToHomeFragment()
        findNavController().navigate(action)
    }
}