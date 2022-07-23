package com.cursosandroidant.mdc

import android.graphics.Color
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.webkit.URLUtil
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.cursosandroidant.mdc.databinding.ActivityScrollingBinding
import com.google.android.material.bottomappbar.BottomAppBar

class ScrollingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityScrollingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityScrollingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*findViewById<FloatingActionButton>(R.id.fab).setOnClickListener {
            if(findViewById<BottomAppBar>(R.id.bottom_app_bar).fabAlignmentMode == BottomAppBar.FAB_ALIGNMENT_MODE_CENTER){
                findViewById<BottomAppBar>(R.id.bottom_app_bar).fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_END
            }else{
                findViewById<BottomAppBar>(R.id.bottom_app_bar).fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_CENTER
            }
        }*/

        binding.fab.setOnClickListener {
            if(binding.bottomAppBar.fabAlignmentMode == BottomAppBar.FAB_ALIGNMENT_MODE_CENTER){
                binding.bottomAppBar.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_END
            }else{
                binding.bottomAppBar.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_CENTER
            }
        }

        binding.bottomAppBar.setNavigationOnClickListener({
            Snackbar.make(binding.root, getString(R.string.message_action_success), Snackbar.LENGTH_LONG)
                .setAnchorView(binding.fab)
                .show()
        })

        binding.content.btnSkip?.setOnClickListener { binding.content.cvAdd?.visibility = View.GONE }

        binding.content.btnBuy?.setOnClickListener {
            Snackbar.make(it, R.string.card_buying, Snackbar.LENGTH_LONG)
                .setAnchorView(binding.fab)
                .setAction(R.string.card_to_go, {
                    Toast.makeText(this, R.string.card_historial, Toast.LENGTH_SHORT).show()
                })
                .show()
        }


        binding.content.cbEnablePass?.setOnClickListener {
            binding.content.tilPassword?.isEnabled = !binding.content.tilPassword?.isEnabled!!
        }

        binding.content.etUrl?.onFocusChangeListener = View.OnFocusChangeListener{view, focused ->
            var errorStr: String? = null
            val url = binding.content.etUrl?.text.toString()

            if (!focused){
                if (url.isEmpty()){
                    errorStr = getString(R.string.card_required)
                } else if (URLUtil.isValidUrl(url)){
                    loadImage(url)
                } else {
                    errorStr = getString(R.string.card_invalid_url)
                }
            }

            binding.content.tilUrl?.error = errorStr
        }

        binding.content.toogleButton?.addOnButtonCheckedListener { group, checkedId, isChecked ->
            binding.content.root.setBackgroundColor(
                when(checkedId){
                    R.id.btnRed -> Color.RED
                    R.id.btnBlue -> Color.BLUE
                    else -> Color.GREEN
                }
            )
        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_scrolling, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun loadImage(url:String = "https://occ-0-2433-448.1.nflxso.net/dnm/api/v6/E8vDc_W8CLv7-yMQu8KMEC7Rrr8/AAAABUe8v-cUzGkbJXO-AVR4MViFSGHf8YArd0kHjwn3I9ndHDtGRLwOrXD0XoYp6lctJ6SSPU7f0Ksn-TVYgB_aVwQrVjsh.jpg?r=f3e"){
        binding.content.imgCover?.let {
            Glide.with(this)
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .into(it)
        }
    }

}