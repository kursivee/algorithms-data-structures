package leetcode.easy.mergetwobinarytrees_617

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
    fun mergeTrees(t1: TreeNode?, t2: TreeNode?): TreeNode? {
        if(t1 == null && t2 == null) {
            return null
        }
        return make(t1, t2, TreeNode(0))
    }

    private fun make(t1: TreeNode?, t2: TreeNode?, node: TreeNode): TreeNode? {
        node.`val` = (t1?.`val` ?: 0) + (t2?.`val` ?: 0)
        if(t1?.left != null || t2?.left != null) {
            node.left = TreeNode(0).also {
                make(t1?.left, t2?.left, it)
            }
        }
        if(t1?.right != null || t2?.right != null) {
            node.right = TreeNode(0).also {
                make(t1?.right, t2?.right, it)
            }
        }
        return node
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null

    fun log(from: String = "root") {
        println("$from: ${`val`}")
        left?.let {
            log(it, "left")
        }
        right?.let {
            log(it, "right")
        }
    }
}

fun log(node: TreeNode, from: String = "root") {
    println("$from: ${node.`val`}")
    node.left?.let {
        log(it, "left")
    }
    node.right?.let {
        log(it, "right")
    }
}

fun main() {
    val t1 = TreeNode(1).apply {
        left = TreeNode(2)
    }
    val t2 = TreeNode(3).apply {
        right = TreeNode(3)
        left = TreeNode(5).apply {
            left = TreeNode(6)
        }
    }
    Solution().mergeTrees(t1, t2).also { log(it!!) }
}