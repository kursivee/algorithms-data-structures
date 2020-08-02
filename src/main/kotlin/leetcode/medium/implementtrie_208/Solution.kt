package leetcode.medium.implementtrie_208

class Solution {

    /** Initialize your data structure here. */
    data class TrieNode(
        var isWord: Boolean,
        val children: MutableMap<Char, TrieNode> = mutableMapOf()
    )

    val root = TrieNode(false, mutableMapOf())

    /** Inserts a word into the trie. */
    fun insert(word: String) {
        var curr = root
        for(i in word.indices) {
            val c = word[i]
            var child = curr.children[c]
            if(child == null) {
                if(i == word.length - 1) {
                    curr.children[c] = TrieNode(true)
                    return
                }
                child = TrieNode(false)
                curr.children[c] = child
                curr = child
            } else {
                if(i == word.length - 1) {
                    child.isWord = true
                    return
                }
                curr = child
            }
        }
    }

    /** Returns if the word is in the trie. */
    fun search(word: String): Boolean {
        var curr: TrieNode? = root
        for(c in word) {
            if(curr == null) return false
            curr = curr!!.children[c]
        }
        return curr?.isWord ?: false
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    fun startsWith(prefix: String): Boolean {
        var curr: TrieNode? = root
        for(c in prefix) {
            if(curr == null) return false
            curr = curr!!.children[c]
        }
        return curr != null
    }

}

/**
 * Your Trie object will be instantiated and called as such:
 * var obj = Trie()
 * obj.insert(word)
 * var param_2 = obj.search(word)
 * var param_3 = obj.startsWith(prefix)
 */

fun main() {
    val trie = Solution()
    trie.insert("apple")
    trie.search("apple").also { println(it) }
    trie.search("app").also { println(it) }
    trie.startsWith("app").also { println(it) }
    trie.insert("app")
    trie.search("app").also { println(it) }
}