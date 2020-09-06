package leetcode.easy.minindexsumtwolist_599

class Solution {
    data class Item(val s: String, var i: Int)
    fun findRestaurant(list1: Array<String>, list2: Array<String>): Array<String> {
        val map = mutableMapOf<String, MutableList<Int>>()
        list1.forEachIndexed { index, s ->
            val list = map.getOrDefault(s, mutableListOf())
            list.add(index)
            map[s] = list
        }
        list2.forEachIndexed { index, s ->
            val list = map.getOrDefault(s, mutableListOf())
            list.add(index)
            map[s] = list
        }
        val filtered = map.filter { (_, v) ->
            v.size == 2
        }
        var min = Int.MAX_VALUE
        filtered.forEach { (_, v) ->
            min = minOf(min, v.sum())
        }
        val list = mutableListOf<String>()
        filtered.forEach { (k, v) ->
            if(v.sum() == min) {
                list.add(k)
            }
        }
        return list.toTypedArray()
    }
}