package com.example.conversion

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var inputValue: EditText
    private lateinit var fromUnit: Spinner
    private lateinit var toUnit: Spinner
    private lateinit var convertButton: Button
    private lateinit var resultText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        inputValue = findViewById(R.id.inputValue)
        fromUnit = findViewById(R.id.fromUnit)
        toUnit = findViewById(R.id.toUnit)
        convertButton = findViewById(R.id.convertButton)
        resultText = findViewById(R.id.resultText)

        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.units_array,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        fromUnit.adapter = adapter
        toUnit.adapter = adapter

        convertButton.setOnClickListener {
            val value = inputValue.text.toString().toDouble()
            val fromUnitStr = fromUnit.selectedItem.toString()
            val toUnitStr = toUnit.selectedItem.toString()

            val result = Converter.convert(value, fromUnitStr, toUnitStr)
            resultText.text = result.toString()
        }
    }
}
