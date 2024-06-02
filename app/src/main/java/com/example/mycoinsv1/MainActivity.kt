package com.example.mycoinsv1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

//Mendefinisikan kelas MainActivity yang merupakan turunan dari AppCompatActivity
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        btnMenabungListener()
    }

    private fun btnMenabungListener() {
        val buttonSave = findViewById<Button>(R.id.buttonSave)
        buttonSave.setOnClickListener {
            val intent = Intent(this, Dashboard::class.java)
            startActivity(intent)
        }

    }
    //Mendefinisikan MainActivity, menyetel tampilan dari layout activity_main, menyembunyikan ActionBar,
// dan mengatur listener pada tombol "Menabung" yang membuka Dashboard ketika diklik.
}