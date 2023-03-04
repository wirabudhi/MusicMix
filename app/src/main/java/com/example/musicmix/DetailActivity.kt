package com.example.musicmix

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.musicmix.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Menangkap data
        val data = intent.getParcelableExtra<Music>("DATA")

        // Memproses data agar dapat ditampilkan
        binding.imgDetailMusic.setImageResource(data?.photo ?: R.drawable.logo)
        binding.tvDetailTitle.text = data?.title
        binding.tvDetailYears.text = data?.years
        binding.tvDetailMusician.text = data?.musician
        binding.tvDetailAlbum.text = data?.album
        binding.tvDetailGenre.text = data?.genre
        binding.tvDetailDuration.text = data?.duration
        binding.tvDetailLyrics.text = data?.lyrics

        // Membuat fungsi share pada tombol "Share"
        binding.actionShare.setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.type = "text/plain"
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Bagikan Musik ${data?.title}")
            shareIntent.putExtra(Intent.EXTRA_TEXT, "Saya ingin berbagi musik ${data?.title} denganmu. Dapatkan di aplikasi kami sekarang!")
            startActivity(Intent.createChooser(shareIntent, "Bagikan dengan"))
        }
    }
}