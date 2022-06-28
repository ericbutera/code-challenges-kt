package code.hackerrank

import kotlin.test.Test
import kotlin.test.assertEquals

class EqualizeArrayTest {
    @Test
    fun sample() {
        assertEquals(2, equalizeArray(arrayOf(3, 3, 2, 1, 3)))
    }

    @Test
    fun case17() {
        assertEquals(4, equalizeArray(arrayOf(1, 2, 3, 1, 2, 3, 3, 3)))
        /*
        11
        22
        3333

         */
    }

    @Test
    fun case3() {
        assertEquals(3, (equalizeArray(arrayOf(1, 1, 1, 2, 2, 2))))
    }

    @Test
    fun case4() {
        assertEquals(2, (equalizeArray(arrayOf(1, 1, 2, 2, 2))))
    }

    @Test
    fun case5() {
        assertEquals(1, (equalizeArray(arrayOf(1, 2, 2, 2))))
    }

    @Test
    fun case6() {
        assertEquals(6, equalizeArray(arrayOf(1, 1, 1, 2, 2, 2, 3, 3, 3)))
    }

    @Test
    fun case7() {
        assertEquals(2, (equalizeArray(arrayOf(1, 1, 2, 2))))
    }
}
