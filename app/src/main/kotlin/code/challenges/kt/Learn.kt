// kotlin second edition
// big nerd ranch
package code.challenges.kt

const val HERO_NAME = "Madrigal"
const val LEVEL_TWO = 2

// val pub = "Unicorn's Horn"
// val gold = 50
// val publican = "publican"
// val drinks : List = "wine", "mead", "LaCroix"

fun obtainQuest(level: Int) : String? = when(level) {
    1 -> "Meet Mr. Bubbles in the land of soft things"
    in 2..6 -> "Save the town"
    7 -> "Locate the enchanted sword"
    8 -> null
    else -> "No quests right now"
}

class Learn {
    private val hasSteed = false
    // private val race = "gnome"

    fun playerLevel(): Int {
        return 1
    }

    fun levelUp() : Int {
        return playerLevel() + 1
    }

    fun name() : String {
        return HERO_NAME
    }

    fun hasSteed() : Boolean {
        return hasSteed
    }

    fun magicMirror() : String {
        return name().reversed()
    }

    fun faction(race: String): String = when(race) {
        "dwarf" -> "Keeper of the Mines"
        "gnome" -> "Tinkerers of the Underground"
        "orc","human" -> "Free People of the Rolling Hills"
        else -> "Shadow Cabal of the Unseen Realm"
    }

    fun title(level: Int): String {
        require(level > 0) {
            "Player's level must be at least 1"
        }
        return when(level) {
            1 -> "Apprentice"
            in 2..8 -> "Level $level Warrior"
            9 -> "Vanquisher of Nogrtse"
            else -> "Distinguished Knight"
        }
    }

    fun nameAndTitle(): String = "${name()} the ${title(playerLevel())}"

    fun levelStatus(xp: Int = 1): String = when {
        xp > LEVEL_TWO -> {
            "You already leveled up!"
        }
        xp == LEVEL_TWO -> {
            "You have enough experience to level up"
        }
        else -> "Not yet!"
    }
}

fun throwException(isThrow: Boolean = false): String {
    try {
        throw IllegalArgumentException("Argh")
    } catch (e: Exception) {
        if (isThrow)
            throw e
    }
    return "Not today"
}
