package com.example.musicmix

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.musicmix.databinding.ItemRowMusicBinding

class ListMusicAdapter(private val listMusic: ArrayList<Music>, private val onClick: (Music) -> Unit) : RecyclerView.Adapter<ListMusicAdapter.ListViewHolder>() {
    // Digunakan sebagai ViewHolder dalam RecyclerView
    inner class ListViewHolder(private val binding: ItemRowMusicBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(music: Music) {
            with(binding) {
                imgMusic.setImageResource(music.photo)
                tvTitleSongs.text = music.title
                tvYears.text = music.years
                tvMusician.text = music.musician
                itemView.setOnClickListener {
                    onClick(music)
                }
            }
        }
    }

    // Membuat ViewHolder dengan Layout Item Row Music
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemRowMusicBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    // Menetapkan ukuran list data
    override fun getItemCount(): Int = listMusic.size

    // Menetapkan data pada View Holder
    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listMusic[position])
    }
}