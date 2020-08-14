package leetcode.easy.longestpalindrome_409

class Solution {
    fun longestPalindrome(s: String): Int {
        val freq = mutableMapOf<Char, Int>()
        s.forEach { char ->
            val count = freq.getOrDefault(char, 0)
            freq[char] = count + 1
        }
        var oddCount = -1
        var sum = 0
        freq.values.forEach { value ->
            sum += value
            if(value % 2 != 0) {
                oddCount++
            }
        }
        oddCount = if(oddCount == -1) 0 else oddCount
        return sum - oddCount
    }

    /**
     * Tag: Palindrome
     * Intuition:
     * We know that a char is a valid palindrome if there exists
     * an even amount of chars. If the amount is odd, then it can potentially be
     * a palindrome IFF it is the only char with an odd amount.
     *
     * We can get the frequencies of the characters in the string.
     * We can sum all the frequencies to get the longest size of palindrome.
     * For evens we can just add to the sum
     * We can use the equation n / 2 * 2 to handle summation. i.e. sum += n / 2 * 2 where n is a frequency
     * Because of Integer division, this is functionally equivalent to
     * subtracting one from an odd number. This will do nothing for an even number.
     *
     * For the final sum, we have to check if the sum is < length of the String.
     * If the sum is < s.length then we can assume that there exists multiple characters with
     * odd amount. Since n / 2 * 2 converts all odd numbers to even, we need to add 1 to the
     * answer to account for the case where there can exist ONLY ONE character with odd count.
     *
     * If the sum is == s.length this means that all character frequencies were even.
     *
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    fun longestPalindromeFaster(s: String): Int {
        // Range of A to z is 10 to 122 so need to account for all those values
        val arr = IntArray(123)
        for(c in s.toCharArray()) {
            arr[c.toInt()]++
        }
        var ans = 0
        for(n in arr) {
            ans += n / 2 * 2
        }
        return if(ans < s.length) ans + 1 else ans
    }
}