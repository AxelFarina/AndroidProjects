package com.cursosandroidant.lifecycle

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {

    private var mediaPlayer: MediaPlayer? = null
    private var position: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.i("Life Cycle","onCreate")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("Life Cycle","onRestart")
    }

    override fun onStart() {
        super.onStart()
        mediaPlayer = MediaPlayer.create(this,R.raw.ai_2)
        Log.i("Life Cycle","onStart")
        mediaPlayer?.start()
    }

    override fun onResume() {
        super.onResume()
        mediaPlayer?.seekTo(position)
        mediaPlayer?.start()
        Log.i("Life Cycle","onResume")
    }

    override fun onPause() {
        super.onPause()
        mediaPlayer?.pause()
        if(mediaPlayer != null)
        position = mediaPlayer!!.currentPosition
        Log.i("Life Cycle","onPause")
        finish()
    }

    override fun onStop() {
        super.onStop()
        mediaPlayer?.stop()
        mediaPlayer?.release()
        mediaPlayer = null
        Log.i("Life Cycle","onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this,"App Life Cycle ha finalizado...",Toast.LENGTH_SHORT).show()
        Log.i("Life Cycle","onDestroy")
    }
}