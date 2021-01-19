package adventofcode.y2020

import adventofcode.util.FileUtil

class Day7 {
    data class Bag(
        val key: String,
        val bags: MutableMap<Bag, Int> = mutableMapOf()
    )

    class BagFactory(private val rules: Map<String, Map<String, Int>>) {
        val holder = mutableMapOf<String, Bag>()

        init {
            rules.keys.forEach { key ->
                getOrCreateBag(key)
            }
        }

        private fun getOrCreateBag(key: String): Bag {
            if(holder.contains(key)) {
                return holder[key]!!
            }
            val bag = Bag(key).apply {
                rules[key]?.forEach { (key, count) ->
                    bags[getOrCreateBag(key)] = count
                }
            }
            holder[key] = bag
            return bag
        }
    }

    object RuleFactory {
        fun getRules(list: List<String>): Map<String, Map<String, Int>> {
            val map = mutableMapOf<String, Map<String, Int>>()
            for(s in list) {
                if(s.contains("no")) continue
                val split = s.split("contain")
                split[1].trim().paresContains().also { m ->
                    map[split[0].replace("bags", "bag").trim()] = m
                }
            }
            return map
        }

        private fun String.paresContains(): Map<String, Int> {
            val list = split(",")
            val map = mutableMapOf<String, Int>()
            for(s in list) {
                map.put(s.parseBag())
            }
            return map
        }

        /**
         * Cheated a bit. This only works if all input has bag count < 9 :D breaks on double digits
         * Also replaced all instances of "bags" to "bag" to ensure the keys are the same
         */
        private fun String.parseBag(): Pair<String, Int> {
            val s = this.trim()
            val key = s.substring(2 until s.length)
                .replace(".", "")
                .replace("bags", "bag")
                .trim()
            val count = (s[0] - '0')
            return key to count
        }

        private fun MutableMap<String, Int>.put(pair: Pair<String, Int>) {
            this[pair.first] = pair.second
        }
    }

    fun solve(map: Map<String, Bag>, target: String): Int {
        var count = 0
        map.values.forEach {  bag ->
            if(bag.key != target && traverse(bag, target)) {
                count++
            }
        }
        return count
    }

    private fun traverse(bag: Bag, target: String): Boolean {
        if(bag.key == target) return true
        for(b in bag.bags) {
            if(traverse(b.key, target)) return true
        }
        return false
    }

    fun solve2(bag: Bag): Int {
        // subtract 1 since we don't consider the bag itself
        bag.bags.forEach {
            println("${it.key.key} == ${it.value}")
        }
        return traverse2(bag) - 1
    }

    private fun traverse2(bag: Bag): Int {
        var count = 0

        bag.bags.forEach { b ->
            count += traverse2(b.key) * b.value
        }
        return count + 1
    }
}

fun main() {
    val list = Day7.RuleFactory.getRules(FileUtil.read("day7.txt").split("\n"))
    val bags = Day7.BagFactory(list).holder
    println(Day7().solve(bags, "shiny gold bag"))
    println(Day7().solve2(bags["shiny gold bag"]!!))

}