package com.example.mycoinsv1

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class Dashboard : AppCompatActivity() {
    private lateinit var savingsContainer: LinearLayout
    private val savingsList = mutableListOf<Saving>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_dashboard)
        supportActionBar?.hide()

        savingsContainer = findViewById(R.id.savingsContent)

        btnBukaTabunganListener()
    }

    override fun onResume() {
        super.onResume()
        // membuat dan menampilkan data dummy
        if (savingsList.isEmpty()) {
            savingsList.add(Saving("Liburan", "Tabungan untuk liburan akhir tahun", 5000000, 1000000))
            savingsList.add(Saving("Gadget Baru", "Tabungan untuk membeli gadget baru", 3000000, 500000))
            savingsList.add(Saving("Pendidikan Anak", "Tabungan untuk pendidikan anak", 10000000, 2000000))
            savingsList.add(Saving("Mobil Baru", "Tabungan untuk membeli mobil baru", 20000000, 5000000))
            displaySavings()
        }
    }

    private fun displaySavings() {
        savingsContainer.removeAllViews()
        //menampilkan daftar tabungan di savingsContainer.
        for (saving in savingsList) {
            //
            val savingView = LayoutInflater.from(this).inflate(R.layout.item_saving, savingsContainer, false)
            val titleTextView = savingView.findViewById<TextView>(R.id.titleTextView)
            val descriptionTextView = savingView.findViewById<TextView>(R.id.descriptionTextView)
            val collectedTextView = savingView.findViewById<TextView>(R.id.collectedTextView)

            titleTextView.text = saving.title
            descriptionTextView.text = saving.description
            collectedTextView.text = "Terkumpul: ${saving.collectedAmount}"

            savingView.setOnClickListener {
                val intent = Intent(this, Tabungan::class.java).apply {
                    putExtra("title", saving.title)
                    putExtra("description", saving.description)
                    putExtra("target", saving.target)
                    putExtra("collected", saving.collectedAmount)
                }
                startActivity(intent)
            }

            savingsContainer.addView(savingView)
        }
    }

    private fun btnBukaTabunganListener() {
        val btnBukaTabungan = findViewById<Button>(R.id.btnBukaTabungan)
        btnBukaTabungan.setOnClickListener {
            val intent = Intent(this, TambahTabungan::class.java)
            startActivity(intent)
        }
    }
}
