package leetcode.medium.designstackwithincop_1381

class CustomStack(private val maxSize: Int) {

    private val list = mutableListOf<Int>()

    fun push(x: Int) {
        if(list.size != maxSize) {
            list.add(x)
        }
    }

    fun pop(): Int {
        return if(list.isEmpty()) {
            -1
        } else list.removeAt(list.size - 1)
    }

    fun increment(k: Int, `val`: Int) {
        var count = 0
        while(count < k && count < list.size) {
            list[count] = list[count] + `val`
            count++
        }
    }

}

/**
 * Your CustomStack object will be instantiated and called as such:
 * var obj = CustomStack(maxSize)
 * obj.push(x)
 * var param_2 = obj.pop()
 * obj.increment(k,`val`)
 */