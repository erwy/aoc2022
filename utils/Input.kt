package utils

class Input(private val name: String) {
    fun lines() =
        this::class.java.classLoader.getResourceAsStream(name)!!.bufferedReader().readLines()
}

fun String.asRange(): LongRange {
    val startAndEnd = this.split("-")
    return LongRange(startAndEnd[0].toLong(), startAndEnd[1].toLong())
}