package com.cursosandroidant.profile

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.cursosandroidant.profile.databinding.ActivityEditBinding
import com.cursosandroidant.profile.databinding.ActivityMainBinding

class EditActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditBinding

    private var imgUri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        with(binding){
            intent.extras?.let {
                imgUri = Uri.parse(it.getString(getString(R.string.key_image)))
                updateImage()
                etName.setText(it.getString(getString(R.string.key_name)))
                etEmail.setText(it.getString(getString(R.string.key_email)))
                etWebsite.setText(it.getString(getString(R.string.key_website)))
                etPhone.setText(it.getString(getString(R.string.key_phone)))
                etLatitude.setText(it.getDouble(getString(R.string.key_latitude)).toString())
                etLength.setText(it.getDouble(getString(R.string.key_length)).toString())
            }

            etWebsite.setOnFocusChangeListener { view, isFocused ->
                if(isFocused){ etWebsite.text?.let{ etWebsite.setSelection(it.length)
                    }

                }
            }
            etEmail.setOnFocusChangeListener { view, isFocused ->
                if(isFocused){ etEmail.text?.let{ etEmail.setSelection(it.length)
                    }

                }
            }
            etPhone.setOnFocusChangeListener { view, isFocused ->
                if(isFocused){ etPhone.text?.let{ etPhone.setSelection(it.length)
                    }

                }
            }
            etLatitude.setOnFocusChangeListener { view, isFocused ->
                if(isFocused){ etLatitude.text?.let{ etLatitude.setSelection(it.length)
                    }

                }
            }
            etLength.setOnFocusChangeListener { view, isFocused ->
                if(isFocused){ etLength.text?.let{ etLength.setSelection(it.length)
                    }

                }
            }

            btnSelectPhoto.setOnClickListener{
                val intent = Intent(Intent.ACTION_OPEN_DOCUMENT).apply {
                    addCategory(Intent.CATEGORY_OPENABLE)
                    type = "image/jpeg"
                }
                startActivityForResult(intent, RC_GALLERY)
            }


        }

    }

    override fun onResume() {
        super.onResume()
        if(resources.getBoolean(R.bool.isPortrait)){
            Toast.makeText(this, "Vertical", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(this,"Horizontal",Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_edit, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home -> onBackPressed()
            R.id.action_save -> sendData()
        }
    /*
    if(item.itemId == R.id.action_save){
    sendData()
    finish()
    }else if(item.itemId == android.R.id.home){
    onBackPressed()
    }
    */
        return super.onOptionsItemSelected(item)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(resultCode == RESULT_OK){
            if(requestCode == RC_GALLERY){
                imgUri = data?.data

                imgUri?.let {
                    val contentResolver = applicationContext.contentResolver
                    val takeFlags = Intent.FLAG_GRANT_READ_URI_PERMISSION or
                            Intent.FLAG_GRANT_WRITE_URI_PERMISSION

                    contentResolver.takePersistableUriPermission(it,takeFlags)

                    updateImage()
                }

            }
        }
    }

    private fun updateImage(){
        binding.imageProfile.setImageURI(imgUri)
    }

    private fun sendData() {
        val intent = Intent()
        with(binding){
            intent.apply {
                putExtra(getString(R.string.key_image),imgUri.toString())
                putExtra(getString(R.string.key_name), etName.text.toString())
                putExtra(getString(R.string.key_email), etEmail.text.toString())
                putExtra(getString(R.string.key_website), etWebsite.text.toString())
                putExtra(getString(R.string.key_phone), etPhone.text.toString())
                putExtra(getString(R.string.key_latitude), etLatitude.text.toString().toDouble())
                putExtra(getString(R.string.key_length), etLength.text.toString().toDouble())
            }
        }
    /*
    intent.putExtra(getString(R.string.key_name), binding.etName.text.toString())
    intent.putExtra(getString(R.string.key_email), binding.etEmail.text.toString())
    intent.putExtra(getString(R.string.key_website), binding.etWebsite.text.toString())
    intent.putExtra(getString(R.string.key_phone), binding.etPhone.text.toString())
    intent.putExtra(getString(R.string.key_latitude), binding.etLatitude.text.toString().toDouble())
    intent.putExtra(getString(R.string.key_length), binding.etLength.text.toString().toDouble())
    */

        setResult(RESULT_OK, intent)

        finish()
    }

    companion object{
        private const val RC_GALLERY = 22
    }

}