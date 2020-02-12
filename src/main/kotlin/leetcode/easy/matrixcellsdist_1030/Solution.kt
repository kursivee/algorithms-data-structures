package leetcode.easy.matrixcellsdist_1030

// https://leetcode.com/problems/matrix-cells-in-distance-order/
class Solution {
    fun allCellsDistOrder(R: Int, C: Int, r0: Int, c0: Int): Array<IntArray> {
        val arr = Array(R * C) { IntArray(2) }
        var index = 0
        for(i in 0 until R) {
            for(j in 0 until C) {
                arr[index][0] = i
                arr[index][1] = j
                index++
            }
        }
        return arr.also {
            it.sortBy {  intArr ->
                Math.abs(intArr[0] - r0) + Math.abs(intArr[1] - c0)
            }
        }
    }
}

fun main() {
    Solution().allCellsDistOrder(2, 2, 0, 1).also {
        it.forEach { arr ->
            print("[${arr.joinToString(", ")}], ")
        }
        println()
    }

    Solution().allCellsDistOrder(2, 3, 1, 2).also {
        it.forEach { arr ->
            print("[${arr.joinToString(", ")}], ")
        }
        println()
    }

    Solution().allCellsDistOrder(3, 4, 0, 1).also {
        it.forEach { arr ->
            print("[${arr.joinToString(", ")}], ")
        }
        println()
    }
}