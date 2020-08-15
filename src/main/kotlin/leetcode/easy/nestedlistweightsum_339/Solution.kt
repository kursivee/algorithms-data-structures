package leetcode.easy.nestedlistweightsum_339

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation

 */
 interface NestedInteger {
    
     // @return true if this NestedInteger holds a single integer, rather than a nested list.
     val isInteger: Boolean

     // @return the single integer that this NestedInteger holds, if it holds a single integer
     // Return null if this NestedInteger holds a nested list
     fun getInteger(): Int?

     // Set this NestedInteger to hold a single integer.
     fun setInteger(value: Int): Unit

     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
     fun add(ni: NestedInteger): Unit

     // @return the nested list that this NestedInteger holds, if it holds a nested list
     // Return null if this NestedInteger holds a single integer
     fun getList(): List<NestedInteger>
 }

class Solution {
    fun depthSum(nestedList: List<NestedInteger>): Int {
        return sum(nestedList, 1)
    }

    private fun sum(list: List<NestedInteger>, depth: Int): Int {
        var sum = 0
        list.forEach { i ->
            if(i.isInteger) sum += i.getInteger()!! * depth
            else {
                sum += sum(i.getList(), depth + 1)
            }
        }
        return sum
    }
}