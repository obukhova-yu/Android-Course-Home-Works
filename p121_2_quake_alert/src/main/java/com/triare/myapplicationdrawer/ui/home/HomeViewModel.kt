package com.triare.myapplicationdrawer.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.triare.myapplicationdrawer.api.QuakeDto
import com.triare.myapplicationdrawer.api.QuakeRepository

class HomeViewModel : ViewModel() {

    private var _quakeResult = MutableLiveData<QuakeDto>()
    val quakeResult: LiveData<QuakeDto> = _quakeResult

    private val quakeRepository = QuakeRepository()

    init {
         _quakeResult = quakeRepository.getQuakeDTO()
    }


    fun getQuakeResulttoFragment(): LiveData<QuakeDto> {
        return quakeResult
}



// quakeRepository.getQuakeResult {
         //    _quakeResult.value = it
        // }


    //companion object {
    //    fun newInstance() = HomeFragment()
  //  }

  //  override fun onItemClick(position: Int, feature: Feature) {
     //   val detailsFragment = DetailsFragment
     //       .newInstance(feature)
      ///  requireActivity().supportFragmentManager
       //     .beginTransaction()
       //     .replace(R.id.nav_host_fragment_container, detailsFragment)
        //    .addToBackStack("item")
        //    .commit()
     //   Log.d("TEST1", feature.toString())

 //   }

    //fun list(view: View, features: Feature){
      //  HomeFragmentDirections.actionHomeFragmentToDetailFragment(
       //     features
     //   ).also {
      //    view.findNavController().navigate(it)
     //   }
   // }
}

