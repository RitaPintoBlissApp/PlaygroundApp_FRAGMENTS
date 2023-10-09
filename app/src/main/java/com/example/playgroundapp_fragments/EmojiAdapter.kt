package com.example.playgroundapp_fragments



import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView



class EmojiAdapter(private val emojiList: List<Int>, private val onItemClick: (position: Int) -> Unit
) : RecyclerView.Adapter<EmojiAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflate/fill in the layout of the grid with the emoji
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_emoji, parent, false)
        return ViewHolder(view)
    }

    //puts the emoji in a position
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val emoji = emojiList[position]
        holder.bind(emoji)


        holder.itemView.setOnClickListener {//add a listener
            onItemClick(position)
        }
    }

    override fun getItemCount(): Int {
        return emojiList.size
    }

    //viewholder for eatch emoji
    //viewholder is a helper class that holds the View of a row or rows
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val emojiImageView: ImageView = itemView.findViewById(R.id.emojiImageView)

        init {
            itemView.setOnClickListener {
                onItemClick(adapterPosition)
            }
        }

        //attributes an imagem to eatch ImageView
        fun bind(emoji: Int) {
            emojiImageView.setImageResource(emoji)
        }
    }
}