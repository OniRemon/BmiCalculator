package com.example.bmicalculator

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlin.math.pow
import kotlin.math.roundToInt

class MainViewModel: ViewModel() {
    var height by mutableStateOf("")
    var weight by mutableStateOf("")
    var bmi by mutableStateOf(0f)


    // BMI ＝ 体重kg ÷ (身長m)2
    fun calculatorBmi(){
        val heightNumber = height.toFloatOrNull()?.div(100) ?: 0f
        val wightNumber = weight.toFloatOrNull() ?: 0f

        bmi = if (heightNumber > 0f && wightNumber > 0f) {
            // BMI ＝ 体重kg ÷ (身長m)2            小数点第一位で四捨五入
            (wightNumber / heightNumber.pow(2) * 10).roundToInt() / 10f
        } else 0f
    }
}