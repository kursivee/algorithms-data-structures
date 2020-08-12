package leetcode.easy.squaresofsortedarray_977

class Solution {
    /*
    TAG: Two Pointer, Sliding Window
    Intuition:
    We know that squaring a negative number will result in a positive so we can essentially
    ignore the negatives. We want to compare the ends of the array since there might be a case
    where the first index of the array is greater than the last.
    e.g.
    [-10, 1] Since we ignore the -, 10 > 1

    We can use the two pointer technique to look at the ends of the array at the same time.
    e.g.
    [-10, 0, 1]
      ^      ^
    is 10 > 1? yes so we square 10 and add it to the array
    move the left pointer to 0

    [-10, 0, 1]
          ^  ^

    is 0 > 1? no so we square 1 and add it to the array

    [-10, 0, 1]
          ^
    The pointers now point to the same index so we can square 0 and add it to the array

    In the case of no negative numbers
    e.g.
    [1,2,3]
    
    The left pointer would never move and only the right pointer will shift.

    Time Complexity: O(n)
    Space Complexity: O(1)
    */
    fun sortedSquares(A: IntArray): IntArray {
        var l = 0
        var r = A.size - 1
        var i = A.size - 1
        val arr = IntArray(A.size)
        while(l <= r) {
            if(Math.abs(A[l]) > Math.abs(A[r])) {
                arr[i] = A[l] * A[l]
                l++
            } else {
                arr[i] = A[r] * A[r]
                r--
            }
            i--
        }
        return arr
    }
}