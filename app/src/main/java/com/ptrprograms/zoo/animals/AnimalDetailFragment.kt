package com.ptrprograms.zoo.animals

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ptrprograms.zoo.databinding.FragmentAnimalDetailsBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class AnimalDetailFragment : Fragment() {
    val animalDetailViewModel : AnimalDetailViewModel by viewModel{ parametersOf(AnimalDetailFragmentArgs.fromBundle(arguments).animalId)}

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = FragmentAnimalDetailsBinding.inflate(inflater, container, false).apply {
            viewModel = animalDetailViewModel
            setLifecycleOwner(this@AnimalDetailFragment)
        }

        return binding.root
    }
}