package leetcode.easy.specialposinbinmatrix_1582

class Solution {
    fun numSpecial(mat: Array<IntArray>): Int {
        var count = 0
        for(i in mat.indices) {
            for(j in mat[i].indices) {
                if(mat[i][j] == 1 && mat.isAlone(i, j)) count++
            }
        }
        return count
    }

    private fun Array<IntArray>.isAlone(i: Int, j: Int): Boolean {
        for(col in this[i].indices) {
            if(col != j && this[i][col] == 1) return false
        }
        for(row in this.indices) {
            if(row != i && this[row][j] == 1) return false
        }
        return true
    }

}