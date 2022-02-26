package code.challenges

import kotlin.test.*

class ModifiedKaprekarNumbersTest {
    //@Test fun sample() { assertEquals() }
    @Test fun splitter() {
        assertEquals(Pair(0,2), kaprekarSplit(2))
        assertEquals(Pair(2,5), kaprekarSplit(25))
        assertEquals(Pair(2,55), kaprekarSplit(255))
        assertEquals(Pair(25,55), kaprekarSplit(2_555))
        assertEquals(Pair(25,555), kaprekarSplit(25_555))
    }

    @Test fun kaprekar() {
        assertEquals(false, kaprekarNumber(5))
        assertEquals(true, kaprekarNumber(9))
    }

    @Test fun case6() {
        // input 1, 99999
        // output = 1 9 45 55 99 297 703 999 2223 2728 4950 5050 7272 7777 9999 17344 22222 77778 82656 95121 99999
        //kaprekarNumbers(1, 99999)
        kaprekarNumbers(1, 99999)
    }

}