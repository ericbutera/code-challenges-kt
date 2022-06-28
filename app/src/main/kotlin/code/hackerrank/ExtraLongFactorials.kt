// https://www.hackerrank.com/challenges/extra-long-factorials/problem
package code.hackerrank

import java.math.BigInteger

fun extraLongFactorialsReturn(n: Int): BigInteger {
    var base = n.toBigInteger()
    for (number in (n - 1) downTo 1) {
        base = base.multiply(number.toBigInteger())
    }

    return base
}
