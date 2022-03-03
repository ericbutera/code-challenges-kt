package code.hackerrank

import kotlin.test.*

class MaxConsecutiveOnesTest {
    @Test fun findConsecutiveOnes() {
        assertEquals(3, findConsecutive(intArrayOf(1,1,0,1,1,1)))
        assertEquals(4, findConsecutive(intArrayOf(1,1,1,1)))
        assertEquals(3, findConsecutive(intArrayOf(1,1,1,0,1)))
        assertEquals(0, findConsecutive(intArrayOf(0,0,0)))
    }

    @Test fun countEvens() {
        assertEquals(4, findEvenCount(intArrayOf(12,345,2,6,7896)))
    }

    @Test fun evenSized() {
        assertEquals(2, findEvenSized(intArrayOf(12,345,2,6,7896)))
    }

    @Test fun squaresSortedArray() {
        assertContentEquals(intArrayOf(0,1,9,16,100), sortedSquares(intArrayOf(-4,-1,0,3,10)))
    }
}
