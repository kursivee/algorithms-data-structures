package leetcode.easy.matchesintournamnet_1688

class Solution {
    fun numberOfMatches(n: Int): Int {
        // can also just return n-1 <>_<>
        var teams = n
        var matches = 0
        while(teams != 1) {
            if(teams % 2 == 0) {
                teams /= 2
                matches += teams
            } else {
                val advanced = (teams - 1) / 2
                matches += advanced
                teams = advanced + 1
            }
        }
        return matches
    }
}