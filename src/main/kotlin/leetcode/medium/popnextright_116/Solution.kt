package leetcode.medium.popnextright_116


class Node(var `val`: Int) {
    var left: Node? = null
    var right: Node? = null
    var next: Node? = null
}

class Solution {
    var tracked: Node? = null
    fun connect(root: Node?): Node? {
        val depth = depth(root)
        for(i in 1 .. depth) {
            tracked = null
            search(root, i)
        }
        return root
    }

    fun depth(root: Node?): Int {
        if(root == null) return 0
        var depth = 1
        depth += depth(root.left)
        return depth
    }

    fun search(node: Node?, depth: Int) {
        if(node == null) return
        if(depth == 1) {
            if(tracked == null) {
                tracked = node
            } else {
                tracked!!.next = node
                tracked = node
            }
        } else if(depth > 1) {
            search(node.left, depth - 1)
            search(node.right, depth - 1)
        }
    }
}

fun main() {
    Solution().connect(Node(1).apply {
        left = Node(2)
        right = Node(3)
    })
}