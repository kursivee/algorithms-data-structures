package leetcode.easy.designhashset_705

class MyHashSet() {

    /** Initialize your data structure here. */
    private val arr = IntArray(1000000)

    fun add(key: Int) {
        arr[key] = 1
    }

    fun remove(key: Int) {
        arr[key] = 0
    }

    /** Returns true if this set contains the specified element */
    fun contains(key: Int): Boolean {
        return arr[key] == 1
    }

}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * var obj = MyHashSet()
 * obj.add(key)
 * obj.remove(key)
 * var param_3 = obj.contains(key)
 */

fun main() {
    val obj = MyHashSet()
    val key = 1
    obj.add(key)
    println(obj.contains(key))
    obj.remove(key)
    println(!obj.contains(key))
}