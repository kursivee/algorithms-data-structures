package leetcode.medium.taskscheduler_621

class Solution {
    /*
    take the greedy approach
    should take the most frequent first since that guarantees
    we're not idling when we don't need to

    calculate the total amount of idle 'chunks'
    e.g.
    a,a cd = 2
    a,[idle,idle],a idleChunks = 1

    we can use frequency(greatest) - 1
    we - 1 because the last task will always be placed and will never have an idle chunk

    next we loop through rest of the frequencies
    consider freq(next)
    we need to subtract freq(next) IF the frequency < total amount of idle chunks
    this is because we're only considering the cases where placing the item will
    replace an 'idle' slot

    now we return the total number of tasks + number of idle slots
    we also need to consider if idle slots < 0 then we need to set it to 0
    < 0 idle slots indicates there is no need for idle slots
    */

    fun leastInterval(tasks: CharArray, n: Int): Int {
        val freq = IntArray(26)
        tasks.forEach { char ->
            freq[char - 'A']++
        }
        freq.sort()
        val idleChunkCount = freq[25] - 1
        var idleCount = idleChunkCount * n
        for(i in 24 downTo 0) {
            idleCount -= Math.min(idleChunkCount, freq[i])
        }
        idleCount = Math.max(0, idleCount)
        return tasks.size + idleCount
    }
}

fun main() {
    Solution().leastInterval(charArrayOf('A','A','A','B','B','B'), 2).also {
        println(it)
    }
}