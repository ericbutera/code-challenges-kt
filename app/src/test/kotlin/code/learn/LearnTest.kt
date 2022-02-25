package code.learn

import java.lang.IllegalArgumentException
import kotlin.test.Test
import kotlin.test.*

class LearnTest {
    @Test fun appHasAGreeting() {
        val learn = Learn()
        assertEquals(1, learn.playerLevel())
    }

    @Test fun levelUp() {
        val learn = Learn()
        assertEquals(2, learn.levelUp())
    }

    @Test fun name() {
        assertEquals("Madrigal", Learn().name())
    }

    @Test fun hasSteedDefaultsToFalse() {
        assertFalse { Learn().hasSteed() }
    }

    @Test fun magicMirror() {
        assertEquals("lagirdaM", Learn().magicMirror())
    }

    @Test fun questsReturnText() {
        assertEquals("Locate the enchanted sword", obtainQuest(7))
    }

    @Suppress("SENSELESS_COMPARISON")
    @Test fun logicalOperators() {
        val five = 4 + 1
        val lt = five < 6
        val gt = 6 > five
        val logicalAnd = lt && gt
        assertTrue { lt }
        assertTrue { gt }
        assertTrue { logicalAnd }
        assertFalse { !logicalAnd }
    }

    @Suppress("SENSELESS_COMPARISON")
    @Test fun ranges() {
        val find = 2
        val range = 1..10
        assertTrue { find in range }

        // challenge: trying out some ranges
        assertTrue { 1 in 3 downTo 1 }
        assertFalse { 3 in 1 until 3 }
        assertFalse { 2 !in (1..3) }
    }

    @Test fun faction() {
        assertEquals("Shadow Cabal of the Unseen Realm", Learn().faction("unknown"))
        assertEquals("Keeper of the Mines", Learn().faction("dwarf"))
    }

    @Test fun title() {
        assertEquals("Level 3 Warrior", Learn().title(3))
    }

    @Test fun titleWithPrecondition() {
        /*
        check
        checkNotNull
        require
        requireNotNull
        error
        assert
         */
        assertFailsWith<IllegalArgumentException> { Learn().title(-5) }
    }

    @Test fun levelStatusUsesExpressionsWithoutArgs() {
        assertEquals("Not yet!", Learn().levelStatus(1))
        assertEquals("Not yet!", Learn().levelStatus())
    }

    @Test fun nameAndTitle() {
        assertEquals("Madrigal the Apprentice", Learn().nameAndTitle())
    }

    @Suppress("SENSELESS_COMPARISON")
    @Test fun safeCall() {
        assertEquals(null, null?.toInt())
    }

    @Test fun let() {
        val message: String? = obtainQuest(7)?.replace("Nogartse", "xxxxxxxx")
            ?.let { censoredQuest ->
                """ 
                |$HERO_NAME approaches the bounty board. It reads: 
                | "$censoredQuest" 
                | """.trimMargin()
            }

        // null coalesce ?:
        assertTrue(message?.contains("approaches") ?: false)
    }

    @Test fun exceptionCatch() {
        assertEquals("Not today", throwException())
        assertFailsWith<IllegalArgumentException> { throwException(true) }
    }

    /*
    Not sure how to write this yet:
    @Test fun noReturnValue() {
        assertIs<Unit>(noReturnValue())
    }
    */
}