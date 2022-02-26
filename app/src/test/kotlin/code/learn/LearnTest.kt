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

    @Test fun anony() {
        assertEquals(4, "Mississippi".count({ letter -> letter == 's' }))

        // `it` is a convenience to represent single parameter lambdas
        assertEquals(4, "Mississippi".count({ it == 's' }))

        val loudNarration: (String, String) -> String = { message, tone ->
            when (tone) {
                "excited" -> {
                    val numExclamationPoints = 3
                    message.uppercase() + "!".repeat(numExclamationPoints)
                }
                "sneaky" -> {
                    "$message. The narrator has just blown Madrigal's cover.".uppercase()
                }
                else -> message.uppercase()
            }
        }

        val res = loudNarration("Madrigal cautiously tip-toes through the hallway", "sneaky")
        assertEquals("MADRIGAL CAUTIOUSLY TIP-TOES THROUGH THE HALLWAY. THE NARRATOR HAS JUST BLOWN MADRIGAL'S COVER.", res)
    }

    @Test fun createTitle() {
        val vowelCount = "Thanks".count { it in "aeiou" }
        assertEquals(1, vowelCount)
    }

    @Test fun lists() {
        val patrons: List<String> = listOf("Eli", "Mordoc", "Sophie")
        assertEquals(3, patrons.count())
        assertEquals("Eli", patrons.first())

        val more = listOf("Cups", "Plates", "Forks")
        assertEquals("Forks", more.last())
        assertEquals("Plates", more.getOrElse(1) { "noop" })
        assertEquals("op", patrons.getOrElse(5) { "op" })

        val peeps = mutableListOf("Eli","Mordoc","Sophie")
        peeps -= listOf("Eli", "Sophie")
        assertEquals(listOf("Mordoc"), peeps)

        assertEquals("EliMordocSophie", peeps.reduce { acc, it -> acc + it })
        assertEquals(1, peeps.fold(0) { acc, it -> acc + it.length })

        val otherPeeps = mutableListOf("Eli", "Mordoc", "Sophie")
        otherPeeps.removeAll(listOf("Eli", "Mordoc"))
        assertEquals(listOf("Sophie"), otherPeeps)

        /*
        add(value)
        add(0, value)
        addAll(listOf("one","two"))
        clear()
        remove(value)
         */
    }

    @Test fun forLoop() {
        var total = 0
        for (i in 0 until 5) {
            total += i
        }
        assertEquals(10, total)

        val patrons = listOf("Eric", "Katie", "Luna")
        val reversed = mutableListOf<String>()
        for (i in patrons.size - 1 downTo 0 step 1) {
            reversed.add(patrons[i])
        }
        assertEquals(listOf("Luna","Katie","Eric"), reversed)
    }

    @Test fun foreachIndexed() {
        val patrons = mutableListOf("Eli", "Mordoc", "Sophie")
        var text = ""
        patrons.forEachIndexed({ index, patron -> text += "$index:$patron"})
        assertEquals("0:Eli1:Mordoc2:Sophie", text)
    }

    @Test fun sets() {
        val planets = setOf("Earth", "Mercury", "Venus", "Earth", "Earth")
        assertEquals(3, planets.count())
    }

    @Test fun map() {
        val evens = (1..10)
            .toList()
            .filter { it % 2 == 0 }
        println(evens)
        assertEquals(listOf(2, 4, 6, 8, 10), evens)
    }

    @Test fun array() {
        val numbers = arrayOf(1,2,3,4)
        val total = numbers.reduce { acc, it -> acc + it }
        assertEquals(10, total)
        assertEquals(1, numbers.first())
        assertEquals(1, numbers[0])
        assertEquals(listOf(2,3), numbers.slice(1..2))
    }

    @Test fun reduceAndFold() {
        val peeps = mutableListOf("Eli","Mordoc","Sophie")
        // notice the accumulator difference between reduce and fold
        // fold allows changing the type of the accumulator
        assertEquals("EliMordocSophie", peeps.reduce { acc, it -> acc + it })
        assertEquals(15, peeps.fold(0) { acc, it -> acc + it.length })
    }

    @Test fun mapper() {
        val numbers = listOf(1,2,3,4)
        val expected = listOf(2,3,4,5)
        // it is shorthand for "single parameter lambda"
        assertEquals(expected, numbers.map { it + 1 })
        assertEquals(expected, numbers.map { number -> number + 1 })
    }

    @Test fun spread() {
        val animals = listOf("Piggy", "Puppy", "Bunny", "Chicky")
        val res = mutableListOf(*animals.toTypedArray())
        assertEquals(animals, res)
    }

    @Test fun flip() {
        val grades = mapOf("Josh" to 4.0, "Alex" to 2.0, "Jane" to 3.0)

        val flip = grades.map { (name, grade) ->
            grade to name
        }.toMap()

        // flipper: (ParamType -> ReturnType = parameter1 -> {
        //   parameter1.map { (DereferencePairKey, DereferencePairValue) -> {
        //     value to key
        //   }.toMap()
        // }
        val flipper: (Map<String, Double>) -> Map<Double, String> = { items ->
            items.map { (name, grade) ->
                grade to name
            }.toMap()
        }

        val flipped = flipper(grades)

        assertEquals(mapOf(4.0 to "Josh", 2.0 to "Alex", 3.0 to "Jane"), flipped)
        assertEquals(flip, flipped)
    }
}
// val loudNarration: (String, String) -> String = { message, tone ->
   // when (tone) {
