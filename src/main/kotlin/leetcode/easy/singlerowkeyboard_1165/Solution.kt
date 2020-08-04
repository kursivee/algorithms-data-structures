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
}