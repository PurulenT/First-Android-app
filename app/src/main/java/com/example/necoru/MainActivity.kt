package com.example.necoru

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {
    private var start:Boolean = false
    private var number:Int = 5
    private var tvText:TextView? = null
    private var cLayout: ConstraintLayout? = null
    private var counter:Int = 0;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvText = findViewById(R.id.tvText)
        cLayout = findViewById(R.id.cLayout)
        tvText?.setText(number.toString())
        start = true
        Thread{
            while(start)
            {
                Thread.sleep(1000)
                runOnUiThread{
                    tvText?.setText(counter.toString())
                    if(counter == 5) cLayout?.setBackgroundColor(Color.CYAN)
                    counter++
                }

            }
        }.start()

    }

    override fun onDestroy() {
        super.onDestroy()
        start = false
    }
}