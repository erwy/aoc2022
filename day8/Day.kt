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
        val matrix = input.map { row -> row.chars().toArray().toList() }.toList()
        val numberInBorder = (matrix.size - 2) * 2 + matrix.first().size * 2
        val columns = input.first().chars().count().toInt()
        val rows = input.size
        var total = numberInBorder
        for (columnIndex in 1 until columns - 1) {
            for (rowIndex in 1 until rows - 1) {
                val value = matrix[rowIndex][columnIndex]
                val columnValues = matrix.map { it[columnIndex] }
                val rowValues = matrix[rowIndex]
                val rowValues1 = rowValues.subList(0, columnIndex)
                val rowValues2 = rowValues.subList(columnIndex + 1, columns)
                val columnValues1 = columnValues.subList(0, rowIndex)
                val columnsValues2 = columnValues.subList(rowIndex + 1, rows)
                val rowSize1 = rowValues1.count { it >= value }
                val rowSize2 = rowValues2.count { it >= value }
                val columnSize1 = columnValues1.count { it >= value }
                val columnSize2 = columnsValues2.count { it >= value }
                if (rowSize1 == 0 || rowSize2 == 0 || columnSize1 == 0 || columnSize2 == 0) total++
            }
        }
        return total.toLong()
    }
}

class Part2(private val input: List<String>) : Part {
    override fun run(): Long {
        val matrix = input.map { row -> row.chars().toArray().toList() }.toList()
        val columns = input.first().chars().count().toInt()
        val rows = input.size
        var maxScenic = 0
        for (columnIndex in 0 until columns) {
            for (rowIndex in 0 until rows) {
                val value = matrix[rowIndex][columnIndex]
                val columnValues = matrix.map { it[columnIndex] }
                val rowValues = matrix[rowIndex]
                val rowValues1 = rowValues.subList(0, columnIndex).reversed()
                val rowValues2 = rowValues.subList(columnIndex + 1, columns)
                val columnValues1 = columnValues.subList(0, rowIndex).reversed()
                val columnsValues2 = columnValues.subList(rowIndex + 1, rows)
                var rowVisible1 = rowValues1.indexOfFirst { it >= value } + 1
                var rowVisible2 = rowValues2.indexOfFirst { it >= value } + 1
                var columnVisible1 = columnValues1.indexOfFirst { it >= value } + 1
                var columnVisible2 = columnsValues2.indexOfFirst { it >= value } + 1
                if (rowVisible1 == 0) rowVisible1 = rowValues1.size
                if (rowVisible2 == 0) rowVisible2 = rowValues2.size
                if (columnVisible1 == 0) columnVisible1 = columnValues1.size
                if (columnVisible2 == 0) columnVisible2 = columnsValues2.size
                val scenic = rowVisible1 * rowVisible2 * columnVisible1 * columnVisible2
                if (scenic > maxScenic) maxScenic = scenic
            }
        }
        return maxScenic.toLong()
    }
}

fun main() {
    println(Day().run())
}
