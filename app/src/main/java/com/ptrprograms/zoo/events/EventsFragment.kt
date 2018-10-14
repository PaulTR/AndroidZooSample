package com.ptrprograms.zoo.events

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.ptrprograms.zoo.R
import com.ptrprograms.zoo.databinding.FragmentEventsBinding
import com.ptrprograms.zoo.utilities.InjectorUtils
import kotlinx.android.synthetic.main.fragment_events.*
import kotlinx.android.synthetic.main.fragment_events.view.*

class EventsFragment : Fragment() {
    private lateinit var viewModel : EventsViewModel

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentEventsBinding.inflate(inflater, container, false)

        val context = context ?: return binding.root
        val factory = InjectorUtils.provideEventsViewModelFactory(context)

        viewModel = ViewModelProviders.of(this, factory).get(EventsViewModel::class.java)

        val adapter = EventsAdapter()
        binding.recyclerViewEvents.adapter = adapter

        viewModel.getEvents().observe(viewLifecycleOwner, Observer { events ->
            if (events != null) adapter.submitList(events)
        })


        return binding.root
    }
}