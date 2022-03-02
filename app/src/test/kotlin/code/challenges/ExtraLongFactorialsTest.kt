package code.challenges

import kotlin.test.*
import java.math.BigInteger

class ExtraLongFactorialsTest {
    @Test fun sample() {
        val bigint = "15511210043330985984000000".toBigInteger()
        assertEquals(bigint, extraLongFactorialsReturn(25))
    }

    @Test fun input12() {
        val bigint = "119622220865480194561963161495657715064383733760000000000".toBigInteger()
        assertEquals(bigint, extraLongFactorialsReturn(45))
    }
}