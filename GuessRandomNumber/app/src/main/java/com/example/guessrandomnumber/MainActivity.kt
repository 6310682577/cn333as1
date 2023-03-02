package com.example.guessrandomnumber

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AutoCompleteTextView
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import kotlin.random.Random.Default.nextInt

class MainActivity : AppCompatActivity() {

    lateinit var textHeader: TextView
    lateinit var textResult : TextView
    lateinit var textTriesCount : TextView
    lateinit var editText: EditText
    lateinit var imageButtonReset : ImageButton
    lateinit var imageButtonCheck: ImageButton

    var randomInt: Int = nextInt(1,10)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textHeader = findViewById(R.id.textHeader)
        editText = findViewById(R.id.editText)
        textHeader = findViewById(R.id.textHeader)
        textResult = findViewById(R.id.textResult)
        textTriesCount = findViewById(R.id.textTriesCount)
        imageButtonCheck = findViewById(R.id.imageButtonCheck)
        imageButtonReset = findViewById(R.id.imageButtonReset)

        textHeader.text = "Choose Number between 1 - 10"

        var count = 0

        imageButtonCheck.setOnClickListener{

            val inputNum: Int = editText.text.toString().toInt()
            count++


                if (inputNum < randomInt) {

                    textResult.text = "your number is too low"
                    textTriesCount.text = "Current Count = $count"
                    editText.text.clear()

                } else if (inputNum > randomInt) {

                    textResult.text = "your number is too high"
                    textTriesCount.text = "Current Count = $count"
                    editText.text.clear()

                } else {

                    textResult.text = "Congratulations! You are correct!"
                    textTriesCount.text = "Current Count = $count"
                    editText.text.clear()
                    count = 0

                }

        }

        imageButtonReset.setOnClickListener{

            reset()
        }

    }

    private fun reset() {
        randomInt = nextInt(1,10)
        textHeader.text = "Choose Number between 1 - 10"
        editText.text.clear()
        textResult.text = "Result"
        textTriesCount.text = "Count"

    }
}