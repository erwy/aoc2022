package day8

import utils.Input
import utils.Part

class Day {
    private val input = Input("day8/data.txt").lines()
    private val example = Input("day8/example.txt").lines()

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
        return 0L
    }
}

class Part2(private val input: List<String>) : Part {
    override fun run(): Long {
        return 0L
    }
}

fun main() {
    println(Day().run())
}
