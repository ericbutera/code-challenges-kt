// kotlin second edition
// big nerd ranch
package code.challenges.kt

const val HERO_NAME = "Madrigal"
const val LEVEL_TWO = 2

// val pub = "Unicorn's Horn"
// val gold = 50
// val publican = "publican"
// val drinks : List = "wine", "mead", "LaCroix"

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

    fun quest(level: Int) : String {
        if (level == 1) {
            return "Meet Mr. Bubbles in the land of soft things"
        } else if (level in 2..6) {
            return "Save the town"
        } else if (level == 7) {
            return "Locate the enchanted sword"
        } else {
            return "No quests right now"
        }
    }

    fun faction(race: String): String = when(race) {
        "dwarf" -> "Keeper of the Mines"
        "gnome" -> "Tinkerers of the Underground"
        "orc","human" -> "Free People of the Rolling Hills"
        else -> "Shadow Cabal of the Unseen Realm"
    }

    fun title(level: Int): String = when(level) {
        1 -> "Apprentice"
        in 2..8 -> "Level " + level + " Warrior"
        9 -> "Vanquisher of Nogrtse"
        else -> "Distingused Knight"
    }

    fun levelStatus(xp: Int): String = when {
        xp > LEVEL_TWO -> {
            "You already leveled up!"
        }
        xp == LEVEL_TWO -> {
            "You have enough experience to level up"
        }
        else -> "Not yet!"
    }

}
