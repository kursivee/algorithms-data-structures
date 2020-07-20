package leetcode.medium.encodedecodetinyurl_535

class Codec() {
    val charArr = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray()
    val map: MutableMap<Int, String> = mutableMapOf()
    // Encodes a URL to a shortened URL.
    fun encode(longUrl: String): String {
        val id = map.size
        map[id] = longUrl
        return base62encode(id)
    }

    fun base62encode(id: Int): String {
        if(id == 0) return "a"
        var n = id
        var s = ""
        while(n > 0) {
            s += "${charArr[n % 62]}"
            n /= 62
        }
        return s
    }

    // Decodes a shortened URL to its original URL.
    fun decode(shortUrl: String): String {
        val id = getId(shortUrl)
        return map[id]!!
    }

    fun getId(shortUrl: String): Int {
        var id = 0
        for(i in shortUrl.indices) {
            val char = shortUrl[i]
            val charInt = char.toInt()
            if(char in 'a'..'z') {
                id = id * 62 + charInt - 'a'.toInt()
            } else if(char in 'A'..'Z') {
                id = id * 62 + charInt - 'A'.toInt() + 26
            } else if(char in '0'..'9') {
                id = id * 62 + charInt - '0'.toInt() + 52
            }
        }
        return id
    }
}

fun main() {
    val codec = Codec()
    val url = "https://leetcode.com/problems/design-tinyurl"
    val tinyUrl = codec.encode(url).also { println(it) }
    val decodedUrl = codec.decode(tinyUrl).also { println(it) }
}