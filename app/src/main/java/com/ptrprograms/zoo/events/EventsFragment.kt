package com.ptrprograms.zoo.events

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.ptrprograms.zoo.R
import com.ptrprograms.zoo.utilities.InjectorUtils
import kotlinx.android.synthetic.main.fragment_events.view.*

class EventsFragment : Fragment() {
    private lateinit var viewModel : EventsViewModel

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_events, container, false)

        val context = context ?: return view.rootView
        val factory = InjectorUtils.provideEventsViewModelFactory(context)
        viewModel = ViewModelProviders.of(this, factory).get(EventsViewModel::class.java)

        viewModel.getEvents().observe(viewLifecycleOwner, Observer { events ->
            if (events != null) view.events_text.text = events.get(0).title
        })


        return view.rootView
    }
}