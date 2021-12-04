package com.triare.p103_recycler_view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class GalleryAdapter(private val items: List<ImageLine>) :
    RecyclerView.Adapter<GalleryAdapter.ChatViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
            val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_gallery, parent, false)
            return ChatViewHolder(itemView)
        }

        override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
            holder.bind(items[position])
        }

        override fun getItemCount() = items.size

        inner class ChatViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

            private val image1 = itemView.findViewById<ImageView>(R.id.image1)
            private val image2 = itemView.findViewById<ImageView>(R.id.image2)
            private val image3 = itemView.findViewById<ImageView>(R.id.image3)


            fun bind(imageLine: ImageLine) {
                Glide.with(itemView.context)
                    .asBitmap()
                    .load(imageLine.image1)
                    .into(image1)

                Glide.with(itemView.context)
                    .asBitmap()
                    .load(imageLine.image2)
                    .into(image2)

                Glide.with(itemView.context)
                    .asBitmap()
                    .load(imageLine.image3)
                    .into(image3)
            }
        }
}