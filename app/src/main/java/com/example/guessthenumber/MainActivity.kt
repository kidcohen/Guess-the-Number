package com.example.guessthenumber

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var random = (0..50).random()
        var guessCounter = 0
        button.setOnClickListener { //guesscounter= 0
            if (guessCounter == 0) {
                textView.text = "Guess What Number I am Thinking Between 0 and 50"
                button.text = "Ready to Guess?"
                textView3.visibility = View.GONE

            } else {
                button.text = "Guess Again?"
            }

            if (numberGuess.text.isNullOrEmpty()) {
                if (guessCounter == 0) {

                } else {
                    Toast.makeText(
                        this,
                        "Please enter a value all things have a value",
                        Toast.LENGTH_SHORT
                    ).show()
                }

            } else {
                var userInput = numberGuess.text.toString().toInt()
                if (userInput < 0 || userInput > 50) {
                    Toast.makeText(this, "Only Guess between 0 and 50", Toast.LENGTH_SHORT).show()
                    numberGuess.text.clear()
                } else {
                    guessCounter = guessCounter + 1 //
                    textView3.visibility = View.VISIBLE
                    textView3.text = "How Many Tries? $guessCounter"
                    if (random > userInput) {
                        textView
                            .text = "random number is GREATER"
                        Toast.makeText(this, "You're guessing too LOW?!", Toast.LENGTH_SHORT).show()
                    } else if (random < userInput) {
                        textView
                            .text = "random number is LOWER"
                        Toast.makeText(this, "Get me HIGH", Toast.LENGTH_SHORT).show()
                    } else {
                        textView
                            .text = "CONGRATULATIONS you can guess again, YAY!!!"
                        Toast.makeText(this, "Finally... So ANNOYING!!!", Toast.LENGTH_SHORT).show()
                        random = (0..50).random()
                        button.text = "Try one more time... PLEASE!!!"
                        numberGuess.text.clear()
                        if (guessCounter <= 7) {
                            Toast.makeText(this, "You're So Smart!!!", Toast.LENGTH_SHORT).show()
                        } else {
                            Toast.makeText(
                                this,
                                "You really think you're smart?!",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                        guessCounter = 0
                    }
                }


            }
        }
    }
}