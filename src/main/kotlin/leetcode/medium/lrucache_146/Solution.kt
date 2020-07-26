package leetcode.medium.lrucache_146

import java.util.*

class LRUCache(private val capacity: Int) {

    val map = mutableMapOf<Int, Int>()
    val keyQueue = LinkedList<Int>()

    fun get(key: Int): Int {
        return map[key]?.also {
            keyQueue.remove(key)
            keyQueue.addFirst(key)
        } ?: -1
    }

    fun put(key: Int, value: Int) {
        map[key] = value
        keyQueue.remove(key)
        keyQueue.addFirst(key)
        if(map.size > capacity) {
            val lastKey = keyQueue.removeLast()
            map.remove(lastKey)
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * var obj = LRUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */