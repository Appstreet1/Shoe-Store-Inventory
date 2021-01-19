package de.myprojects.shoestore.home

import android.os.Bundle
import android.view.*
import android.widget.LinearLayout
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import de.myprojects.shoestore.MainViewModel
import de.myprojects.shoestore.R
import de.myprojects.shoestore.databinding.FragmentHomeBinding
import de.myprojects.shoestore.models.Shoe
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        binding.home = this

        setHasOptionsMenu(true)
        observeShoes()


        return binding.root
    }


    private fun observeShoes() {
        viewModel.shoes.observe(viewLifecycleOwner, Observer { shoes ->

            for (shoe in shoes) {
                addEntry(shoe)
            }
        })
    }


    private fun addEntry(shoe: Shoe) {

        val textView = TextView(this.context)
        textView.text = shoe.getName()
        textView.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
                .apply { setMargins(10, 100, 0, 0) }

        binding.linearLayout.addView(textView)
    }

    fun navigateDetail() {
        val action = HomeFragmentDirections.actionHomeFragmentToDetailFragment()
        findNavController().navigate(action)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_main, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //handles navigate to login -> id's of menuItem and fragment destination needs to be the same
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController()) || super.onOptionsItemSelected(item)
    }
}