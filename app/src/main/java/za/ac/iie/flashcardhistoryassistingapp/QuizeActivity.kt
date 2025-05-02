package za.ac.iie.flashcardhistoryassistingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button
import android.widget.Toast
import android.widget.TextView

class QuizActivity : AppCompatActivity() {
    private val flashcards = listOf(
        Flashcard("The great Wall of China is visible from space.", false),
        Flashcard("World war II ended in 1945.",true),
        Flashcard("Napoleon was defeated at Battle of waterloo.", true),
        Flashcard("The Roman Empire fell in 1066 AD.", false),
        Flashcard("The cold War was a direct military conflict.", false)
    )

    private var currentIndex = 0
    private var score = 0

    private lateinit var questionTextView: TextView
    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        questionTextView = findViewById(R.id.questionTextView)
        trueButton = findViewById<Button>(R.id.trueButton)
        falseButton = findViewById<Button>(R.id.falseButton)

        fun showQuestion() {
            if (currentIndex < flashcards.size) {
                questionTextView.text = flashcards[currentIndex].question
            }else {
              val intent = Intent(this, ScoreActivity::class.java)
                intent.putExtra("score", score)
                intent.putExtra("total", flashcards.size)
                startActivity(intent)
                finish()
            }
        }

        fun checkAnswer(answer: Boolean) {
            if (flashcards[currentIndex].answer == answer) {
                score++
                Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show()
            }else {
                Toast.makeText(this, "Incorrect!", Toast.LENGTH_SHORT).show()
            }
            currentIndex++
            showQuestion()
        }

        trueButton.setOnClickListener { checkAnswer(true) }
        falseButton.setOnClickListener { checkAnswer(false) }

        showQuestion()
    }

}