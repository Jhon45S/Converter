package com.example.conversion

class Converter {
    companion object {
        fun convert(value: Double, fromUnit: String, toUnit: String): Double {
            if (fromUnit == toUnit) {
                return value
            }

            return when (fromUnit + " to " + toUnit) {
                "Celsius to Fahrenheit" -> (value * 9/5) + 32
                "Fahrenheit to Celsius" -> (value - 32) * 5/9
                else -> throw IllegalArgumentException("Invalid conversion")
            }
        }
    }
}
