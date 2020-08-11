package leetcode.medium.partitionlabels_763

class Solution {
    /*
    TAG: Sliding Window
    Intuition:
    The end boundary of a partition is the greatest last index
    of the elements within the partition.
    e.g.
    [a, b, c, a] The greatest last index of the partition is 3

    What we can do is iterate through the array and find the greatest index of the current element we are
    looking at. We constantly adjust that end boundary as we traverse the array. If the current index
    reaches the greatest index then we know that this is the end of the partition and we add the size
    to the list.
    e.g
    [a,b,c,a,d]
    at i == 0, greatest index is 3
    b,c do not shift the greatest index so no action needed
    at i == 3, i == greatest index so we now know we are done building this partition
    we can store the size of the partition and continue iterating
    at d i == 4 and greatest index is itself (4) so we again know that we are at the end of the partition

    e.g.
    [a,b,a,b]
    at i == 0, greatest index is 2
    at i == 1, greatest index shifts to 3 since b can be found outside the current boundary

    Time Complexity: O(n)
    Space Complexity O(1)
    */
    fun partitionLabels(S: String): List<Int> {
        val counts = mutableListOf<Int>()
        var i = 0
        var j = 0
        var count = 0
        while(i < S.length) {
            val lastIndex = S.lastIndexOf(S[i])
            if(lastIndex > j) {
                j = lastIndex
            }
            count++
            if(i == j) {
                counts.add(count)
                count = 0
            }
            i++
        }
        return counts
    }
}