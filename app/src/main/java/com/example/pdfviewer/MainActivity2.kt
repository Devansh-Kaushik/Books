package com.example.pdfviewer

import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        supportActionBar?.hide()
        val a: Button = findViewById(R.id.Action)
        val h: Button = findViewById(R.id.Horror)
        val hi: Button = findViewById(R.id.Historic)
        val c: Button = findViewById(R.id.Comic)
        val f: Button = findViewById(R.id.Fantasy)
        val m: Button = findViewById(R.id.Mystric)
        val cl: Button = findViewById(R.id.Classic)
        val fi: Button = findViewById(R.id.Friction)
        val ain = AnimationUtils.loadAnimation(this, R.anim.bounce)

        a.setOnClickListener {
            val intent: Intent = Intent(this@MainActivity2, act1::class.java)
            startActivity(intent)
        }
        h.setOnClickListener {
            val intent: Intent = Intent(this@MainActivity2, horrror1::class.java)
            startActivity(intent)
        }
        hi.setOnClickListener {
            val intent: Intent = Intent(this@MainActivity2, historic1::class.java)
            startActivity(intent)
        }
        c.setOnClickListener {
            val intent: Intent = Intent(this@MainActivity2, comic1::class.java)
            startActivity(intent)

        }
        f.setOnClickListener {
            val intent: Intent = Intent(this@MainActivity2, fantasy1::class.java)
            startActivity(intent)

        }
        cl.setOnClickListener {
            val intent: Intent = Intent(this@MainActivity2, cassic1::class.java)
            startActivity(intent)

        }
        m.setOnClickListener {
            val intent: Intent = Intent(this@MainActivity2, mystry1::class.java)
            startActivity(intent)

        }
        fi.setOnClickListener {
            val intent: Intent = Intent(this@MainActivity2, fricton1::class.java)
            startActivity(intent)

        }
    }

}
