package leetcode.easy.postordertreetraversal_590

import leetcode.easy.preordertreetraversal_589.Node

// https://leetcode.com/problems/n-ary-tree-postorder-traversal/
// Java is the only available lang when actually solving
class Solution {
    private val list = mutableListOf<Int>()

    fun preorder(node: Node?): List<Int> {
        node?.let {
            node.children.forEach { child ->
                preorder(child)
            }
            list.add(it.value)
        }
        return list
    }
}

fun main() {
    val node = Node(1, listOf(
        Node(3, listOf(
            Node(5),
            Node(6)
        )),
        Node(2),
        Node(4)
    ))
    Solution().preorder(node).also { println(it.joinToString(", ")) }
}