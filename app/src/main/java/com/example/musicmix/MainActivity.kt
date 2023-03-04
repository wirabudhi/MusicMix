package com.example.musicmix

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.musicmix.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // Mendefinisikan variabel
    private lateinit var binding: ActivityMainBinding
    private lateinit var rvMusic: RecyclerView
    private var list = ArrayList<Music>()

    // Membuat Instance dengan view Acitity_main
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Mengatur agar memiliki fixed size
        binding.rvMusic.setHasFixedSize(true)

        // Menampilkan list
        list.addAll(getListMusics())
        showRecyclerList()
    }

    // Mendefinisikan listMusic
    private fun getListMusics(): ArrayList<Music> {
        val dataTitle = resources.getStringArray(R.array.data_title)
        val dataYears = resources.getStringArray(R.array.data_years)
        val dataMusician = resources.getStringArray(R.array.data_musician)
        val dataPhoto = binding.root.resources.obtainTypedArray(R.array.data_photo)
        val dataAlbum = binding.root.resources.getStringArray(R.array.data_album)
        val dataGenre = binding.root.resources.getStringArray(R.array.data_genre)
        val dataDuration = binding.root.resources.getStringArray(R.array.data_duration)
        val dataLyrics = binding.root.resources.getStringArray(R.array.data_lyrics)
        val listMusic = ArrayList<Music>()
        for (i in dataTitle.indices){
            val music = Music(dataTitle[i], dataYears[i], dataMusician[i], dataPhoto.getResourceId(i, -1), dataAlbum[i], dataGenre[i], dataDuration[i], dataLyrics[i])
            listMusic.add(music)
        }
        return listMusic
    }

    // Menampilkan recyclerList
    private fun showRecyclerList() {
        binding.rvMusic.layoutManager = LinearLayoutManager(binding.root.context)
        val listMusicAdapter = ListMusicAdapter(list) {
            val intentToDetail = Intent(this@MainActivity, DetailActivity::class.java)
            intentToDetail.putExtra("DATA", it)
            startActivity(intentToDetail)
        }
        binding.rvMusic.adapter = listMusicAdapter
    }

    // Menampilkan menu about
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    // Mendifinisikan function ketika button diclick
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_about -> {
                val intent = Intent(this, AboutActivity::class.java)
                startActivity(intent)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

}