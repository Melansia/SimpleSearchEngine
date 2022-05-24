package com.example.simplesearchengine

class SimpleSearchEngine {

    private val searchResult = mutableListOf<String?>()
    private lateinit var dataBase: MutableList<String>

    fun start() {
        println("Enter the number of people:")
        val size = readln().toInt()
        println("Enter all people: ")
        dataBase = MutableList(size) { readln() }

        println()
        println("Enter the number of search queries:")
        searchForResult(readln().toInt())
    }

    private fun searchForResult(numOfQueries: Int) {
        repeat(numOfQueries) {
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
}

fun main() {
    SimpleSearchEngine().start()
}