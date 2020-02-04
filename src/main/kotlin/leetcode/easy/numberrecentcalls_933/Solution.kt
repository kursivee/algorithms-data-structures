package leetcode.easy.numberrecentcalls_933

import java.util.*

// https://leetcode.com/problems/number-of-recent-calls/submissions/
class RecentCounter {
    private var list = mutableListOf<Int>()
    private var queue = LinkedList<Int>()

    fun ping(t: Int): Int {
        list.add(t)
        val threshold = t - 3000
        val itr = list.iterator()
        while(itr.hasNext()) {
            if(itr.next() < threshold) itr.remove()
                else break
        }
        return list.size
    }

    fun pingQ(t: Int): Int =
        with(queue) {
            while(isNotEmpty()) {
                if(t - peek() > 3000) poll()
                else break
            }
            offer(t)
            size
        }

}

fun main() {
    with(RecentCounter()) {
//        ping(1178).also { println(it) }
//        ping(1483).also { println(it) }
//        ping(1563).also { println(it) }
//        ping(4054).also { println(it) }
//        ping(4152).also { println(it) }

//        ping(1).also { println(it) }
//        ping(100).also { println(it) }
//        ping(3001).also { println(it) }
//        ping(3002).also { println(it) }

        pingQ(642).also { println(it) }
        pingQ(1849).also { println(it) }
        pingQ(4921).also { println(it) }
        pingQ(5936).also { println(it) }
        pingQ(5957).also { println(it) }
    }
}