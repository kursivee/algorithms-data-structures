package leetcode.easy.singlerowkeyboard_1165

class Solution {
    /*
    curr index 0
    travel to new index
    diff travel from curr
        abs
    set index to traveled index
    loop

    */
    fun calculateTime(keyboard: String, word: String): Int {
        var curr = 0
        var count = 0
        word.forEach { c ->
            val index = keyboard.indexOf(c)
            count += Math.abs(curr - index)
            curr = index
        }
        return count
    }

    // With hash map for faster access
    fun calculateTime2(keyboard: String, word: String): Int {
        // char, index
        val map = mutableMapOf<Char, Int>()
        var curr = 0
        var count = 0

        // O(1) lookup
        for(i in 0 until keyboard.length) {
            map.put(keyboard[i], i)
        }

        word.forEach { c ->
            val newIndex = map[c]!!
            count += Math.abs(curr - newIndex)
            curr = newIndex
        }

        return count
    }
}