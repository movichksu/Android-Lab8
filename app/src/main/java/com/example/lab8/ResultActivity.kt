package com.example.lab8

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {

    private lateinit var numbersText: TextView
    private lateinit var numberEditText: EditText
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        numbersText = findViewById(R.id.numbersTextView)
        numberEditText = findViewById(R.id.numbersEditText)
        button = findViewById(R.id.okButton)
        val topNumber = intent.getStringExtra(Constants.NUMBER_KEY) ?: Constants.TWO

        numbersText.text = (baseContext.getString(R.string.simple_numbers_until) + " $topNumber")
        numberEditText.setText(getSimpleNumbers(topNumber.toInt()).toString())

        button.setOnClickListener {
            finish()
        }
    }

    private fun getSimpleNumbers(n: Int) : MutableList<Int> {
        val primeList = mutableListOf<Int>()
        var isPrime: Boolean
        for (i in 2..n) {
            isPrime = true;
            var j = 2
            while (j <= i/j) {
                if ((i % j) == 0) isPrime = false
                j++
            }
            if (isPrime) primeList.add(i);
        }
        return primeList;
    }
}