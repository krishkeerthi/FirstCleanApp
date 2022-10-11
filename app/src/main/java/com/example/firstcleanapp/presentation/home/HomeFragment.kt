package com.example.firstcleanapp.presentation.home

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.core.domain.Record
import com.example.firstcleanapp.framework.FirstCleanAppViewModelFactory
import com.example.firstcleanapp.R
import com.example.firstcleanapp.RecordsAdapter
import com.example.firstcleanapp.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: HomeFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentHomeBinding.bind(view)

        Log.d(TAG, "onViewCreated: inject home viewmodel initializing")
        viewModel = ViewModelProvider(this, FirstCleanAppViewModelFactory)[HomeFragmentViewModel::class.java]
        //viewModel = ViewModelProviders.of(this, FirstCleanAppViewModelFactory)[HomeFragmentViewModel::class.java]


        val recordsAdapter = RecordsAdapter()

        binding.recordsRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = recordsAdapter
        }

        // observe live data
        viewModel.records.observe(viewLifecycleOwner){ records ->
            if(records != null){
                recordsAdapter.updateRecords(records)
            }
        }

        binding.floatingActionButton.setOnClickListener {
            viewModel.createRecord{ record: Record ->
            recordsAdapter.addRecord(record)
            }
        }
    }
}