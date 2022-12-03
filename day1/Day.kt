package day1

import utils.Input
import utils.Part

class Day {
    private val input = Input("day1/data.txt").lines()
    private val example = Input("day1/example.txt").lines()

    private val parts = listOf(Part1(input), Part2(input))
    private val exampleParts = listOf(Part1(example), Part2(example))

    fun run() {
        println("Example")
        exampleParts.map { println(it.run()) }
        println("day1.Input")
        parts.map { println(it.run()) }
    }
}



class Part1(private val input: List<String>) : Part {

    override fun run(): Long {
        var currentSum = 0L
        val mutableList = mutableListOf<Long>()
        input.forEach {
            if (it.isBlank()) {
                mutableList.add(currentSum)
                currentSum = 0
            } else {
                currentSum += it.toLong()
            }
        }
        return mutableList.max()
    }
}

class Part2(private val input: List<String>) : Part {
    override fun run(): Long {
        var currentSum = 0L
        val mutableList = mutableListOf<Long>()
        input.forEach {
            if (it.isBlank()) {
                mutableList.add(currentSum)
                currentSum = 0
            } else {
                currentSum += it.toLong()
            }
        }
        mutableList.add(currentSum)
        return mutableList.sorted().reversed().subList(0, 3).sum()
    }
}

fun main() {
    println(Day().run())
}
