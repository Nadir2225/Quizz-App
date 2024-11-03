package com.example.app.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.app.MainActivity
import com.example.app.R
import com.example.app.utils.Constants

class finishActivity : AppCompatActivity() {

    private lateinit var scoreView: TextView
    private lateinit var player: TextView
    private lateinit var finishing: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_finish)

        scoreView = findViewById(R.id.scoreView)
        player = findViewById(R.id.player)
        finishing = findViewById(R.id.finish_btn)

        player.text = Constants.name
        scoreView.text = "Your score is ${Constants.score} out of ${Constants.getQuetions().size}"

        finishing.setOnClickListener {
            Constants.score = 0
            Intent(this@finishActivity, MainActivity::class.java).also {
                startActivity(it)
                finish()
            }
        }

    }
}