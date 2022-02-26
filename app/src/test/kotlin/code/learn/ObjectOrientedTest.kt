@file:Suppress("SpellCheckingInspection")

package code.learn

import kotlin.test.*

class ObjectOrientedTest {
    @Test fun gettersSetters() {
        val i = Player()
        assertEquals("Madrigal", i.name)
        assertEquals("cant-change-this", i.readOnlyField)

        i.name = "Eric"
        assertEquals("Eric", i.name)
    }

    @Test fun methods() {
        assertEquals("2 fireballs!", Player().castFireball())
        assertEquals("1337 fireballs!", Player().castFireball(1337))
    }

    @Test fun computedProperties() {
        assertEquals("The Renowned Hero", Player().title)

        val vowel = Player()
        vowel.name = "Eloquentia"
        assertEquals("The Master of Vowels", vowel.title)
    }

    @Test fun initBlocks() {
        assertEquals(5, Player(healthPoints = 5).healthPoints)
        assertFailsWith<IllegalArgumentException> { Player(healthPoints = -1) }
    }
}