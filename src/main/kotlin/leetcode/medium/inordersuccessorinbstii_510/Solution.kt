package leetcode.medium.inordersuccessorinbstii_510

 class Node(var `val`: Int) {
    var left: Node? = null
    var right: Node? = null
    var parent: Node? = null
}

class Solution {

    private val list = mutableListOf<Node>()

    fun inorderSuccessor(node: Node?): Node? {
        dfs(node)
        list.sortBy { it.`val` }
        val i = list.indexOf(node)
        if(i + 1 == list.size) return null
        return list[i + 1]
    }

    private fun dfs(node: Node?, fromLeft: Boolean) {
        if(node == null || list.contains(node)) return
        list.add(node)
        if(fromLeft) {
            dfs(node.right)
        } else {
            dfs(node.left)
        }
        if(node.parent != null) {
            dfs(node.parent, node.`val` < node.parent!!.`val`)
        }
    }

    private fun dfs(node: Node?) {
        if(node == null) return
        // Down
        list.add(node)
        dfs(node.left)
        dfs(node.right)
        // parent
        if(node.parent != null) {
            dfs(node.parent, node.`val` < node.parent!!.`val`)
        }
    }
}