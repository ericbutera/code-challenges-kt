package code.hackerrank

fun simpleArraySum(numbers: Array<Int>) : Int =
    numbers.reduce { acc, it ->  acc + it }