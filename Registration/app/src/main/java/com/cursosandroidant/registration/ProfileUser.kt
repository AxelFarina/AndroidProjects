package com.cursosandroidant.registration

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cursosandroidant.registration.databinding.ActivityProfileUserBinding

class ProfileUser : AppCompatActivity() {
    private lateinit var binding: ActivityProfileUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}