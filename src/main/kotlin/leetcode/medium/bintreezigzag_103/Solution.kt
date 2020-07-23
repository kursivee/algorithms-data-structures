package leetcode.medium.bintreezigzag_103

import leetcode.easy.mergetwobinarytrees_617.TreeNode
import java.util.*

class Solution {
    val queue = LinkedList<TreeNode?>()

    // [1,2,3,4,null,null,5]
    fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
        if(root == null) return emptyList()
        val list = mutableListOf<List<Int>>()
        var levelList = mutableListOf<Int>()
        queue.add(root)
        queue.add(null)
        var depth = 0
        while(queue.isNotEmpty()) {
            val node = queue.poll()
            if(node == null) {
                depth++
                list.add(levelList)
                levelList = mutableListOf()
                if(queue.isEmpty()) break
                queue.add(null)
            } else {
                val leftToRight = depth % 2 == 1

                node.left?.let { queue.add(it) }
                node.right?.let { queue.add(it) }
                if(leftToRight) {
                    levelList.add(0, node.`val`)
                } else {
                    levelList.add(node.`val`)
                }
            }

        }
        return list
    }
}

/**
    1
   / \
  2  3
 /    \
4      5

 */

fun main() {
    Solution().zigzagLevelOrder(TreeNode(3).apply {
        left = TreeNode(9)
        right = TreeNode(20).apply {
            left = TreeNode(15)
            right = TreeNode(7)
        }
    }).also {
        it.forEach {  list ->
            println(list.joinToString(", "))
        }
    }

    Solution().zigzagLevelOrder(TreeNode(1).apply {
        left = TreeNode(2).apply {
            left = TreeNode(4)
        }
        right = TreeNode(3).apply {
            right = TreeNode(5)
        }
    }).also {
        it.forEach {  list ->
            println(list.joinToString(", "))
        }
    }

    Solution().zigzagLevelOrder(TreeNode(1).apply {
        left = TreeNode(2).apply {
            left = TreeNode(4)
            right = TreeNode(5)
        }
        right = TreeNode(3)
    }).also {
        it.forEach {  list ->
            println(list.joinToString(", "))
        }
    }

}