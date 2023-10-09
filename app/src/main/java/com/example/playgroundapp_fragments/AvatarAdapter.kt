package com.example.playgroundapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.playgroundapp_fragments.R


class AvatarAdapter(private val avatarList: List<Int>, private val onItemClick: (position: Int) -> Unit) : RecyclerView.Adapter<AvatarAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_avatar, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val avatar = avatarList[position]
        holder.bind(avatar)

        holder.itemView.setOnClickListener {//add a listener
            onItemClick(position)
        }
    }

    override fun getItemCount(): Int {
        return avatarList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val avatarImageView: ImageView = itemView.findViewById(R.id.avatarImageView)

        init {
            itemView.setOnClickListener {
                onItemClick(adapterPosition)
            }
        }

        fun bind(avatar: Int) {
            avatarImageView.setImageResource(avatar)
        }
    }
}