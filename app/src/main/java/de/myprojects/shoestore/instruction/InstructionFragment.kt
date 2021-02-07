package de.myprojects.shoestore.instruction

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import de.myprojects.shoestore.R
import de.myprojects.shoestore.databinding.FragmentInstructionBinding


class InstructionFragment : Fragment() {

    private lateinit var binding : FragmentInstructionBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_instruction, container, false)
        binding.instruction = this

        return binding.root
    }

    //Binding
    fun navigateHome() {
        val action = InstructionFragmentDirections.actionInstructionFragmentToHomeFragment()
        findNavController().navigate(action)
    }

}