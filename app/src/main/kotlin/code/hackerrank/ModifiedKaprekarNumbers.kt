// https://www.hackerrank.com/challenges/kaprekar-numbers/problem
package code.hackerrank

import kotlin.math.pow

fun kaprekarNumbers(p: Int, q: Int) {
    var hasNumbers = false
    for (n in (p..q)) {
        if (kaprekarNumber(n)) {
            if (!hasNumbers) hasNumbers = true

            print("$n ")
        }
    }

    if (!hasNumbers)
        print("INVALID RANGE")
}

fun kaprekarNumber(n: Int): Boolean {
    //val number = n * n fails on 99999 * 99999, rollover
    // https://kotlinlang.org/docs/basic-types.html#numbers
    val number = n.toDouble().pow(2).toLong()
    val (left, right) = kaprekarSplit(number)
    val attempt = left + right
    return attempt == n
}

fun kaprekarSplit(n: Int): Pair<Int, Int> {
    return kaprekarSplit(n.toLong())
}

fun kaprekarSplit(n: Long): Pair<Int, Int> {
    require(n > 0) { "Number must be greater than 0 to split `$n`" }
    val text = n.toString()
    val middle = text.length / 2 // kotlin autofloors floor((text.length / 2).toDouble())

    val left = if (middle > 0) text.substring(0, middle).toInt() else 0
    val right = text.substring(middle, text.length).toInt()
    return Pair(left, right)
}

/*
Note: the problem said there were leading 0's; shouldn't be a thing with Int, but keep in mind

Kaprekar number is a positive whole number with a special property.
If you square it, then split the number into two integers and sum those integers, you have the same value you started with.

split(num): Pair
    goal: return (left, right)
    - right must be num digits long
    - left is remaining substring

    (  0,   1) =      1
    (  2,   5) =     25
    (  2,  55) =    255
    ( 22,  55) =  2_555
    (222, 555) = 25_555

    text = num.toString
    rightoffset = math.floor(text.length() / 2)
        text 255 len 3
        3 / 2 = 1.5
        middle = floor(1.5) = 1 <- ensure the right side has more digits
        left = substr(0,middle)
        right = substr(middle, text.length)

bounds: 0 < p < q < 100_000
kaprekarNumbers(p, q)
    for n in (p..q)
        process(n)

process(n)
    number = (n * n)
    num1, num2 = split(number)
    attempt = num1 + num2
    return attempt == n

if results
    print space-separated in ascending order
else
    print INVALID RANGE
 */