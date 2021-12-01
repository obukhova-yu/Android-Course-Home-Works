package com.triare.p101_recycler_view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ChatAdapter(private val items: List<Chat>) :
    RecyclerView.Adapter<ChatAdapter.ChatViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_chat, parent, false)
        return ChatViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size

    inner class ChatViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val avatar = itemView.findViewById<ImageView>(R.id.avatar)
        private val from = itemView.findViewById<TextView>(R.id.from)
        private val message = itemView.findViewById<TextView>(R.id.message)
        private val date = itemView.findViewById<TextView>(R.id.date)

        fun bind(chat: Chat) {
            Glide.with(itemView.context)
                .asBitmap()
                .load(chat.avatar)
                .circleCrop()
                .into(avatar)

            from.text = chat.from
            message.text = chat.message
            date.text = chat.date

            val isReadIcon = if (chat.isRead) {
                R.drawable.ic_read
            } else {
                R.drawable.ic_unread
            }
            date.setCompoundDrawablesWithIntrinsicBounds(isReadIcon, 0, 0, 0)
        }
    }

}