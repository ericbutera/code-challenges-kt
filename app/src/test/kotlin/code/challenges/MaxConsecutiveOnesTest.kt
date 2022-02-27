package code.challenges

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
}
