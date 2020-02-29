package leetcode.easy.designhashmap_706

class MyHashMap() {

    /** Initialize your data structure here. */
    class Item(val key: Int, val value: Int) {
        override fun equals(other: Any?): Boolean {
            if(other is Item) {
                return this.key == other.key
            }
            return false
        }

        override fun hashCode(): Int {
            return key.hashCode()
        }
    }

    private val set: MutableSet<Item> = mutableSetOf()

    /** value will always be non-negative. */
    fun put(key: Int, value: Int) {
        set.remove(Item(key, -1))
        set.add(Item(key, value))
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    fun get(key: Int): Int {
        return set.find {
            it.key == key
        }?.value ?: -1
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    fun remove(key: Int) {
        set.remove(Item(key, -1))
    }

}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * var obj = MyHashMap()
 * obj.put(key,value)
 * var param_2 = obj.get(key)
 * obj.remove(key)
 */

fun main() {
    val key = 0
    val value = 1
    val obj = MyHashMap()
    obj.put(key, value)
    obj.put(key, 2)
    val param = obj.get(key)
    println(param == value)
    obj.remove(key)
    print(obj.get(key) == -1)
}