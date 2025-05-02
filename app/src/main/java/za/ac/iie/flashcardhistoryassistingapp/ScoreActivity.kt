package za.ac.iie.flashcardhistoryassistingapp

import android.os.Bundle
import android.content.Intent
import android.widget.TextView
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class ScoreActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)

        val score = intent.getIntExtra("score", 0)
        val total = intent.getIntExtra("total", 0)
        val questions = intent.getStringArrayListExtra("questions")?: arrayListOf()
        val correctAnswers = intent.getStringArrayListExtra("correctAnswers")?: arrayListOf()
        val userAnwers = intent.getStringArrayListExtra("userAnswers")?: arrayListOf()

        val scoreTextView = findViewById<TextView>(R.id.scoreTextView)
        val feedbackTextView = findViewById<TextView>(R.id.feedbackTextView)
        val reviewButton = findViewById<Button>(R.id.ReviewButton)

        scoreTextView.text = "Your Score: $score / $total"

        feedbackTextView.text = if (score >= 3) {
            "Great job!"
        } else {
            "Keep practicing!"
        }

        reviewButton.setOnClickListener {
            val intent = Intent(this, ReviewActivity::class.java)
            intent.putStringArrayListExtra("questions", questions)
            intent.putStringArrayListExtra("correctAnswers", correctAnswers)
            intent.putStringArrayListExtra("userAnswers", userAnwers)
            startActivity(intent)
        }
    }
}