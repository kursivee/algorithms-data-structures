package leetcode.easy.sumofroottoleafbin_1022

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
// https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/submissions/
class Solution {
    private val ints: MutableList<List<Int>> = mutableListOf()

    fun sumRootToLeaf(root: TreeNode?): Int {
        if(root == null) return 0
        traverse(root, mutableListOf())
        return ints.fold(0) { acc, list ->
            acc + list.binarySum()
        }
    }

    private fun traverse(root: TreeNode, list: MutableList<Int>) {
        list.add(root.`val`)
        if(root.left == null && root.right == null) {
            ints.add(list)
        }

        root.left?.let {
            val copy = mutableListOf<Int>()
            copy.addAll(list)
            traverse(it, copy)
        }
        root.right?.let {
            val copy = mutableListOf<Int>()
            copy.addAll(list)
            traverse(it, copy)
        }
    }

    private fun List<Int>.binarySum() : Int {
        var n = (size - 1).toDouble()
        return fold(0) { acc, i ->
            var x = 0.0
            if(i == 1) {
                x = Math.pow(2.0, n)
            }
            n--
            acc + x.toInt()
        }
    }
}

fun main() {
    Solution().sumRootToLeaf(
        TreeNode(1).apply {
            left = TreeNode(0).apply {
                left = TreeNode(0)
                right = TreeNode(1)
            }
            right = TreeNode(1).apply {
                left = TreeNode(0)
                right = TreeNode(1)
            }
        }
    ).also {
        println(it)
    }
}