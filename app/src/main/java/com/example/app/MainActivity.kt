package com.example.app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.app.ui.QuetionsActivity
import com.example.app.utils.Constants

class MainActivity : AppCompatActivity() {
    private lateinit var startButton: Button
    private lateinit var nameInput: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        startButton = findViewById(R.id.start)
        nameInput = findViewById(R.id.name)

        startButton.setOnClickListener {
            if (!nameInput.text.isEmpty()) {
                Constants.name = nameInput.text.toString()
                Intent(this@MainActivity, QuetionsActivity::class.java).also {
                    startActivity(it)
                    finish()
                }
            } else {
                Toast.makeText(this@MainActivity, "please enter your name", Toast.LENGTH_LONG).show()
            }
        }
    }
}