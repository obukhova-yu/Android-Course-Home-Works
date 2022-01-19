package com.triare.myapplicationdrawer.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.triare.myapplicationdrawer.R
import com.triare.myapplicationdrawer.api.Feature
import com.triare.myapplicationdrawer.ui.details.DetailsFragment

class HomeFragment : Fragment(), QuakeAdapter.OnItemClickListener {

    private val homeViewModel by viewModels<HomeViewModel>()

    private val recyclerView = view?.findViewById<RecyclerView>(R.id.recycler_view)

    var listOfQuake: List<Feature>? = emptyList()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUi()
        observeUpdates()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    private fun initUi() {
        initRecyclerView()
    }

    private fun initRecyclerView() {
        recyclerView?.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }

    private fun observeUpdates() {
        observeQuakeResult()
    }

    private fun observeQuakeResult() {

        homeViewModel.getQuakeResulttoFragment().observe(activity as LifecycleOwner, {
            recyclerView?.adapter = QuakeAdapter(it.features, this)
            listOfQuake = it.features
        })
    }

    companion object {
        fun newInstance() = HomeFragment()
    }

    private fun navigateToDetailFragment(data: Feature) {
        val detailsFragment = DetailsFragment
            .newInstance(data)
        requireActivity().supportFragmentManager
            .beginTransaction()
            .replace(R.id.nav_host_fragment_container, detailsFragment)
            .addToBackStack("item")
            .commit()
        Log.d("TEST", data.toString())
    }

    override fun onItemClick(position: Int, data: Feature) {
        navigateToDetailFragment(data)
    }
}