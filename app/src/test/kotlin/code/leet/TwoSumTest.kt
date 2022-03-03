package code.leet

import kotlin.test.*

class TwoSumTest {
    @Test fun one() {
        assertContentEquals(
            intArrayOf(1,2),
            twoSumQuadratic(intArrayOf(3,2,4), 6)
        )
    }

    @Test fun two() {
        assertContentEquals(
            intArrayOf(0,1),
            //twoSumQuadratic(intArrayOf(2,7,11,15), 9)
                    twoSumHash(intArrayOf(2,7,11,15), 9)
        )
    }
}