package leetcode.easy.numberrecentcalls_933

// https://leetcode.com/problems/number-of-recent-calls/submissions/
class RecentCounter {
    private var list = mutableListOf<Int>()

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

        ping(642).also { println(it) }
        ping(1849).also { println(it) }
        ping(4921).also { println(it) }
        ping(5936).also { println(it) }
        ping(5957).also { println(it) }
    }
}