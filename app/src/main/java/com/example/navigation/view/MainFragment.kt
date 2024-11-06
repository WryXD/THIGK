package com.example.navigation.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.navigation.R
import com.example.navigation.adapter.CustomAdapter
import com.example.navigation.data.Data
import com.example.navigation.databinding.FragmentMainBinding
import com.example.navigation.viewmodel.PlayerDetailViewModel


class MainFragment : Fragment() {

    private lateinit var viewModel: PlayerDetailViewModel
    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        // create view model
        viewModel = ViewModelProvider(requireActivity())[PlayerDetailViewModel::class.java]
        // create binding
        binding = FragmentMainBinding.bind(view)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Create a dataset
        val dataset = arrayOf(Data.Faker, Data.Oner, Data.Gumayushi, Data.Keria, Data.Zues)
        val customAdapter = CustomAdapter(dataset) {
            viewModel.addName(it.nickName)
            Log.d("MainFragment", "nickName: ${viewModel.detail.value?.nickName}")
            findNavController().navigate(R.id.action_mainFragment_to_blankFragment)
        }

        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = customAdapter
    }

}