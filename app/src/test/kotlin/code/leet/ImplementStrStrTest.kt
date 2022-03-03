package code.leet

import kotlin.test.*

class ImplementStrStrTest {
    @Test fun sample() {
        assertEquals(2, strStr("hello", "ll"))
    }

    @Test fun sample2() {
        assertEquals(-1, strStr("aaaaa", "bba"))
    }

    @Test fun sample3() {
        assertEquals(0, strStr("", ""))
    }

    @Test fun sample4() {
        assertEquals(-1, strStr("missippi", "issipi"))
    }
}