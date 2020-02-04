package leetcode.easy.deletecolumnstosort_944

// https://leetcode.com/problems/delete-columns-to-make-sorted/
class Solution {
    fun minDeletionSize(arr: Array<String>): Int {
        var count = 0
        for(i in arr[0].indices) {
            var prev = arr[0][i]
            for (a in arr) {
                if (prev > a[i]) {
                    count++
                    break
                } else prev = a[i]
            }
        }
        return count
    }
}

fun main() {
    Solution().minDeletionSize(arrayOf(
        "cba", "daf", "ghi"
    )).also { println(it) }

    Solution().minDeletionSize(arrayOf(
        "zyx", "wvu", "tsr"
    )).also { println(it) }

    Solution().minDeletionSize(arrayOf(
        "a", "b"
    )).also { println(it) }
}