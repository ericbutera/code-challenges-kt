@file:Suppress("SpellCheckingInspection")

package code.learn

class Player(
    initialName: String = "madrigal",
    var healthPoints: Int = 1,
    val isImmortal: Boolean = false
) {
    val readOnlyField = "cant-change-this"

    var name = initialName
        get() = field.replaceFirstChar { it.uppercase() }
        set(value) {
            field = value.trim()
        }

    val title: String
        get() = when {
            name.all { it.isDigit() } -> "The Identifiable"
            name.none { it.isLetter() } -> "The Witness Protection Member"
            name.count { it.lowercase() in "aeiou" } > 4 -> "The Master of Vowels"
            else -> "The Renowned Hero"
        }

    init {
        require(healthPoints > 0) { "healthPoints are required to participate" }
    }

    fun castFireball(numFireballs: Int = 2): String {
        return "$numFireballs fireballs!"
    }
}