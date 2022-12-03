package utils

class Input(private val name: String) {
    fun lines() =
        this::class.java.classLoader.getResourceAsStream(name)!!.bufferedReader().readLines()
}

