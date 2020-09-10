package leetcode.easy.verifyingaliendictionary_953

class Solution {
    
    fun isAlienSorted(words: Array<String>, order: String): Boolean {
        loop@ for(i in 0 until words.size - 1) {
            val w1 = words[i]
            val w2 = words[i + 1]
            for(i in w1.indices) {
                if(i == w2.length) break
                val i1 = order.indexOf(w1[i])
                val i2 = order.indexOf(w2[i])
                if(i1 > i2) return false
                if(i1 < i2) continue@loop
            }
            if(w1.length > w2.length) return false
        }
        return true
    }

    fun isAlienSorted2(words: Array<String>, order: String): Boolean {
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