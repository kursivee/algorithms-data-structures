package leetcode.medium.robotboundedincircle_1041

class Solution {
    fun isRobotBounded(instructions: String): Boolean {
        var x = 0
        var y = 0
        val directions = listOf(
            0 to 1, // North
            1 to 0, // South
            0 to -1, // East
            -1 to 0 // West
        )
        var direction = 0
        for(c in instructions) {
            when(c) {
                'L' -> direction = (direction + 3) % 4
                'R' -> direction = (direction + 1) % 4
                else -> {
                    x += directions[direction].first
                    y += directions[direction].second
                }
            }
        }
        return (x == 0 && y == 0) || direction != 0
    }
}