package za.ac.iie.flashcardhistoryassistingapp

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ReviewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.reviewactivity)

        val questions = intent.getStringArrayListExtra("questions") ?: arrayListOf()
        val correctAnswers = intent.getStringArrayListExtra("correctAnswers") ?: arrayListOf()
        val userAnswers = intent.getStringArrayListExtra("userAnswers") ?: arrayListOf()

        val container = findViewById<LinearLayout>(R.id.reviewContainer)

        for (i in questions.indices){
            val questionView = TextView(this)
            questionView.text = "Q${i+1}: ${questions[i]}"
            questionView.textSize = 18f

            val userAnswersView = TextView(this)
            userAnswersView.text = "Your Answer: ${userAnswers.getOrNull(i) ?: "N/A"}"
            userAnswersView.setTextColor(resources.getColor(android.R.color.holo_blue_dark))

            val correctAnswerView = TextView (this)
            correctAnswerView.text = "Correct Answer: ${correctAnswers.getOrNull(i) ?: "N/A"}"
            correctAnswerView.setTextColor(resources.getColor(android.R.color.holo_green_dark))

            val spacer = TextView(this)
            spacer.text = "\n"

            container.addView(questionView)
            container.addView(userAnswersView)
            container.addView(correctAnswerView)
            container.addView(spacer)
        }

    }
}