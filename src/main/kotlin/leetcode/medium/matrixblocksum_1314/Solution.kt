package leetcode.medium.matrixblocksum_1314

class Solution {
    fun matrixBlockSum(mat: Array<IntArray>, K: Int): Array<IntArray> {
        val arr = Array(mat.size) { IntArray(mat[0].size) }
        for(i in arr.indices) {
            for(j in arr[0].indices) {
                arr[i][j] = mat.sum(i, j, K)
            }
        }
        return arr
    }

    fun Array<IntArray>.sum(i: Int, j: Int, k: Int): Int {
        var sum = 0

        for(r in i - k .. i + k) {
            if(r < 0 || r >= size) continue
            for(c in j - k .. j + k) {
                if(c < 0 || c >= this[0].size) continue
                sum += this[r][c]
            }
        }
        return sum
    }
}