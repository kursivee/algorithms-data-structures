package leetcode.easy.avglevelsinbintree_637

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
// https://leetcode.com/problems/average-of-levels-in-binary-tree/
class Solution {

    private val map = mutableMapOf<Int, MutableList<Int>>()

    fun averageOfLevels(root: TreeNode?): DoubleArray {
        if(root == null) return DoubleArray(0)
        map[0] = mutableListOf(root.`val`)
        traverse(root, 0)
        return map.map {
            it.value.fold(0.0) { agg, i ->
                agg + i
            } / it.value.size
        }.toDoubleArray()
    }

    private fun traverse(root: TreeNode, level: Int) {
        map[level] = (map[level] ?: mutableListOf()).also { it.add(root.`val`) }
        root.left?.let {
            traverse(it, level + 1)
        }
        root.right?.let {
            traverse(it, level + 1)
        }
    }
}

fun main() {
    Solution().averageOfLevels(
        TreeNode(3).apply {
            left = TreeNode(9)
            right = TreeNode(20).apply {
                left = TreeNode(15)
                right = TreeNode(7)
            }
        }
    ).also {
        println(it.joinToString(", "))
    }


    Solution().averageOfLevels(
        TreeNode(3).apply {
            left = TreeNode(1).apply {
                left = TreeNode(0)
                right = TreeNode(2)
            }
            right = TreeNode(5).apply {
                left = TreeNode(4)
                right = TreeNode(6)
            }
        }
    ).also {
        println(it.joinToString(", "))
    }
}

