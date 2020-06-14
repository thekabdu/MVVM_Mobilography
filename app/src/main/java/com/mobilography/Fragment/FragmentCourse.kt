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
import com.mobilography.DetailCourse
import com.mobilography.R
import com.mobilography.adapter.MyCourseAdapter
import com.mobilography.data.model.Course

import com.mobilography.data.networking.CourseApi
import com.mobilography.data.repository.CourseRepository
import com.mobilography.ui.courses.CourseViewModel
import com.mobilography.ui.courses.CourseViewModelFactory
import com.mobilography.ui.courses.RecyclerViewClickListener

import kotlinx.android.synthetic.main.fragment_course.*



class FragmentCourse : Fragment(), RecyclerViewClickListener {


    companion object {
        fun newInstance() = FragmentCourse()
    }

    private lateinit var factory: CourseViewModelFactory
    private lateinit var viewModel: CourseViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_course, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val api = CourseApi()
        val repository = CourseRepository(api)
        factory = CourseViewModelFactory(repository)
        viewModel = ViewModelProviders.of(this, factory).get(CourseViewModel::class.java)
        viewModel.getCourse()
        viewModel.course.observe(viewLifecycleOwner, Observer { course ->
            recyclerview_course.also {
                it.layoutManager = LinearLayoutManager(requireContext())
                it.setHasFixedSize(true)
                it.adapter = MyCourseAdapter(course, this)
            }
        })

    }

    override fun onRecyclerViewItemClick(view: View, course: Course) {
        when(view.id){
            R.id.course_card ->{
                val intent: Intent = Intent(activity, DetailCourse::class.java)
                startActivity(intent)

                Toast.makeText(requireContext(), "Lesson is Clicked", Toast.LENGTH_LONG).show()
            }
        }
    }
}