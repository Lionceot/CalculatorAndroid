package com.example.taskmanagerandroid

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var btnAdd : Button
    lateinit var btnSub : Button
    lateinit var btnMul : Button
    lateinit var btnDiv : Button
    lateinit var inputA : EditText
    lateinit var inputB : EditText
    lateinit var resultTextView : TextView
    lateinit var errorMessage : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnAdd = findViewById(R.id.btn_add)
        btnSub = findViewById(R.id.btn_sub)
        btnMul = findViewById(R.id.btn_mul)
        btnDiv = findViewById(R.id.btn_div)
        inputA = findViewById(R.id.input_a)
        inputB = findViewById(R.id.input_b)
        resultTextView = findViewById(R.id.text_result)
        errorMessage = findViewById(R.id.error_message)

        btnAdd.setOnClickListener(this)
        btnSub.setOnClickListener(this)
        btnMul.setOnClickListener(this)
        btnDiv.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        var valueA : Double = 0.0
        var valueB : Double = 0.0

        var cancelAction = false

        try {
            valueA = inputA.text.toString().toDouble()
            inputA.setTextColor(Color.BLACK)
        } catch (_: NumberFormatException) {
            cancelAction = true
            inputA.setTextColor(Color.RED)
        }

        try {
            valueB = inputB.text.toString().toDouble()
            inputB.setTextColor(Color.BLACK)
        } catch (_: NumberFormatException) {
            cancelAction = true
            inputB.setTextColor(Color.RED)
        }

        if (cancelAction) {
            errorMessage.text = "Incorrect input"
            return
        } else {
            errorMessage.text = ""
        }

        var result : Double? = null

        when(v?.id){
            R.id.btn_add -> result = valueA + valueB
            R.id.btn_sub -> result = valueA - valueB
            R.id.btn_mul -> result = valueA * valueB
            R.id.btn_div -> result = valueA / valueB
        }

        if (result == null) {
            return
        }

        if (result == result.toInt().toDouble()) {
            resultTextView.text = "Result: ${result.toInt()}"
        } else {
            resultTextView.text = "Result: $result"
        }
    }
}