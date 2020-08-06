package leetcode.medium.findallduplicatesinarr_442

class Solution {

    /*
    problem "trick"
    because of the limitation 1 <= a[i] <= n (n = size of array)
    all values will also be valid indexes.
    you can mark values you have visited by turning them negative
    if the value is already negative, that means you already visited it
    and there's a duplicate

    Time: O(n)
    Space: O(1)
     */
    fun findDuplicates(nums: IntArray): List<Int> {
        val list = mutableListOf<Int>()
        nums.forEach { num ->
            val index = Math.abs(num) - 1
            if(nums[index] < 0) {
                list.add(index + 1)
            }
            nums[index] = -nums[index]
        }
        return list
    }

    /*
    Time: O(n)
    Space: O(n)
     */
    fun findDuplicatesMap(nums: IntArray): List<Int> {
        val map = mutableMapOf<Int, Int>()
        nums.forEach {
            val count = map.getOrDefault(it, 0)
            map[it] = count + 1
        }
        val list = mutableListOf<Int>()
        map.entries.forEach { entry ->
            if(entry.value == 2) {
                list.add(entry.key)
            }
        }
        return list
    }
}

fun main() {
    Solution().findDuplicates(intArrayOf(4,3,2,7,8,2,3,1)).also {
        println(it.joinToString(", "))
    }
}