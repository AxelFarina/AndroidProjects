package com.cursosandroidant.registration

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.cursosandroidant.registration.databinding.ActivitySingUpBinding
import com.google.android.material.datepicker.MaterialDatePicker
import java.text.SimpleDateFormat
import java.util.*

class SingUp : AppCompatActivity() {
    private lateinit var binding: ActivitySingUpBinding
    private lateinit var database: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySingUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        database = DatabaseHelper(this)

        binding.tvBackSignup.setOnClickListener {

            val intent = Intent(this, LogIn::class.java)
            startActivity(intent)
        }
        binding.etDateBirthSignup.setOnClickListener{
            val builder = MaterialDatePicker.Builder.datePicker()
            val picker = builder.build()

            picker.addOnPositiveButtonClickListener { timeInMiliseconds ->
                val dateStr = SimpleDateFormat("dd/MM/yyyy",
                    Locale.getDefault()).apply {
                    timeZone = TimeZone.getTimeZone("UTC")
                }.format(timeInMiliseconds)

                binding.etDateBirthSignup.setText(dateStr)
            }

            picker.show(supportFragmentManager, picker.toString())
        }

        binding.btnSingUp.setOnClickListener {
            if (valiedFields()){
                val intent = Intent(this, LogIn::class.java)
                intent.putExtra("k_name",binding.etNameSignup.text)
                intent.putExtra("k_username",binding.etUsernameSignup.text.toString())
                intent.putExtra("k_datebirth",binding.etDateBirthSignup.text)
                intent.putExtra("k_phone",binding.etPhoneSignup.text)
                intent.putExtra("k_password",binding.etPasswordSignup.text)
                startActivity(intent)
            }
        }


    }


    private fun valiedFields():Boolean{
        var isValid = true

        if(binding.etNameSignup.text.isNullOrEmpty()){
            binding.tilNameSignup.run{
                error = "Required"
                requestFocus()
            }
            isValid = false
        }else{
            binding.tilNameSignup.error = null
        }

        if(binding.etUsernameSignup.text.isNullOrEmpty()){
            binding.tilUsernameSignup.run{
                error = "Required"
                requestFocus()
            }
            isValid = false
        }else{
            binding.tilUsernameSignup.error = null
        }

        if(binding.etDateBirthSignup.text.isNullOrEmpty()){
            binding.tilDateBirthSignup.run{
                error = "Required"
                requestFocus()
            }
            isValid = false
        }else{
            binding.tilDateBirthSignup.error = null
        }

        if(binding.etPhoneSignup.text.isNullOrEmpty()){
            binding.tilPhoneSignup.run{
                error = "Required"
                requestFocus()
            }
            isValid = false
        }else{
            binding.tilPhoneSignup.error = null
        }

        if(binding.etPasswordSignup.text.isNullOrEmpty()){
            binding.tilPasswordSignup.run{
                error = "Required"
                requestFocus()
            }
            isValid = false
        }else{
            binding.tilPasswordSignup.error = null
        }
        return isValid
    }


}