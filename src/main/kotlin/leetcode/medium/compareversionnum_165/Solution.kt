package leetcode.medium.compareversionnum_165

class Solution {
    fun compareVersion(version1: String, version2: String): Int {
        val v1 = version1.split(".")
        val v2 = version2.split(".")
        val length = maxOf(v1.size, v2.size)
        for(i in 0 until length) {
            val ver1 = if(i < v1.size) Integer.parseInt(v1[i]) else 0
            val ver2 = if(i < v2.size) Integer.parseInt(v2[i]) else 0
            if(ver1 > ver2) return 1
            if(ver1 < ver2) return -1
        }
        return 0
    }
}