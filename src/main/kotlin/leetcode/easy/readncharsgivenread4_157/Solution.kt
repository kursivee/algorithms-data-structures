package leetcode.easy.readncharsgivenread4_157

/**
 * The read4 API is defined in the parent class Reader4.
 * fun read4(buf4:CharArray): Int {}
 */

abstract class Reader4 {
    fun read4(buf4: CharArray): Int {
        return 0
    }

    abstract fun read(buf: CharArray, n: Int): Int
}

class Solution:Reader4() {
    /**
     * @param buf Destination buffer
     * @param n Number of characters to read
     * @return The number of actual characters read
     */
    override fun read(buf:CharArray, n:Int): Int {
        var count = 0
        while(true) {
            val buffer = CharArray(4)
            read4(buffer)
            for(i in 0 until 4) {
                if(count == n) return count
                if(buffer[i] != '\u0000') {
                    buf[count++] = buffer[i]
                } else return count
            }
        }
    }
}