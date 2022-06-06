package com.example.avocadoandroid.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.avocadoandroid.R
import com.example.avocadoandroid.databinding.FragmentEditBinding
import com.example.avocadoandroid.databinding.FragmentExpandableBinding
import com.example.avocadoandroid.entities.CategoryDto
import com.example.avocadoandroid.models.UserSharedViewModel
import com.example.avocadoandroid.recycler_expandable.ChildItem
import com.example.avocadoandroid.recycler_expandable.GridListAdapter
import kotlin.math.log


class ExpandableFragment : Fragment(R.layout.fragment_expandable) {
    private lateinit var viewModel: UserSharedViewModel
    private lateinit var binding: FragmentExpandableBinding
    private lateinit var drinks:List<ChildItem>
    private lateinit var sandwichs:List<ChildItem>
    private lateinit var bakeries:List<ChildItem>
    private lateinit var sweets:List<ChildItem>
    private lateinit var streetSnacks:List<ChildItem>
    private lateinit var toppings:List<ChildItem>
    private lateinit var deals:List<ChildItem>


    private val adapter = GridListAdapter(onItemClicked = ::onChildItemClicked)


    private lateinit var zaytoonCat:String
    private lateinit var cateegories:List<String>


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
        binding.drinksLay.recyclerView.adapter = adapter
        viewModel.zaytoonCat.observe(viewLifecycleOwner){
            zaytoonCat = it
            Log.d(TAG, "onViewCreated: $zaytoonCat")

        }
        viewModel.categoriesLiveData.observe(viewLifecycleOwner){
            cateegories = it
            Log.d(TAG, "onViewCreated: $cateegories")
            for (item in cateegories){
                viewModel.getCategoryItems(CategoryDto(zaytoonCat,item))
                if(item == "Drinks"){
                    binding.drinksLay.root.visibility = View.VISIBLE
                }
            }
        }
        
        with(viewModel){
            drinksLiveData.observe(viewLifecycleOwner){
                Log.d(TAG, "Tbe drinks $it")
                drinks = it
                adapter.submitList(drinks)
            }
            sandwichesLiveData.observe(viewLifecycleOwner){
                sandwichs = it
            }
            bakeriesLiveData.observe(viewLifecycleOwner){
                bakeries = it
            }
            sweetLiveData.observe(viewLifecycleOwner){
                sweets = it
            }
            streetSnacksLiveData.observe(viewLifecycleOwner){
                streetSnacks = it
            }
            
            toppingsLiveData.observe(viewLifecycleOwner){
                toppings = it
            }
            dealsLiveData.observe(viewLifecycleOwner){
                deals =it
            }
        }

    }
    fun onChildItemClicked(s:String){

    }

    companion object{
        private const val TAG = "ExpandableFragment"
    }
}
