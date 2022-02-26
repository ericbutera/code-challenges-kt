package code.challenges

import kotlin.test.*

class SimpleArraySumTest {
    @Test fun sample() {
        assertEquals(3, simpleArraySum(arrayOf(1,2)))
        assertEquals(15, simpleArraySum(arrayOf(10,5)))
    }
}