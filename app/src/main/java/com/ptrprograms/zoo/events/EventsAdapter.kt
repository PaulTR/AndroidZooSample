package com.ptrprograms.zoo.events

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ptrprograms.zoo.databinding.ListItemEventBinding
import com.ptrprograms.zoo.models.Event

class EventsAdapter : ListAdapter<Event, EventsAdapter.ViewHolder>(EventDiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val event = getItem(position)
        holder.apply {
            bind(createOnClickListener(event.eventId), event)
            itemView.tag = event
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListItemEventBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    private fun createOnClickListener(eventId: String): View.OnClickListener {
        return View.OnClickListener {
            val direction = EventsFragmentDirections.ActionEventsFragmentToEventDetailFragment(eventId)
            it.findNavController().navigate(direction)
        }
    }

    class ViewHolder(
            private val binding: ListItemEventBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(listener: View.OnClickListener, item: Event) {
            binding.apply {
                clickListener = listener
                event = item
                executePendingBindings()
            }
        }
    }
}