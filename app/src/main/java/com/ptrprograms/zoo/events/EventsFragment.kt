package com.ptrprograms.zoo.events

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.ptrprograms.zoo.R
import kotlinx.android.synthetic.main.fragment_events.view.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class EventsFragment : Fragment() {
    val eventsViewModel : EventsViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_events, container, false)


        val adapter = EventsAdapter()
        view.recycler_view_events.adapter = adapter

        eventsViewModel.getEvents().observe(viewLifecycleOwner, Observer { events ->
            if (events != null) adapter.submitList(events)
        })


        return view.rootView
    }
}