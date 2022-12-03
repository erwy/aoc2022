package day3

import utils.Input
import utils.Part

class Day {
    private val input = Input("day3/data.txt").lines()
    private val example = Input("day3/example.txt").lines()

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
        return input.flatMap {
            val comp1 = it.substring(0, it.length / 2).toSet()
            val comp2 = it.substring(it.length / 2).toSet()
            comp1 intersect comp2
        }.map { if (it.isLowerCase()) it - 96 else it - 38 }.sumOf { it.code }.toLong()
    }
}

class Part2(private val input: List<String>) : Part {
    override fun run(): Long {
        return input.chunked(3).flatMap {
            it[0].toSet() intersect it[1].toSet() intersect it[2].toSet()
        }.map { if (it.isLowerCase()) it - 96 else it - 38 }.sumOf { it.code }.toLong()
    }
}

fun main() {
    println(Day().run())
}
