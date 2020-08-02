package leetcode.medium.bintreerightside_199

import leetcode.easy.mergetwobinarytrees_617.TreeNode
import java.util.*

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

    fun rightSideView(root: TreeNode?): List<Int> {
        if(root == null) return emptyList()
        val ans = mutableListOf<Int>()
        val queue = ArrayDeque<TreeNode>()
        queue.add(root)
        while(!queue.isEmpty()) {
            val count = queue.size
            for(i in 0 until count) {
                val node = queue.pop()
                if(i == count - 1) ans.add(node.`val`)
                node.left?.let { queue.add(it) }
                node.right?.let { queue.add(it) }
            }
        }
        return ans
    }
}

fun main() {
    Solution().rightSideView(TreeNode(1).apply {
        left = TreeNode(2)
        right = TreeNode(3)
    }).also {
        println(it)
    }
}