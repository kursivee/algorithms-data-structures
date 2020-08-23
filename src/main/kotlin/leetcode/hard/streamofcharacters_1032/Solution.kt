import java.util.*

class StreamChecker(private val words: Array<String>) {

    data class TrieNode(
        val c: Char = ' ',
        var isWord: Boolean = false,
        var children: MutableMap<Char, TrieNode> = mutableMapOf()
    )

    private val root = TrieNode()

    init {
        for(word in words) {
            var curr = root.children[word[0]] ?:
            TrieNode(word[0], word.length == 1).also { tn ->
                root.children[word[0]] = tn
            }
            for(i in 1 until word.length) {
                if(curr.children.contains(word[i])) {
                    curr = curr.children[word[i]]!!
                } else {
                    val node = TrieNode(word[i])
                    curr.children[word[i]] = node
                    curr = node
                }
                if(i == word.length - 1) curr.isWord = true
            }
        }
    }

    /*
    2 queue
    if queue is not empty
        for each n in queue
            if letter is not child of n do nothing
            if letter is in child
                add child to second queue
                if child is word set to true
        set queue to tmpQueue
    if queue is empty
        if letter is child of root
            add child to queue
            if child is word return true
    return false

    */
    private val q = ArrayDeque<TrieNode>()

    fun query(letter: Char): Boolean {
        var ans = false
        if(q.isNotEmpty()) {
            val size = q.size
            repeat(size) {
                val node = q.poll()
                if(node.children.contains(letter)) {
                    val child = node.children[letter]!!
                    q.add(child)
                    if(ans == false) ans = child.isWord
                }
            }
            if(root.children.contains(letter)) {
                val c = root.children[letter]!!
                q.add(c)
            }
        } else {
            if(root.children.contains(letter)) {
                val child = root.children[letter]!!
                q.add(child)
                return child.isWord
            }
        }
        return ans
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * var obj = StreamChecker(words)
 * var param_1 = obj.query(letter)
 */