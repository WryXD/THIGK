package com.example.navigation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.navigation.R
import com.example.navigation.data.Data

class CustomAdapter(
    private val dataSet: Array<Data>,
    private val itemClickListener: (Data) -> Unit,
) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder)
     */
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val playerName: TextView = view.findViewById(R.id.playerName)
        val playerAvatar: ImageView = view.findViewById(R.id.playerAvatar)
        val nickName: TextView = view.findViewById(R.id.gameName)

        init {
            // Define click listener for the ViewHolder's View
            view.setOnClickListener {
                val item = dataSet[adapterPosition]
                itemClickListener(item)
            }
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.text_row_item, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val data = dataSet[position]
        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.playerName.text = data.playedName
        viewHolder.playerAvatar.setImageResource(data.avatar)
        viewHolder.nickName.text = data.nickName
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}