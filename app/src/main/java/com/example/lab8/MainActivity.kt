package com.example.lab8

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf

class MainActivity : AppCompatActivity() {

    private lateinit var numberEditText: EditText
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        numberEditText = findViewById(R.id.numberEditText)
        button = findViewById(R.id.okButton)

        button.setOnClickListener {
            if (numberEditText.text.toString().isBlank()) {
                Toast.makeText(
                    applicationContext,
                    getString(R.string.error_toast),
                    Toast.LENGTH_LONG
                ).show()
                return@setOnClickListener
            }
            launchActivity(ResultActivity::class.java)
        }
    }

    private fun launchActivity(activityClass: Class<out Activity>) {
        val intent = Intent(this@MainActivity, activityClass)
        val numberFieldContent = numberEditText.text.toString()
        intent.putExtras(bundleOf(Constants.NUMBER_KEY to numberFieldContent))
        startActivity(intent)
    }
}