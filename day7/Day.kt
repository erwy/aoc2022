package day7

import utils.Input
import utils.Part
import utils.Terminal

class Day {
    private val input = Input("day7/data.txt").lines()
    private val example = Input("day7/example.txt").lines()

    private val parts = listOf(Part1(input), Part2(input))
    private val exampleParts = listOf(Part1(example), Part2(example))

    fun run() {
        println("Example")
        exampleParts.map { println(it.run()) }
        println("Input")
        parts.map { println(it.run()) }
    }
}

class Part1(input: List<String>) : Part {
    private val terminal = Terminal(input)
    override fun run(): Long {
        val root = terminal.directoryTree()
        return root.allDirectories().filter { it.size() <= 100000 }.sumOf { it.size() }
    }
}

class Part2(input: List<String>) : Part {
    private val terminal = Terminal(input)
    override fun run(): Long {
        val root = terminal.directoryTree()
        val neededToFree = 30000000L - (70000000L - root.allFiles().sumOf { it.size })
        return root.allDirectories().filter { it.size() >= neededToFree }.minOf { it.size() }
    }
}

fun main() {
    println(Day().run())
}
