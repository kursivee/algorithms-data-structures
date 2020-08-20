package leetcode.medium.numbersubarrayoddsum_1524

class Solution {

    val mod = 1000000000 + 7
    /*
    Tag: Prefix Sum
    Intuition:
    Know that subarrays must be contiguous.
    Given [1,2,3] then [1,2] is a subarray but [1,3] is not

    Prefix sum gives sum of subarrays of [0], [0, 1] [0, ..., n]
    You can subtract the prefix sums from each other to get the sums of other subarrays
    e.g.
    Given [1,3,5]
    Prefix Sum = [1,4,9]
    9 - 4 = 5
        [1,3,5] - [1,3] = [5]
    9 - 1 = 8
        [1,3,5] - [1] = [3,5]
    4 - 1 = 3
        [1,3] - [1] = [3]

    This method gives you the answer with time complexity O(n + O(n^2)) == O(n^2)
    n == calculating prefix sum
    n^2 == calculating all subarrays

    Can go faster

    We can solve in linear time by tracking the amount of even sums and odd sums we have seen.

    Must understand the following first:
    odd + odd == even
    even + even == even
    odd + even == odd

    AND

    The count of even sums at the beginning is 1. This is due to the fact that the initial sum is 0.

    Given prefix sum [1,3,5]

    Let's walk through how the sub arrays are built out as we progress. For the sake of visibility
    we will include 0 as part of the subarrays.

    Initial:
        [0]
    Add 1:
        [0]
        [0, 1]
    Add 3:
        [0]
        [0, 1]
        [0, 3], [0, 1, 3]
    Add 5:
        [0]
        [0, 1]
        [0, 3], [0, 1, 3]
        [0, 5], [0, 3, 5], [0, 1, 3, 5]

   Formula
   Add n:
     [0]
     subarrayIncludingOnly(index = 0)
     ...
     subarrayIncludingOnly(index = n)

    We can see a few things
    - The subarray of n is an accumulation of previous subarrays.
    - Adding a number takes the n-1 subarray and adds itself to it + [0].
    - The amount of new subarrays with odd sum == the amount of previous subarrays with even sum
    - The amount of new subarrays with even sum == the amount of previous subarrays with odd sum

    For visibility we can use two lists to track the even sums and odd sums to see progression

    Initial:
        # even sums: 1 [0]
        # odd sums: 0
    Add 1:
        # even sums: 1,1 [0]
        # odd sums: 0,1 [0, 1]
    Add 3:
        # even sums: 1,1,2 [0], [0,1,3]
        # odd sums: 0,1,2 [0,1], [0,3]
    Add 5:
        # even sums: 1,1,2,3 [0], [0,1,3], [0,3,5]
        # odd sums: 0,1,2,4 [0,1], [0,3], [0,3,5], [0,1,3,5]

    We can further reduce this to just two variables for tracking evens and odds. We do not need lists
    since we only care about the latest calculation.

    Time Complexity: O(n)
    Space Complexity: O(1)
     */
    fun numOfSubarrays(arr: IntArray): Int {
        var countEvenSum = 1 // due to zero being first sum
        var countOddSum = 0
        var ans = countOddSum
        var sum = 0
        // O(n)
        for(i in arr) {
            sum += i
            ans = if(sum % 2 == 1) {
                countOddSum++
                (ans + countEvenSum) % mod
            } else {
                countEvenSum++
                (ans + countOddSum) % mod
            }
        }
        return ans
    }

}

fun main() {
    Solution().numOfSubarrays(intArrayOf(1,3,5)).also {
        println(it)
    }
}