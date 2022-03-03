package code.leet

fun twoSumQuadratic(nums: IntArray, target: Int): IntArray {
    for (x in (0..nums.size-2)) { // start of array until first before last
        for (y in (x+1..nums.size-1)) { // begin at x + 1 until end
            if (nums[x] + nums[y] == target) {
                return intArrayOf(x,y)
            }
        }
    }

    throw IllegalArgumentException("You may assume that each input would have exactly one solution, and you may not use the same element twice.")
}

fun twoSumHash(nums: IntArray, target: Int): IntArray {
    val found = mutableMapOf<Int, Int>()

    for (i in (0..nums.size)) {
        val complement = target - nums[i]
        val attempt = found.get(complement)
        if (attempt != null)
            return intArrayOf(attempt, i)

        found[nums[i]] = i
    }

    throw IllegalArgumentException("You may assume that each input would have exactly one solution, and you may not use the same element twice.")
}

/*
nums 3,2,4
target 6
output 1,2 because nums[1] + nums[2] = 6

 */