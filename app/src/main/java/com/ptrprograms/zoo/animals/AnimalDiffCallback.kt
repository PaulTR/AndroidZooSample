package com.ptrprograms.zoo.animals

import androidx.recyclerview.widget.DiffUtil
import com.ptrprograms.zoo.models.Animal
import com.ptrprograms.zoo.models.Event

class AnimalDiffCallback : DiffUtil.ItemCallback<Animal>() {

    override fun areItemsTheSame(oldItem: Animal, newItem: Animal): Boolean {
        return oldItem.animalId == newItem.animalId
    }

    override fun areContentsTheSame(oldItem: Animal, newItem: Animal): Boolean {
        return oldItem == newItem
    }
}