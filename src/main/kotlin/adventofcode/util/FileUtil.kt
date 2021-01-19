package adventofcode.util

import java.io.File
import java.io.FileNotFoundException

object FileUtil {
    fun read(path: String, trim: Boolean = true): String {
        val resource = Int::class.java.getResource(path)
        if (resource == null) throw FileNotFoundException("could not load '$path'")
        val file = File(resource.toURI())
        return file.readText()
    }
}