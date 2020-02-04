package leetcode.easy.preordertreetraversal_589

// https://leetcode.com/problems/n-ary-tree-preorder-traversal/
// Java is the only available lang when actually solving
class Solution {
    private val list = mutableListOf<Int>()

    fun preorder(node: Node?): List<Int> {
        node?.let {
            list.add(it.value)
            node.children.forEach { child ->
                preorder(child)
            }
        }
        return list
    }
}

class Node(val value: Int, val children: List<Node> = listOf())

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