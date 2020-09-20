package leetcode.easy.matrixdiagonalsum_1572

class Solution {
    fun diagonalSum(mat: Array<IntArray>): Int {
        var i = 0
        var j = 0
        var a = 0
        var b = mat[0].size - 1
        var sum = 0
        while(true) {
            if(i == mat.size || j == mat[i].size) break
            if(a == mat.size || b < 0) break
            sum += mat[i][j]
            mat[i][j] = 0
            sum += mat[a][b]
            mat[a][b] = 0
            i++
            j++
            a++
            b--
        }
        return sum
    }
}