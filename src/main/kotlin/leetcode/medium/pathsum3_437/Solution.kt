package leetcode.medium.pathsum3_437

import leetcode.easy.mergetwobinarytrees_617.TreeNode

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    /*
    Tag: Prefix sum

    Intuition:
    traverse the tree and get the sum
    need to also include sum of subtrees
    we want to look at root, left, right (preorder) since we are trying to aggregate the
    sum before continuing.

    we want to use a map to track the previous sums AND their frequency

    know that at any index, if there exists a previous sum where it == currSum - k.
    then there exists some subarray(s) that total k between index of previous sum and current sum
    the count of subarrays == the frequency of previous sum

    Why does freqMap work?
    first understand that
    (sum - k) + k = sum
    so if the map contains some previous sum that == (sum - k) then you can assume there exists
    some subarray that will total k
    */

    private val map = mutableMapOf<Int, Int>()
    private var count = 0

    fun pathSum(root: TreeNode?, sum: Int): Int {
        preorder(root, 0, sum)
        return count
    }

    private fun preorder(node: TreeNode?, sum: Int, target: Int) {
        if(node == null) return
        val currSum = node.`val` + sum
        if(currSum == target) count++
        if(map.contains(currSum - target)) {
            count += map[currSum - target]!!
        }
        map[currSum] = map.getOrDefault(currSum, 0) + 1
        preorder(node.left, currSum, target)
        preorder(node.right, currSum, target)
        // Remove the latest sum since we're now back tracking.
        map[currSum] = map[currSum]!! - 1
    }
}