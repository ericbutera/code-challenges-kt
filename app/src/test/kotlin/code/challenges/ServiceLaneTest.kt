package code.challenges

import kotlin.test.*

class ServiceLaneTest {
    @Test fun sample() {
        val widths = arrayOf(2,3,1,2,3,2,3,3)
        val cases = arrayOf(
            arrayOf(0,3),
            arrayOf(4,6),
            arrayOf(6,7),
            arrayOf(3,5),
            arrayOf(0,7),
        )
        val res = arrayOf(1,2,3,2,1)

        assertContentEquals(res, serviceLane(widths, cases.size, cases))
        assertContentEquals(res, serviceLane2(widths, cases.size, cases))
    }
}