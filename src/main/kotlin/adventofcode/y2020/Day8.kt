package adventofcode.y2020

import adventofcode.util.FileUtil
import java.util.*

class Day8 {
    data class Node(
        val id: UUID,
        val instruction: String,
        val n: Int
    )

    object Parser {
        fun parse(list: List<String>): List<Node> {
            return list.map {  s ->
                s.parse()
            }
        }

        private fun String.parse(): Node {
            val s = split(" ")
            return Node(UUID.randomUUID(), s[0], s[1].trim().toInt())
        }
    }

    fun solve(nodes: List<Node>): Int {
        var acc = 0
        val list = mutableListOf<Node>()
        var i = 0
        while(true) {
            if(list.contains(nodes[i])) {
                return acc
            }
            val node = nodes[i]
            list.add(node)
            when(node.instruction) {
                "jmp" -> i += node.n
                "acc" -> {
                    i++
                    acc += node.n
                }
                else -> { i++ }
            }
        }
    }

    fun solve2(nodes: List<Node>): Int {
        traverse(nodes, listOf(), 0, false, 0)
        return 0
    }

    fun traverse(nodes: List<Node>, visited: List<Int>, i: Int, changed: Boolean, acc: Int): Boolean {
        if(visited.contains(i)) return false
        if(i >= nodes.size) {
            println(acc)
            return true
        }
        val v = visited.toMutableList().also {  it.add(i) }
        val node = nodes[i]
        if(!changed) {
             val b = when(node.instruction) {
                "nop" -> traverse(nodes, v, i + node.n, true, acc)
                "acc" -> traverse(nodes, v, i + 1, true, acc + node.n)
                else -> traverse(nodes, v, i + 1, true, acc)
            }
            if(b) return true
            when(node.instruction) {
                "jmp" -> traverse(nodes, v, i + node.n, changed, acc)
                "acc" -> traverse(nodes, v, i + 1, changed, acc + node.n)
                else -> traverse(nodes, v, i + 1, changed, acc)
            }
        } else {
            val b = when(node.instruction) {
                "jmp" -> traverse(nodes, v, i + node.n, changed, acc)
                "acc" -> traverse(nodes, v, i + 1, changed, acc + node.n)
                else -> traverse(nodes, v, i + 1, changed, acc)
            }
            if(b) return true
        }
        return false
    }
}

fun main() {
    val list = FileUtil.read("day8.txt").split("\n")
    val nodes = Day8.Parser.parse(list)
    println(Day8().solve(nodes))
    Day8().solve2(nodes)
}