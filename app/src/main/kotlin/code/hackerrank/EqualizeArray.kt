// https://www.hackerrank.com/challenges/equality-in-a-array/problem
package code.hackerrank

fun equalizeArray(arr: Array<Int>): Int {
    val counts = HashMap<Int, Int>()
    var max = 0 // contains the highest found count across arr

    for (number in arr) {
        val attempt = (counts[number] ?: 0) + 1
        counts[number] = attempt

        if (attempt > max)
            max = attempt
    }

    // leave only elements of equal value.
    // if counts.keys.size == 1, return 0

    // calculate to remove:
    // SUM all "less than max" values
    // this fails on 1,1,1,2,2,2.. must delete 1 or 2
    // add maxUsed so that only the first "max" count entry skips. the rest are summed
    var removeCount = 0
    var maxUsed = false

    for ((_, count) in counts) {

        if (!maxUsed && count == max) {
            maxUsed = true
            continue
        }

        removeCount += count
    }

    return removeCount

    // found this in discussion. nice optimization that takes total length - highest count using subtraction property
    //return arr.size - max
}
