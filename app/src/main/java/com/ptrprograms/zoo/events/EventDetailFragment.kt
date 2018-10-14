package com.ptrprograms.zoo.events

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.ptrprograms.zoo.R
import com.ptrprograms.zoo.databinding.FragmentEventDetailsBinding
import com.ptrprograms.zoo.utilities.InjectorUtils

class EventDetailFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val eventId = EventDetailFragmentArgs.fromBundle(arguments).eventId
        val factory = InjectorUtils.provideEventDetailViewModelFactory(requireActivity(), eventId)

        val eventDetailViewModel = ViewModelProviders.of(this, factory).get(EventDetailViewModel::class.java)

        val binding = FragmentEventDetailsBinding.inflate(inflater, container, false).apply {
            viewModel = eventDetailViewModel
            setLifecycleOwner(this@EventDetailFragment)
        }

        return binding.root

    }
}