package com.ptrprograms.zoo.events

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.ptrprograms.zoo.databinding.FragmentEventsBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class EventsFragment : Fragment() {
    val eventsViewModel : EventsViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentEventsBinding.inflate(inflater, container, false)

        val adapter = EventsAdapter()
        binding.recyclerViewEvents.adapter = adapter

        eventsViewModel.getEvents().observe(viewLifecycleOwner, Observer { events ->
            if (events != null) adapter.submitList(events)
        })


        return binding.root
    }
}