package com.example.simplesearchengine

class SimpleSearchEngine {

    private val searchResult = mutableListOf<String?>()
    private lateinit var dataBase: MutableList<String>

    fun start() {
        println("Enter the number of people:")
        val size = readln().toInt()
        println("Enter all people: ")
        dataBase = MutableList(size) { readln() }

        menu()
    }

    private fun menu() {
        while (true) {
            println()
            println(
                """
            |=== Menu ===
            |1. Find a person
            |2. Print all people
            |0. Exit
            """.trimMargin("|")
            )
            when (readln()) {
                "1" -> searchForResult()
                "2" -> printAllPeople()
                "0" -> {
                    println()
                    println("Bye!")
                    return
                }
            }
        }
    }

    private fun printAllPeople() {
        println()
        println("=== List of people ===")
        dataBase.forEach { println(it) }
    }

    private fun searchForResult() {
        println()
        println("Enter data to search people:")
        val dataEntered = readln()
        for (i in dataBase) {
            when {
                i.contains(dataEntered, true) -> searchResult.add(i)
                else -> continue
            }
        }
        if (searchResult.isNotEmpty()) {
            println()
            println("People found:")
            searchResult.forEach {
                println(it)
            }
        } else {
            println("No matching people found.")
        }
        searchResult.clear()
    }
}

fun main() {
    SimpleSearchEngine().start()
}