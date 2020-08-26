package leetcode.easy.twosum2_167

class Solution {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        var l = 0
        var r = numbers.size - 1
        var sum = numbers[l] + numbers[r]
        while(numbers[l] + numbers[r] != target) {
            if(sum > target) {
                r--
            } else {
                l++
            }
            sum = numbers[l] + numbers[r]
        }
        return intArrayOf(l + 1, r + 1)
    }

    fun twoSumMap(numbers: IntArray, target: Int): IntArray {
        val map = mutableMapOf<Int, Int>()
        for(i in numbers.indices) {
            val diff = target - numbers[i]
            if(map.contains(diff)) {
                return intArrayOf(map[diff]!!, i + 1)
            }
            map[numbers[i]] = i + 1
        }
        return intArrayOf()
    }


    fun twoSumSlow(numbers: IntArray, target: Int): IntArray {
        for(i in numbers.indices) {
            for(j in i + 1 until numbers.size) {
                if(numbers[i] + numbers[j] == target) return intArrayOf(i + 1,j + 1)
            }
        }
        return intArrayOf()
    }
}