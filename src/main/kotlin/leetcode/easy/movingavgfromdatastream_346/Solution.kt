package leetcode.easy.movingavgfromdatastream_346

import java.util.*

class MovingAverage(private val size: Int) {

    /** Initialize your data structure here. */
    private val queue = ArrayDeque<Int>(size)
    private var sum = 0

    fun next(`val`: Int): Double {
        val s = queue.size
        sum += `val`
        if(s == size) {
            sum -= queue.poll()
        }
        queue.offer(`val`)
        return sum.toDouble() / queue.size
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * var obj = MovingAverage(size)
 * var param_1 = obj.next(`val`)
 */