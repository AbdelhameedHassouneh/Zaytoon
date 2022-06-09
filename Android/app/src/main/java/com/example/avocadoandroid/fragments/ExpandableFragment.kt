package com.example.avocadoandroid.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.avocadoandroid.R
import com.example.avocadoandroid.databinding.FragmentExpandableBinding
import com.example.avocadoandroid.entities.CategoryDto
import com.example.avocadoandroid.models.UserSharedViewModel
import com.example.avocadoandroid.recycler_expandable.GridListAdapter
import com.example.avocadoandroid.utils.CategoryItem


class ExpandableFragment : Fragment(R.layout.fragment_expandable) {
    private lateinit var viewModel: UserSharedViewModel
    private lateinit var binding: FragmentExpandableBinding
    private lateinit var recyclerView: RecyclerView

    private val adapter = GridListAdapter(::onChildItemClicked)


    private lateinit var zaytoonCat: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = activity?.run {
            ViewModelProviders.of(this)[UserSharedViewModel::class.java]
        } ?: throw Exception("Invalid Activity")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_expandable, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = binding.recyclerView
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        recyclerView.adapter = adapter
        viewModel.zaytoonCat.observe(viewLifecycleOwner) {
            zaytoonCat = it
            Log.d(TAG, "onViewCreated: $zaytoonCat")
            viewModel.getCategoriesAggregated(CategoryDto(zaytoonCat))
        }
        viewModel.aggregatedItems.observe(viewLifecycleOwner) {
            val listOfCategoryItem = mutableListOf<CategoryItem>()

            Log.d(TAG, "onViewCreated: $it")
            if (it != null) {
                for (item in it.data) {
                    val cats = item.category_items
                    listOfCategoryItem.addAll(cats)
                }
                adapter.submitList(listOfCategoryItem)
            }
        }
    }

    fun onChildItemClicked(string:String) {

        viewModel.setFinalItem(string)
        parentFragmentManager.commit {
            replace<FinalFragment>(R.id.fragment_container)
        }
    }

    companion object {
        private const val TAG = "ExpandableFragment"
    }
}
