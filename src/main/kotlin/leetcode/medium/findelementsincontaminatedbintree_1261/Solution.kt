package leetcode.medium.findelementsincontaminatedbintree_1261

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
class FindElements(private val root: TreeNode?) {

    private val list = mutableListOf<Int>()

    init {
        preorder(root, 0)
    }

    private fun preorder(node: TreeNode?, newVal: Int) {
        if(node == null) return
        node.`val` = newVal
        list.add(newVal)
        preorder(node.left, 2 * newVal + 1)
        preorder(node.right, 2 * newVal + 2)
    }

    fun find(target: Int): Boolean {
        return list.contains(target)
    }

}

/**
 * Your FindElements object will be instantiated and called as such:
 * var obj = FindElements(root)
 * var param_1 = obj.find(target)
 */