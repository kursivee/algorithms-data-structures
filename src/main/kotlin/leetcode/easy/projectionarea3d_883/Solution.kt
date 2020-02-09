package leetcode.easy.projectionarea3d_883

// https://leetcode.com/problems/projection-area-of-3d-shapes/

/**
1z on 1x, 1y = (1, 1), (1, 1), (1, 1)
2z on 1x, 2y = (1, 2), (2, 2), (2, 1)
3z on 2x, 1y = (2, 1), (1, 3), (3, 2)
4z on 2x, 2y = (2, 2), (2, 4), (4, 2)

yz, zx: Group the 1 and 2 What's the highest z?
xy: Get count of points?

(2 + 2) + (4 + 3) + (4 + 2) = 4 + 7 + 6 = 17
-----------------------------
2 on 1x, 1y = (1, 1), (1, 2), (2, 1)
1 + 2 + 2 = 5
-----------------------------
1 on 1x, 1y = (1, 1), (1, 1), (1, 1)
2 on 2x, 2y = (2, 2), (2, 2), (2, 2)

(1) + (1 + 2) + (1 + 2) = 9
-----------------------------
1 on 1x, 1y = (1, 1), (1, 1), (1, 1)
1 on 1x, 2y = (1, 2), (2, 1), (1, 1)
1 on 1x, 3y = (1, 3), (3, 1), (1, 1)
1 on 2x, 1y = (2, 1), (1, 1), (1, 2)
1 on 2x, 3y = (2, 3), (3, 1), (1, 2)
1 on 3x, 1y = (3, 1), (1, 1), (1, 3)
1 on 3x, 2y = (3, 2), (2, 1), (1, 3)
1 on 3x, 3y = (3, 3), (3, 1), (1, 3)

8 + (1 + 1 + 1) + (1 + 1 + 1) = 14
 */

class Solution {
    fun projectionArea(grid: Array<IntArray>): Int {
        var xyCount = 0
        val yzMaxMap = mutableMapOf<Int, Int>()
        val xzMaxMap = mutableMapOf<Int, Int>()
        grid.forEachIndexed { x, ints ->
            ints.forEachIndexed { y, z ->
                if(z != 0) {
                    xyCount++
                    if(yzMaxMap[y] ?: 0 < z) {
                        yzMaxMap[y] = z
                    }
                    if(xzMaxMap[x] ?: 0 < z) {
                        xzMaxMap[x] = z
                    }
                }
            }
        }
        return xyCount + yzMaxMap.values.sum() + xzMaxMap.values.sum()
    }
}

fun main() {
    Solution().projectionArea(arrayOf(
        intArrayOf(2)
    )).also { println(it) }

    Solution().projectionArea(arrayOf(
        intArrayOf(1, 2),
        intArrayOf(3, 4)
    )).also { println(it) }

    Solution().projectionArea(arrayOf(
        intArrayOf(1, 0),
        intArrayOf(0 ,2)
    )).also { println(it) }
}