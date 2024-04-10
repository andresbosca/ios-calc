package com.example.calculator

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.view.MotionEvent
import android.widget.Button
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import java.io.Serializable

class ResultActivity : AppCompatActivity() {
    private lateinit var resultText: TextView
    private lateinit var returnButton: Button

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.result)

        resultText = findViewById(R.id.resultText)
        returnButton = findViewById(R.id.returnButton)

        val obj = intent.getSerializableExtra(NAME) as ResultContext

        if (obj != null){
            val outPutText = "Seu resultado foi: " + obj.result

            resultText.text = outPutText
        }


        returnButton.setOnClickListener {
            finish()
        }
    }

    companion object {
        val NAME = "resultObject"
    }
}

data class ResultContext(val result: Double) : Serializable
