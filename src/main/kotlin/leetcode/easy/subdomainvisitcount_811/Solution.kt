package leetcode.easy.subdomainvisitcount_811

// https://leetcode.com/problems/subdomain-visit-count/submissions/
class Solution {
    data class Cpdomain(val count: Int, val domain: String) {
        fun subdomains(): List<String> {
            val list = mutableListOf<String>()
            var subdomain = domain
            while(subdomain.contains(".")) {
                list.add(subdomain)
                subdomain = subdomain.substringAfter(".")
            }
            list.add(subdomain)
            return list
        }
    }

    private val map = mutableMapOf<String, Int>()

    fun subdomainVisits(cpdomains: Array<String>): List<String> {
        cpdomains.forEach { s ->
            with(s.toCpdomain()) {
                subdomains().forEach {
                    map[it] = (map[it] ?: 0) + count
                }
            }
        }
        return map.map {
            "${it.value} ${it.key}"
        }
    }

    private fun String.toCpdomain(): Cpdomain =
        with(split(" ")) {
            Cpdomain(get(0).toInt(), get(1))
        }
}

fun main() {
    Solution().subdomainVisits(arrayOf(
        "9001 discuss.leetcode.com"
    )).also{ println(it.joinToString(", ")) }

    Solution().subdomainVisits(arrayOf(
        "900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"
    )).also{ println(it.joinToString(", ")) }


}