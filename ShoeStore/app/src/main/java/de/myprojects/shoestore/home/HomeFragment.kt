package de.myprojects.shoestore.home

import android.os.Bundle
import android.view.*
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.marginTop
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
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel: MainViewModel by activityViewModels()
    private lateinit var listAdapter: ShoeListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        binding.home = this

        setHasOptionsMenu(true)
        observeShoes()
        addEntry()
        addEntry()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()
    }

    //I use recyclerview here because it saves me boilerplate code, better architecture etc.
    private fun initRecyclerView() {
        listAdapter = ShoeListAdapter()

//        recyclerView.apply {
//            layoutManager = LinearLayoutManager(this.context)
//            itemAnimator = DefaultItemAnimator()
//            adapter = listAdapter
//        }
    }

    private fun addEntry(){
        val myLayout: LinearLayout = binding.linearLayout

      val textView = TextView(this.context)
        textView.text = ("Hi")
        textView.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        ).apply {
            setMargins(0,20,0,0)
        }

        myLayout.addView(textView)
    }

    private fun observeShoes() {
        viewModel.shoes.observe(viewLifecycleOwner, Observer { shoes ->
//            listAdapter.setData(shoes)
            addEntry()
        })
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
        return NavigationUI.onNavDestinationSelected(
            item, requireView().findNavController()
        ) || super.onOptionsItemSelected(item)
    }
}