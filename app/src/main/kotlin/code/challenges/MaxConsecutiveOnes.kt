// https://leetcode.com/explore/learn/card/fun-with-arrays/521/introduction/3238/
package code.challenges

const val MAX_CONSECUTIVE_SEARCH = 1

fun findConsecutive(nums: IntArray): Int {
    var max = 0
    var current = 0

    nums.forEach {
        if (it == 1)
            current += 1
        else if (it != MAX_CONSECUTIVE_SEARCH)
            current = 0

        if (current > max)
            max = current
    }

    return max
}

fun findEvenCount(nums: IntArray): Int {
    return nums.fold(0) { acc, it ->
        if (it % 2 == 0)
            acc + 1
        else
            acc
    }
}

fun findEvenSized(nums: IntArray): Int {
    return nums.fold(0) { acc, it ->
        if (it.toString().length % 2 == 0)
            acc + 1
        else
            acc
    }
}

fun sortedSquares(nums: IntArray): IntArray {
    nums.forEachIndexed { index, it -> nums[index] = it * it }
    nums.sort()
    return nums
}

/*
1,1,0,1,1,1

max = 0
current = 0

1 -> current++ = 1
1 -> current++ = 2
0 ->
    if (current > max) max = current
    current = 0
1 -> current++ = 1
1 -> current++ = 2
1 -> current++ = 3
end of loop
    if (current > max) max = current
 */
