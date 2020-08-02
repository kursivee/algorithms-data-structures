package leetcode.medium.binsearchtreeitr_173

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
class BSTIterator(root: TreeNode?) {

    private val list = mutableListOf<Int>()

    init {
        dfs(root)
        list.sort()
    }


    private fun dfs(root: TreeNode?) {
        if(root == null) return
        list.add(root.`val`)
        dfs(root.left)
        dfs(root.right)
    }

    /** @return the next smallest number */
    fun next(): Int {
        return list.removeAt(0)
    }

    /** @return whether we have a next smallest number */
    fun hasNext(): Boolean {
        return list.size != 0
    }

}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * var obj = BSTIterator(root)
 * var param_1 = obj.next()
 * var param_2 = obj.hasNext()
 */