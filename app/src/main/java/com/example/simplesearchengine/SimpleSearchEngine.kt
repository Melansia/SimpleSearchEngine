package com.example.simplesearchengine

fun main() {
    val inputString = readln().split(" ")
    val orderOfWord = readln()

    when {
        inputString.contains(orderOfWord) -> println(inputString.indexOf(orderOfWord) + 1)
        else -> println("Not Found")
    }

}