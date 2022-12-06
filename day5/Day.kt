package day5

import utils.Input
import utils.Part

class Day {
    private val input = Input("day5/data.txt").lines()
    private val example = Input("day5/example.txt").lines()

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
        val (stacks, moves) = input.indexOf("").let {
            input.subList(0, it - 1) to input.subList(it + 1, input.size)
        }
        val stackIndexToList = mutableMapOf<Int, MutableList<String>>()

        stacks.map {
            it.chunked(4).forEachIndexed { index, crate ->
                val crateName = crate.trim().trim { it == '[' }.trim { it == ']' }
                if (crateName.isNotBlank()) {
                    if (stackIndexToList[index] == null) {
                        stackIndexToList[index] = mutableListOf(crateName)
                    } else {
                        stackIndexToList[index]?.add(crateName)
                    }
                }
            }
        }
        val move = Regex("move (\\d*) from (\\d*) to (\\d*)")
        val movesAs = moves.map { move.matchEntire(it)?.groupValues?.subList(1, 4) }
        movesAs.forEach {
            val number = it?.get(0)?.toInt() ?: -1
            val from = it?.get(1)?.toInt()?.minus(1) ?: -1
            val to = it?.get(2)?.toInt()?.minus(1) ?: -1
            val originStack = stackIndexToList[from] ?: mutableListOf()
            val destinationStack = stackIndexToList[to] ?: mutableListOf()
            stackIndexToList[from] = originStack.subList(number, originStack.size)
            destinationStack.addAll(0, originStack.subList(0, number).reversed())
            stackIndexToList[to] = destinationStack
        }
        stackIndexToList.toSortedMap().values.map { it.first() }.joinToString(separator = "").also { println(it) }
        return 0L
    }
}


class Part2(private val input: List<String>) : Part {
    override fun run(): Long {
        val (stacks, moves) = input.indexOf("").let {
            input.subList(0, it - 1) to input.subList(it + 1, input.size)
        }
        val stackIndexToList = mutableMapOf<Int, MutableList<String>>()

        stacks.map {
            it.chunked(4).forEachIndexed { index, crate ->
                val crateName = crate.trim().trim { it == '[' }.trim { it == ']' }
                if (crateName.isNotBlank()) {
                    if (stackIndexToList[index] == null) {
                        stackIndexToList[index] = mutableListOf(crateName)
                    } else {
                        stackIndexToList[index]?.add(crateName)
                    }
                }
            }
        }
        val move = Regex("move (\\d*) from (\\d*) to (\\d*)")
        val movesAs = moves.map { move.matchEntire(it)?.groupValues?.subList(1, 4) }
        movesAs.forEach {
            val number = it?.get(0)?.toInt() ?: -1
            val from = it?.get(1)?.toInt()?.minus(1) ?: -1
            val to = it?.get(2)?.toInt()?.minus(1) ?: -1
            val originStack = stackIndexToList[from] ?: mutableListOf()
            val destinationStack = stackIndexToList[to] ?: mutableListOf()
            stackIndexToList[from] = originStack.subList(number, originStack.size)
            destinationStack.addAll(0, originStack.subList(0, number))
            stackIndexToList[to] = destinationStack
        }
        stackIndexToList.toSortedMap().values.map { it.first() }.joinToString(separator = "").also { println(it) }
        return 0L
    }
}

fun main() {
    println(Day().run())
}
