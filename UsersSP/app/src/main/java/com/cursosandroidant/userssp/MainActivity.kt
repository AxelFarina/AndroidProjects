package com.cursosandroidant.userssp

import android.content.Context
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cursosandroidant.userssp.databinding.ActivityMainBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity(), OnClickListener {

    private lateinit var userAdapter: UserAdapter
    private lateinit var linearLayoutManager: RecyclerView.LayoutManager

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val preferences = getPreferences(Context.MODE_PRIVATE)

        val isFirstTime = preferences.getBoolean(getString(R.string.sp_first_time), true)
        Log.i("SP","${getString(R.string.sp_first_time)} = $isFirstTime")

        if(isFirstTime) {
            val dialogView = layoutInflater.inflate(R.layout.dialog_register, null)
            MaterialAlertDialogBuilder(this)
                .setTitle(R.string.dialog_title)
                .setView(dialogView)
                .setCancelable(false)
                .setPositiveButton(R.string.dialog_confirm, { dialogInterface, i ->
                    val username = dialogView.findViewById<TextInputEditText>(R.id.etUsername)
                        .text.toString()
                    with(preferences.edit()){
                        putBoolean(getString(R.string.sp_first_time), false)
                        putString(getString(R.string.sp_username), username)
                            .apply()
                    }
                    Toast.makeText(this, R.string.register_success, Toast.LENGTH_SHORT).show()

                })
                .setNeutralButton(R.string.dialog_neutral, { dialogInterface, i ->
                    dialogInterface.cancel()
                    Toast.makeText(this, R.string.register_invited, Toast.LENGTH_SHORT).show()
                })
                .show()
        }else{
            val username = preferences.getString(getString(R.string.sp_username), getString(R.string.hint_username))
            Toast.makeText(this, "Bienvenido $username", Toast.LENGTH_SHORT).show()
        }
        userAdapter = UserAdapter(getUser(),this)
        linearLayoutManager = LinearLayoutManager(this)

        binding.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = linearLayoutManager
            adapter = userAdapter
        }
    }

    private fun getUser(): MutableList<User>{
        val users = mutableListOf<User>()

        val axel = User(1,"Axel","Farina","https://www.playerone.vg/wp-content/uploads/2021/07/Baki-Suntory-agua-carbonatada-e1626276011304.jpg")
        val alain = User(2,"Alain","Nicolas","https://img1.ak.crunchyroll.com/i/spire1/d55332a77967452c302b5f30aee0f8db1521049407_large.jpg")

        users.add(axel)
        users.add(alain)
        users.add(axel)
        users.add(alain)
        users.add(axel)
        users.add(alain)
        users.add(axel)
        users.add(alain)
        users.add(axel)
        users.add(alain)
        users.add(axel)
        users.add(alain)
        users.add(axel)
        users.add(alain)
        users.add(axel)
        users.add(alain)

        return users
    }

    override fun onClick(user: User, position:Int) {
        super.onClick(user,position)
        Toast.makeText(this, "$position: ${user.getFullName()}" , Toast.LENGTH_SHORT).show()
    }

}