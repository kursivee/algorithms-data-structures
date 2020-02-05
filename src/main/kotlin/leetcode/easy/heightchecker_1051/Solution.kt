package leetcode.easy.heightchecker_1051

// https://leetcode.com/problems/height-checker/
class Solution {
    data class Student(var id: Int, var moved: Boolean)

    fun heightChecker(heights: IntArray): Int {
        val list = heights.map {
            Student(it, false)
        }
        for(i in 0..list.size - 2) {
            var studentSwap: Student? = null
            val s1 = list[i]
            for(j in i until list.size) {
                val s2 = list[j]
                if(s1.id > s2.id) {
                    studentSwap?.let {
                        if(it.id >= s2.id) studentSwap = s2
                    } ?: run { studentSwap = s2 }
                }
            }
            studentSwap?.let { s1.swap(it) }
        }
        return list.filter { it.moved }.size
    }

    private fun Student.swap(student: Student) {
        val temp = id
        id = student.id
        student.id = temp
        student.moved = true
        moved = true
    }

    fun heightCheckerSorted(heights: IntArray): Int {
        val sorted = heights.sorted()
        var count = 0
        heights.forEachIndexed { index, i ->
            if(sorted[index] != i) count++
        }
        return count
    }
}

fun main() {
    Solution().heightChecker(intArrayOf(
        1,1,4,2,1,3
    )).also { println(it == 3) }

    Solution().heightChecker(intArrayOf(
        2,1,2,1,1,2,2,1
    )).also { println(it == 4) }

    Solution().heightCheckerSorted(intArrayOf(
        1,1,4,2,1,3
    )).also { println(it == 3) }

    Solution().heightCheckerSorted(intArrayOf(
        2,1,2,1,1,2,2,1
    )).also { println(it == 4) }
}