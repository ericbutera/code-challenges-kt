package code.hackerrank

import kotlin.test.*

class LisasWorkbookTest {
    @Test fun sample() {
        assertEquals(1, workbook(2, 3, arrayOf(4,2)))
        assertEquals(4, workbook(5, 3, arrayOf(4,2,6,1,10)))
    }
}