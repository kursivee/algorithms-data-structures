package leetcode.medium.addandsearchword_211

class Solution {

    /** Initialize your data structure here. */
    /*
    list of words
    search will check if the char is ! . and check equality
    if . equality is true
    */
    data class TrieNode(
        var isWord: Boolean,
        val children: MutableMap<Char, TrieNode>
    )

    private val root = TrieNode(false, mutableMapOf())

    /** Adds a word into the data structure. */
    fun addWord(word: String) {
        var curr = root
        word.forEachIndexed { i, c ->
            if(curr.children.contains(c)) {
                curr = curr.children[c]!!
            } else {
                val node = if(i == word.length - 1) {
                    TrieNode(true, mutableMapOf())
                } else {
                    TrieNode(false, mutableMapOf())
                }
                curr.children[c] = node
                curr = node
            }
        }
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    fun search(word: String): Boolean {
        return dfs(root, word, 0)
    }

    private fun dfs(node: TrieNode?, s: String, i: Int): Boolean {
        if(node == null) return false
        if(i == s.length) return node.isWord
        var found = false
        if(node.children.contains(s[i])) {
            found = dfs(node.children[s[i]], s, i + 1)
            if(found) return true
        }
        if(s[i] == '.') {
            node.children.values.forEach { child ->
                found = dfs(child, s, i + 1)
                if(found) return true
            }
        }
        return false
    }
}

class RegexSolution {
    /** Initialize your data structure here. */
    /*
    list of words
    search will check if the char is ! . and check equality
    if . equality is true
    */
    private val list = mutableListOf<String>()
    private val cache = mutableMapOf<String, Boolean>()

    /** Adds a word into the data structure. */
    fun addWord(word: String) {
        cache.clear()
        list.add(word)
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    fun search(regex: String): Boolean {
        if(cache.contains(regex)) return cache[regex]!!
        val r = regex.buildRegex()
        for(w in list) {
            if(r.matchEntire(w) != null) {
                cache[regex] = true
                return true
            }
        }
        cache[regex] = false
        return false
    }

    private fun String.buildRegex(): Regex {
        var regex = ""
        forEach { c ->
            regex += if(c == '.') {
                "."
            } else {
                "($c)"
            }
        }
        return regex.toRegex()
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * var obj = WordDictionary()
 * obj.addWord(word)
 * var param_2 = obj.search(word)
 */