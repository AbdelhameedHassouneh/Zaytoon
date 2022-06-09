package com.example.avocadoandroid.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.example.avocadoandroid.R
import com.example.avocadoandroid.databinding.FragmentFinalBinding
import com.example.avocadoandroid.entities.FinalDto
import com.example.avocadoandroid.finalrecycler.FinalListAdapter
import com.example.avocadoandroid.models.UserSharedViewModel
import com.example.avocadoandroid.utils.FinalItem

class FinalFragment : Fragment(R.layout.fragment_final) {
    private lateinit var viewModel: UserSharedViewModel
    private lateinit var binding: FragmentFinalBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var finalItem:FinalItem

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
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_final, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.finalItemLiveData.observe(viewLifecycleOwner) {
            Log.d(TAG, "onViewCreated: $it")
            viewModel.getLastItem(FinalDto(it))
        }
        viewModel.finalFinalLiveData.observe(viewLifecycleOwner)
        {
            Log.d(TAG, "onViewCreated: $it")
            if(it!=null){
                finalItem = it
                val adapter = FinalListAdapter()
                if(finalItem.sub_title!=null&&finalItem.sub_title.compareTo("")!=0){
                    binding.subTitleTextView.text = "Sub Title: ${finalItem.sub_title}"
                }else{
                    binding.subTitleTextView.visibility = View.GONE
                }

                if(finalItem.side_note!=null&&finalItem.side_note.compareTo("")!=0){
                    binding.sideNoteTextView.text = "Side Note: ${finalItem.side_note}"
                }else{
                    binding.sideNoteTextView.visibility = View.GONE
                }

                binding.foodItemNameTextView.text = "Item name: ${finalItem.food_item_name}"
                binding.sectionNameTextView.text = "Section name: ${finalItem.section_name}"
                binding.recyclerView.adapter = adapter
                adapter.submitList(finalItem.sizes_info)
            }
        }
    }

    companion object {
        private const val TAG = "FinalFragment"
    }
}