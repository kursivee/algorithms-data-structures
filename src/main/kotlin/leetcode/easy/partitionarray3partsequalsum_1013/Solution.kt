package leetcode.easy.partitionarray3partsequalsum_1013

// https://leetcode.com/problems/partition-array-into-three-parts-with-equal-sum/
class Solution {
    fun canThreePartsEqualSum(A: IntArray): Boolean {
        val target = A.sum() / 3
        var sum = 0
        var count = 0
        A.forEach {
            sum += it
            if(sum == target) {
                count++
                sum = 0
            }
        }
        return count == 3
    }
}

fun main() {
    Solution().canThreePartsEqualSum(intArrayOf(
        0,2,1,-6,6,-7,9,1,2,0,1
    )).also {
        println(it)
    }

    Solution().canThreePartsEqualSum(intArrayOf(
        0,2,1,-6,6,7,9,-1,2,0,1
    )).also {
        println(it)
    }

    Solution().canThreePartsEqualSum(intArrayOf(
        18,12,-18,18,-19,-1,10,10
    )).also {
        println(it)
    }

    Solution().canThreePartsEqualSum(intArrayOf(
        15,20,-6,-17,-9,1,20,-1,13
    )).also {
        println(it)
    }
}