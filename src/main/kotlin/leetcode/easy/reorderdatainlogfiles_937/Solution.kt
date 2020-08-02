package leetcode.easy.reorderdatainlogfiles_937

class Solution {
    /*
     digLogs
     letLogs
    */

    val comparator = Comparator<String> { a, b ->
        val startA = a.indexOf(" ")
        val startB = b.indexOf(" ")
        val textA = a.substring(startA + 1, a.length)
        val textB = b.substring(startB + 1, b.length)
        val idA = a.substring(0, startA)
        val idB = b.substring(0, startB)

        when {
            textA == textB -> idA.compareTo(idB)
            else -> textA.compareTo(textB)
        }
    }

    fun reorderLogFiles(logs: Array<String>): Array<String> {
        val digLogs = mutableListOf<String>()
        var letLogs = mutableListOf<String>()
        logs.forEach { s ->
            if(s.split(" ")[1][0].isDigit()) {
                digLogs.add(s)
            } else {
                letLogs.add(s)
            }
        }

        letLogs = letLogs.sortedWith(comparator).toMutableList()

        letLogs.addAll(digLogs)
        return letLogs.toTypedArray()
    }
}

fun main() {
    Solution().reorderLogFiles(arrayOf("dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"))
        .also { println(it.joinToString(", ")) }
}