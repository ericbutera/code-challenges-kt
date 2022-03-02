package code.challenges

import kotlin.test.*

class JumpingCloudsTest {
    @Test fun sample() {
        assertEquals(92, jumpingOnClouds(arrayOf(0,0,1,0,0,1,1,0), 2))
    }

    @Test fun case2() {
        val clouds = arrayOf(1,1,0,1,0,1,0,1,0,1,0,1,1,0,1,1,1,1,1)
        assertEquals(97, jumpingOnClouds(clouds, 19))
    }
}