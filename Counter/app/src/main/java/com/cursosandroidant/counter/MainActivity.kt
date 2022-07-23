package com.cursosandroidant.counter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.cursosandroidant.counter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    private var count:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setCount()

        binding.btnSum.setOnClickListener {
            count++
            setCount()
        }

        binding.btnSum.setOnLongClickListener {
            count = 0
            setCount()
            true
        }
        Log.i("Life Cycle","onCreate")
    }



    override fun onRestart() {
        super.onRestart()
        Log.i("Life Cycle","onRestart")
    }

    override fun onStart() {
        super.onStart()
        Log.i("Life Cycle","onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("Life Cycle","onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("Life Cycle","onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("Life Cycle","onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this,"App Life Cycle ha finalizado...", Toast.LENGTH_SHORT).show()
        Log.i("Life Cycle","onDestroy")
    }

    private fun setCount() {
        binding.tvCount.text = count.toString()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.run {
            putInt(PARAM_COUNT,count)
        }
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        count = savedInstanceState.getInt(PARAM_COUNT)
        setCount()
        super.onRestoreInstanceState(savedInstanceState)
    }

    companion object {
        private const val PARAM_COUNT:String = "param_count"
    }

}