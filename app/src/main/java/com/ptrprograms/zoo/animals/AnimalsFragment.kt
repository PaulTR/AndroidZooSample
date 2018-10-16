package com.ptrprograms.zoo.animals

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.ptrprograms.zoo.R
import kotlinx.android.synthetic.main.fragment_animals.*
import kotlinx.android.synthetic.main.fragment_animals.view.*
import org.koin.androidx.viewmodel.ext.android.viewModel

//TODO add support for filtering from an options menu
class AnimalsFragment : Fragment() {

    val animalsViewModel : AnimalsViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_animals, container, false)

        val adapter = AnimalsAdapter()
        view.recycler_view_animals.adapter = adapter

        animalsViewModel.getAnimals().observe(viewLifecycleOwner, Observer { animals ->
            if (animals != null) adapter.submitList(animals)
        })

        return view.rootView
    }

}