package com.nandaadisaputra.dagger.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.nandaadisaputra.dagger.R
import com.nandaadisaputra.dagger.core.domain.model.Tourism
import com.nandaadisaputra.dagger.core.ui.ViewModelFactory
import com.nandaadisaputra.dagger.databinding.ActivityDetailTourismBinding
import com.nandaadisaputra.dagger.databinding.ActivityDetailTourismBinding.inflate

class DetailTourismActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    private lateinit var detailTourismViewModel: DetailTourismViewModel
    private lateinit var binding: ActivityDetailTourismBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val factory = ViewModelFactory.getInstance(this)
        detailTourismViewModel = ViewModelProvider(this, factory)[DetailTourismViewModel::class.java]

        val detailTourism = intent.getParcelableExtra<Tourism>(EXTRA_DATA)
        showDetailTourism(detailTourism)
    }

    private fun showDetailTourism(detailTourism: Tourism?) {
        detailTourism?.let {
            supportActionBar?.title = detailTourism.name
            binding.content.tvDetailDescription.text = detailTourism.description
            Glide.with(this@DetailTourismActivity)
                .load(detailTourism.image)
                .into(binding.ivDetailImage)

            var statusFavorite = detailTourism.isFavorite
            setStatusFavorite(statusFavorite)
            binding.fab.setOnClickListener {
                statusFavorite = !statusFavorite
                detailTourismViewModel.setFavoriteTourism(detailTourism, statusFavorite)
                setStatusFavorite(statusFavorite)
            }
        }
    }

    private fun setStatusFavorite(statusFavorite: Boolean) {
        if (statusFavorite) {
            binding.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_favorite_white))
        } else {
            binding.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_not_favorite_white))
        }
    }
}