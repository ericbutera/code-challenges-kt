package code.cracking

import kotlin.test.*

class IsUniqueTest {
    @Test fun abc() {
        assertTrue(isUnique("abc"))
    }

    @Test fun abcdd() {
        assertFalse(isUnique("abcdd"))
    }
}