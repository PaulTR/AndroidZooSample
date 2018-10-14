package com.ptrprograms.zoo.animals

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ptrprograms.zoo.databinding.ListItemAnimalBinding
import com.ptrprograms.zoo.models.Animal

class AnimalsAdapter : ListAdapter<Animal, AnimalsAdapter.ViewHolder>(AnimalDiffCallback()) {
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val animal = getItem(position)
        holder.apply {
            bind(createOnClickListener(animal.animalId), animal)
            itemView.tag = animal
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListItemAnimalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    private fun createOnClickListener(animalId: String) : View.OnClickListener {
        return View.OnClickListener {
            val direction = AnimalsFragmentDirections.ActionAnimalsFragmentToAnimalDetailFragment(animalId)
            it.findNavController().navigate(direction)
        }
    }

    class ViewHolder(
            private val binding: ListItemAnimalBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(listener: View.OnClickListener, item: Animal) {
            binding.apply {
                clickListener = listener
                animal = item
                executePendingBindings()
            }
        }
    }
}