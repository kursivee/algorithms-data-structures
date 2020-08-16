package leetcode.medium.scoreafterflippingmatrix_861

class Solution {
    /*
    Tag: Greedy
    Intuition:
    Greedy approach dictates that we should bias 1 density to the left since
    it will yield the highest decimal number.
    We can easily change the first index to 1 by either flipping the row or the 0 column
    e.g.
    0 -> 1
    1 -> no flip
    1 -> no flip
    Flip row[0]
    0 -> flip
    0 -> flip
    0 -> flip
    Flip all

    From then on we can loop through the columns in the matrix. If there are more 0s than 1s in the column
    the we should flip the row. Otherwise remain the same
    e.g.
    0
    1
    1
    More 1s than 0s so no flip
    1 -> 0
    0 -> 1
    0 -> 1
    More 0s than 1s so flip
    */
    fun matrixScore(A: Array<IntArray>): Int {
        for(i in A.indices) {
            for(j in A[i].indices) {
                if(j == 0) {
                    if(A[i][j] == 0) {
                        A[i].flip()
                    }
                } else if(A.moreZeros(j)) {
                    A.flip(j)
                }
            }
        }
        var sum = 0
        A.forEach { arr ->
            sum += arr.toDec()
        }
        return sum
    }

    private fun IntArray.toDec(): Int {
        var sum = 0.0
        for(i in this.size - 1 downTo 0) {
            sum += this[i] * Math.pow(2.0, (this.size - 1) - i.toDouble())
        }
        return sum.toInt()
    }

    private fun Array<IntArray>.moreZeros(j: Int): Boolean {
        var zeroCount = 0
        var oneCount = 0
        for(i in indices) {
            if(this[i][j] == 0) zeroCount++
            else oneCount++
        }
        return zeroCount > oneCount
    }

    private fun Array<IntArray>.flip(j: Int) {
        for(i in indices) {
            this[i][j] = if(this[i][j] == 0) {
                1
            } else 0
        }
    }

    private fun IntArray.flip() {
        for(i in indices) {
            this[i] = if(this[i] == 0) {
                1
            } else 0
        }
    }
}