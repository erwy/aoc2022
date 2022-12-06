package day6

import utils.Input
import utils.Part

class Day {
    private val input = Input("day6/data.txt").lines()
    private val example = Input("day6/example.txt").lines()

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
        return input.first().windowed(4).mapIndexed { index, s ->
            if (s.toSet().size == 4) {
                index + 4
            } else {
                null
            }
        }.filterNotNull().min().toLong()
    }
}


class Part2(private val input: List<String>) : Part {
    override fun run(): Long {
        return input.first().windowed(14).mapIndexed { index, s ->
            if (s.toSet().size == 14) {
                index + 14
            } else {
                null
            }
        }.filterNotNull().min().toLong()
    }
}

fun main() {
    println(Day().run())
}
