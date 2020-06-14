package com.mobilography.Fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.mobilography.DetailTour
import com.mobilography.R
import com.mobilography.adapter.MyTourAdapter
import com.mobilography.data.model.Tour
import com.mobilography.data.networking.TourApi
import com.mobilography.data.repository.TourRepository
import com.mobilography.ui.courses.tours.RecyclerViewClickListenerT
import com.mobilography.ui.courses.tours.TourViewModel
import com.mobilography.ui.courses.tours.TourViewModelFactory
import kotlinx.android.synthetic.main.fragment_tour.*


class FragmentTour : Fragment(), RecyclerViewClickListenerT {

    private lateinit var factory: TourViewModelFactory
    private lateinit var viewModel: TourViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tour, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val api = TourApi()
        val repositoryt = TourRepository(api)
        factory = TourViewModelFactory(repositoryt)
        viewModel = ViewModelProviders.of(this, factory).get(TourViewModel::class.java)
        viewModel.getTour()
        viewModel.tour.observe(viewLifecycleOwner, Observer { tour ->
            recyclerview_tour.also {
                it.layoutManager = LinearLayoutManager(requireContext())
                it.setHasFixedSize(true)
                it.adapter = MyTourAdapter(tour, this)
            }
        })

    }



    override fun onRecyclerViewItemClickT(view: View, tour: Tour) {
        when(view.id){
            R.id.tour_card ->{
                val intent: Intent = Intent(activity, DetailTour::class.java)
                startActivity(intent)

                Toast.makeText(requireContext(), "Tour trip is Clicked", Toast.LENGTH_LONG).show()
            }
        }
    }

    companion object {
        fun newInstance(): FragmentTour = FragmentTour()
    }
}



