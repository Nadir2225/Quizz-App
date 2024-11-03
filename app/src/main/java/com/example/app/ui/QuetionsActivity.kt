package com.example.app.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.app.R
import com.example.app.utils.Constants

class QuetionsActivity : AppCompatActivity() {

    private lateinit var ques: TextView
    private lateinit var flag: ImageView
    private lateinit var progressBar: ProgressBar
    private lateinit var progressString: TextView

    private lateinit var option1: TextView
    private lateinit var option2: TextView
    private lateinit var option3: TextView
    private lateinit var option4: TextView

    private lateinit var checkButton: Button

    private var questions = Constants.getQuetions()

    private var currentPosition: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_quetions)


        ques = findViewById(R.id.quest)
        flag = findViewById(R.id.flag)
        progressBar = findViewById(R.id.progress_bar)
        progressString = findViewById(R.id.progress_string)

        option1 = findViewById(R.id.option1)
        option2 = findViewById(R.id.option2)
        option3 = findViewById(R.id.option3)
        option4 = findViewById(R.id.option4)

        checkButton = findViewById(R.id.check_button)

        option1.setOnClickListener {
            if (checkButton.text == "Check") {
                toDefault()
                selectAnswer(option1, 1)
            }
        }

        option2.setOnClickListener {
            if (checkButton.text == "Check") {
                toDefault()
                selectAnswer(option2, 2)
            }
        }

        option3.setOnClickListener {
            if (checkButton.text == "Check") {
                toDefault()
                selectAnswer(option3, 3)
            }
        }

        option4.setOnClickListener {
            if (checkButton.text == "Check") {
                toDefault()
                selectAnswer(option4, 4)
            }
        }

        if (currentPosition == 1) fillPage()

        checkButton.setOnClickListener {
            when(checkButton.text) {
                "Check" -> {
                    if (Constants.selected == 0) {
                        Toast.makeText(this@QuetionsActivity, "choose an anwser please", Toast.LENGTH_LONG).show()
                    } else {
                        toDefault(false)
                        when(questions[currentPosition - 1].correctOption) {
                            1 -> option1.setBackgroundResource(R.drawable.correct_option)
                            2 -> option2.setBackgroundResource(R.drawable.correct_option)
                            3 -> option3.setBackgroundResource(R.drawable.correct_option)
                            4 -> option4.setBackgroundResource(R.drawable.correct_option)
                        }
                        if (Constants.selected != questions[currentPosition - 1].correctOption) {
                            when (Constants.selected) {
                                1 -> option1.setBackgroundResource(R.drawable.incorrect_option)
                                2 -> option2.setBackgroundResource(R.drawable.incorrect_option)
                                3 -> option3.setBackgroundResource(R.drawable.incorrect_option)
                                4 -> option4.setBackgroundResource(R.drawable.incorrect_option)
                            }
                        } else {
                            Constants.score++
                        }
                        if (currentPosition == questions.size) {
                            checkButton.text = "Finish"
                        } else {
                            checkButton.text = "Next"
                        }
                    }
                }
                "Next" -> {
                    currentPosition++
                    fillPage()
                }
                "Finish" -> {
                    toDefault()
                    Intent(this@QuetionsActivity, finishActivity::class.java).also {
                        startActivity(it)
                        finish()
                    }
                }
            }
        }

    }
    private fun fillPage() {
        toDefault()
        ques.text = questions[currentPosition - 1].quetion
        flag.setImageResource(questions[currentPosition - 1].flag)
        progressBar.max = questions.size
        progressBar.progress = currentPosition
        progressString.text = "${currentPosition} / ${questions.size}"
        option1.text = questions[currentPosition - 1].optionOne
        option2.text = questions[currentPosition - 1].optionTwo
        option3.text = questions[currentPosition - 1].optionThree
        option4.text = questions[currentPosition - 1].optionFour
    }

    private fun toDefault(withSlected: Boolean = true) {
        if (withSlected) Constants.selected = 0
        option1.setBackgroundResource(R.drawable.default_option)
        option2.setBackgroundResource(R.drawable.default_option)
        option3.setBackgroundResource(R.drawable.default_option)
        option4.setBackgroundResource(R.drawable.default_option)
        checkButton.text = "Check"
    }

    private fun selectAnswer(tv: TextView, num: Int) {
        tv.setBackgroundResource(R.drawable.selected_option)
        Constants.selected = num
    }
}