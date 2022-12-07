package utils

class Terminal(val input: List<String>) {
    private val root: Directory = Directory("/")
    private var currentDirectory = root

    fun directoryTree(): Directory {
        input.map {
            with(it) {
                when {
                    equals("$ cd /") -> {
                        currentDirectory = root
                    }

                    equals("$ cd ..") -> {
                        currentDirectory = currentDirectory.parent ?: root
                    }

                    startsWith("$ cd") -> {
                        val directoryName = it.removePrefix("$ cd ").trim()
                        currentDirectory = currentDirectory.directories.first { it.name == directoryName }
                    }

                    startsWith("dir") -> {
                        val directoryName = it.removePrefix("dir ").trim()
                        currentDirectory.directories.add(Directory(directoryName, currentDirectory))
                    }

                    first().isDigit() -> {
                        val sizeAndName = it.split(" ")
                        currentDirectory.files.add(File(currentDirectory, sizeAndName[0].toLong(), sizeAndName[1]))
                    }

                    else -> {}
                }
            }
        }
        return root
    }
}

class Directory(
    val name: String,
    val parent: Directory? = null,
    val directories: MutableList<Directory> = mutableListOf(),
    val files: MutableList<File> = mutableListOf()
) {
    fun allDirectories() : List<Directory> {
        return directories.flatMap { it.allDirectories() } + directories
    }

    fun allFiles() : List<File> {
        return allDirectories().flatMap { it.files } + files
    }

    fun size() : Long {
        return allFiles().sumOf { it.size }
    }
}

class File(val parentDirectory: Directory, val size: Long, name: String)
