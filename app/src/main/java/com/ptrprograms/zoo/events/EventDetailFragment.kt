package com.ptrprograms.zoo.events

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ptrprograms.zoo.databinding.FragmentEventDetailsBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class EventDetailFragment : Fragment() {
    val eventDetailViewModel : EventDetailViewModel by viewModel { parametersOf(EventDetailFragmentArgs.fromBundle(arguments).eventId) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val binding = FragmentEventDetailsBinding.inflate(inflater, container, false).apply {
            viewModel = eventDetailViewModel
            setLifecycleOwner(this@EventDetailFragment)
        }

        return binding.root

    }
}