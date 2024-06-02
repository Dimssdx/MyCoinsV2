package com.example.mycoinsv1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class TambahTabungan : AppCompatActivity() {
    private lateinit var titleEditText: EditText
    private lateinit var descriptionEditText: EditText
    private lateinit var targetEditText: EditText
    private lateinit var addButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tambah_tabungan)
        supportActionBar?.hide()

        titleEditText = findViewById(R.id.edt_judul_tabungan)
        descriptionEditText = findViewById(R.id.edt_keterangan)
        targetEditText = findViewById(R.id.edt_target)
        addButton = findViewById(R.id.btnTambahkanTabungan)

        btnBackListener()
        btnTambahTabunganListener()
    }

    private fun btnBackListener() {
        val btnBack2 = findViewById<ImageButton>(R.id.btn_back2)
        btnBack2.setOnClickListener {
            finish()
        }
    }

    private fun btnTambahTabunganListener() {
        addButton.setOnClickListener {
            // Implementasi penyimpanan data tabungan baru
            finish()
        }
    }
}
