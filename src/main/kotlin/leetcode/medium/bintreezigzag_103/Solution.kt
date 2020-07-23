package leetcode.medium.bintreezigzag_103

import leetcode.easy.mergetwobinarytrees_617.TreeNode

class Solution {
    val list: MutableList<MutableList<Int>> = mutableListOf()
    val map: MutableMap<Int, MutableList<Int>> = mutableMapOf()

    fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
        traverse(root, 0)
        map.entries.sortedBy { it.key }.forEach {
            list.add(it.value)
        }
        return list
    }

    fun traverse(root: TreeNode?, depth: Int) {
        if(root == null) return
        val rightToLeft = depth % 2 == 0
        val elements = map.getOrDefault(depth, mutableListOf() )
        if(rightToLeft) {
            elements.add(0, root.`val`)

            traverse(root.right, depth + 1)
            traverse(root.left, depth + 1)
        } else {
            elements.add(root.`val`)

            traverse(root.right, depth + 1)
            traverse(root.left, depth + 1)
        }
        map[depth] = elements
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