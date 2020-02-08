package ir.airport.kotlinapplication

import android.icu.text.NumberFormat
import java.util.*

fun String.AviationFormat():String{
    val out: String
    out=this.replace("@","?").toUpperCase()
    return out
}

fun String.isValidIranianNationalCode(): Boolean {
    if (this.length!=10)
        return false
    else {
        this.toCharArray().map(Character::getNumericValue).let {
            val check = it[9]
            val sum = (0..8).map { i -> it[i] * (10 - i) }.sum() % 11
            return sum < 2 && check == sum || sum >= 2 && check + sum == 11
        }
    }
}

