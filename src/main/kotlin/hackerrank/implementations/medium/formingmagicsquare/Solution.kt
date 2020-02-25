package hackerrank.implementations.medium.formingmagicsquare

class Solution {
    private val list = listOf(
        arrayOf(
            arrayOf(8,3,4),
            arrayOf(1,5,9),
            arrayOf(6,7,2)
        ),
        arrayOf(
            arrayOf(6,7,2),
            arrayOf(1,5,9),
            arrayOf(8,3,4)
        ),
        arrayOf(
            arrayOf(2,7,6),
            arrayOf(9,5,1),
            arrayOf(4,3,8)
        ),
        arrayOf(
            arrayOf(4,3,8),
            arrayOf(9,5,1),
            arrayOf(2,7,6)
        ),
        arrayOf(
            arrayOf(4,9,2),
            arrayOf(3,5,7),
            arrayOf(8,1,6)
        ),
        arrayOf(
            arrayOf(8,1,6),
            arrayOf(3,5,7),
            arrayOf(4,9,2)
        ),
        arrayOf(
            arrayOf(2,9,4),
            arrayOf(7,5,3),
            arrayOf(6,1,8)
        ),
        arrayOf(
            arrayOf(6,1,8),
            arrayOf(7,5,3),
            arrayOf(2,9,4)
        )
    )

    fun formingMagicSquare(s: Array<Array<Int>>): Int {
        var min = Int.MAX_VALUE
        list.forEach {
            var diff = 0
            for(i in it.indices) {
                for(j in it[0].indices) {
                    diff += Math.abs(it[i][j] - s[i][j])
                }
            }
            min = Math.min(min, diff)
        }
        return min
    }
}

fun main() {
    Solution().formingMagicSquare(arrayOf(
        arrayOf(4,9,2),
        arrayOf(3,5,7),
        arrayOf(8,1,5)
    )).also {
        println(it)
    }
}