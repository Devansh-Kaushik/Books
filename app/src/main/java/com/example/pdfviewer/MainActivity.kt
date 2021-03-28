

package com.example.pdfviewer

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_main)
        val b1:Button= findViewById(R.id.b)
        val t1:TextView= findViewById(R.id.textView)
        val t2 = findViewById<TextView>(R.id.textView2)
        b1.setOnClickListener {
            val intent =Intent(this@MainActivity,MainActivity2::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_left)
        }
    }

}