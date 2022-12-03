package day2

import utils.Input
import utils.Part

class Day {
    private val input = Input("day2/data.txt").lines()
    private val example = Input("day2/example.txt").lines()

    private val parts = listOf(Part1(input), Part2(input))
    private val exampleParts = listOf(Part1(example), Part2(example))

    fun run() {
        println("Example")
        exampleParts.map { println(it.run()) }
        println("Input")
        parts.map { println(it.run()) }
    }
}

class Part1(private val input: List<String>) : Part {

    override fun run(): Long {
        return input.map {
            val split = it.split(" ")
            val opponent = split[0]
            when (split[1]) {
                "X" -> when (opponent) {
                    "A" -> 4
                    "B" -> 1
                    "C" -> 7
                    else -> 0
                }

                "Y" -> when (opponent) {
                    "A" -> 8
                    "B" -> 5
                    "C" -> 2
                    else -> 0
                }

                "Z" -> when (opponent) {
                    "A" -> 3
                    "B" -> 9
                    "C" -> 6
                    else -> 0
                }

                else -> 0
            }
        }.sum().toLong()
    }
}

class Part2(private val input: List<String>) : Part {
    override fun run(): Long {
        return input.map {
            val split = it.split(" ")
            val opponent = split[0]
            when (split[1]) {
                "X" -> when (opponent) {
                    "A" -> 3
                    "B" -> 1
                    "C" -> 2
                    else -> 0
                }

                "Y" -> when (opponent) {
                    "A" -> 4
                    "B" -> 5
                    "C" -> 6
                    else -> 0
                }

                "Z" -> when (opponent) {
                    "A" -> 8
                    "B" -> 9
                    "C" -> 7
                    else -> 0
                }

                else -> 0
            }
        }.sum().toLong()
    }
}

fun main() {
    println(Day().run())
}
