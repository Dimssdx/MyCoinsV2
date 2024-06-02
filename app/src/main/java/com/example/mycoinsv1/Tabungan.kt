package com.example.mycoinsv1

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class Tabungan : AppCompatActivity() {
    private lateinit var titleTextView: TextView
    private lateinit var descriptionTextView: TextView
    private lateinit var targetTextView: TextView
    private lateinit var collectedTextView: TextView
    private lateinit var amountEditText: EditText
    private lateinit var saveButton: Button

    private var collectedAmount: Int = 0

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tabungan)
        supportActionBar?.hide()

        titleTextView = findViewById(R.id.edt_judul_tabungan)
        descriptionTextView = findViewById(R.id.edt_keterangan)
        targetTextView = findViewById(R.id.target)
        collectedTextView = findViewById(R.id.terkumpul)
        amountEditText = findViewById(R.id.nominal)
        saveButton = findViewById(R.id.btnTambahkanTabungan)

        val title = intent.getStringExtra("title")
        val description = intent.getStringExtra("description")
        val target = intent.getIntExtra("target", 0)
        collectedAmount = intent.getIntExtra("collected", 0)

        titleTextView.text = title
        descriptionTextView.text = description
        targetTextView.text = "Target: $target"
        collectedTextView.text = "Terkumpul: $collectedAmount"

        btnBackListener()
        btnTambahkanTabunganListener()
    }

    private fun btnBackListener() {
        val btnBack3 = findViewById<ImageButton>(R.id.btn_back3)
        btnBack3.setOnClickListener {
            val intent = Intent(this, Dashboard::class.java)
            startActivity(intent)
        }
    }

    private fun btnTambahkanTabunganListener() {
        saveButton.setOnClickListener {
            val amount = amountEditText.text.toString().toIntOrNull() ?: 0
            collectedAmount += amount
            collectedTextView.text = "Terkumpul: $collectedAmount"
            amountEditText.text.clear()
        }
    }
}
