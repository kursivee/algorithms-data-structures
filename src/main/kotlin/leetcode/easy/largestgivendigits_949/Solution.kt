package leetcode.easy.largestgivendigits_949

class Solution {
    /*
    1st <= 2
    2nd <= 4
    3rd <= 5
    4th <= 9
    */
    fun largestTimeFromDigits(A: IntArray): String {
        for(i in 2 downTo 0) {
            val list = A.toMutableList()
            if(!list.contains(i)) continue
            list.remove(i)
            if(i == 2) {
                for(j in 3 downTo 0) {
                    val l2 = list.toMutableList()
                    if(list.contains(j)) {
                        l2.remove(j)
                        for(k in 5 downTo 0) {
                            val l3 = l2.toMutableList()
                            if(l3.contains(k)) {
                                l3.remove(k)
                                return "$i$j:$k${l3[0]}"
                            }
                        }
                    }
                }
            } else {
                for(j in 9 downTo 0) {
                    val l2 = list.toMutableList()
                    if(list.contains(j)) {
                        l2.remove(j)
                        for(k in 5 downTo 0) {
                            val l3 = l2.toMutableList()
                            if(l3.contains(k)) {
                                l3.remove(k)
                                return "$i$j:$k${l3[0]}"
                            }
                        }
                    }
                }
            }
        }
        return ""
    }
}