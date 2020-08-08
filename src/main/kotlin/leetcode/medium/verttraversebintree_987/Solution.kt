import leetcode.easy.mergetwobinarytrees_617.TreeNode
import java.util.*
import kotlin.Comparator

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
    left, root, right
    */

    data class Node(
        val node: TreeNode,
        val x: Int,
        val level: Int
    )

    val comparator = Comparator<Node> { a, b ->
        if(a.level == b.level) {
            a.node.`val`.compareTo(b.node.`val`)
        } else {
            a.x.compareTo(b.x)
        }
    }

    val map = mutableMapOf<Int, MutableList<Node>>()
    fun verticalTraversal(root: TreeNode?): List<List<Int>> {
        if(root == null) return emptyList()
        val stack = ArrayDeque<Node>()
        stack.add(Node(root, 0, 0))
        var level = 0
        while(!stack.isEmpty()) {
            var count = stack.size
            for(i in 0 until count) {
                val node = stack.poll()
                val tree = node.node
                var x = node.x
                val list = map.getOrDefault(x, mutableListOf())
                map[x] = list


                list.add(node)
                tree.left?.let {
                    stack.add(Node(it, x - 1, level))
                }
                tree.right?.let {
                    stack.add(Node(it, x + 1, level))
                }
            }
            level++
        }
        val list = mutableListOf<List<Int>>()
        map.toSortedMap().forEach { entry ->
            entry.value.sortedWith(comparator).map { node ->
                node.node.`val`
            }.also { l ->
                list.add(l)
            }

        }
        return list
    }
}