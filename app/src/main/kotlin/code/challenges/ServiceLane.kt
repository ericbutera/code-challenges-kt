// https://www.hackerrank.com/challenges/service-lane/problem?isFullScreen=true
package code.challenges

fun serviceLane(widths: Array<Int>, n: Int, cases: Array<Array<Int>>): Array<Int> {
    // note: n = cases.size
    val maxWidths = Array(cases.size){ 0 }

    val max = cases.size - 1
    for (x in 0..max) {
        // get shoulder width numbers
        val case = cases[x]
        val (start, end) = case
        val slice = widths.slice(start..end)

        //val smallest = Math.min(*width.slice(start..end))
        //val smallest = slice.reduce { acc, it -> if (it < acc) { it } else { acc } }

        var smallest = slice[0]
        for (attempt in slice) {
            if (attempt < smallest) {
                smallest = attempt
            }
        }

        maxWidths[x] = smallest
    }

    return maxWidths
}

fun serviceLane2(widths: Array<Int>, n: Int, cases: Array<Array<Int>>): Array<Int> {
    val maxWidths = Array(cases.size){ 0 }

    val max = cases.size - 1
    cases.forEachIndexed { index, case ->
        val (start, end) = case

        var smallest = widths[start]
        for (x in start..end) {
            if (widths[x] < smallest) {
                smallest = widths[x]
            }
        }

        maxWidths[index] = smallest
    }

    return maxWidths
}

/*
array of widths at points along road
list of indicies of entry and exits

calculate max size vehicle

n = 4
width = [2,3,2,1]
cases = [[1,2],[2,4]]
2
1


find the smallest number between the cases ranges
width = [2, 3, 1, 2, 3, 2, 3, 3]
cases = [[0, 3], [4, 6], [6, 7], [3, 5], [0, 7]]

val (start, end) = cases.first() # 0, 3
width.slice(start, end) = [2,3,1,2]
    min(2,3,1,2) = 1

 */