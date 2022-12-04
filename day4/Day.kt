package day4

import utils.Input
import utils.Part
import utils.asRange

class Day {
    private val input = Input("day4/data.txt").lines()
    private val example = Input("day4/example.txt").lines()

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
    override fun run() = input.map {
        it.split(",")
    }.map {
        val set1 = it[0].asRange().toSet()
        val set2 = it[1].asRange().toSet()
        set1 to set2
    }.count {
        it.first.containsAll(it.second) || it.second.containsAll(it.first)
    }.toLong()
}


class Part2(private val input: List<String>) : Part {
    override fun run() = input.map {
        it.split(",")
    }.map {
        val set1 = it[0].asRange().toSet()
        val set2 = it[1].asRange().toSet()
        set1 to set2
    }.count {
        (it.first intersect it.second).isNotEmpty()
    }.toLong()
}

fun main() {
    println(Day().run())
}
