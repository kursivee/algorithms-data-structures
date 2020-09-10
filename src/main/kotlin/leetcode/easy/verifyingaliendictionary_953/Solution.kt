package leetcode.easy.verifyingaliendictionary_953

class Solution {

    fun isAlienSorted(words: Array<String>, order: String): Boolean {
        val comparator = Comparator<String> { a, b ->
            var z = 0
            var bool = false
            for(i in a.indices) {
                if(i < b.length) {
                    if(a[i] != b[i]) {
                        z = if(order.indexOf(a[i]) < order.indexOf(b[i])) -1 else 1
                        bool = true
                        break
                    }
                }
            }
            if(bool) {
                z
            } else {
                if(a.length == b.length) 0 else {
                    if(a.length < b.length) -1 else 1
                }
            }
        }
        val sorted = words.sortedWith(comparator)
        for(i in sorted.indices) {
            if(sorted[i] != words[i]) return false
        }
        return true
    }
}