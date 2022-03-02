package code.cracking

// TODO determine if string is all unique characters
// what if cannot use extra data structures?
fun isUnique(text: String): Boolean {
    val used = mutableSetOf<Char>()

    for (c in text) {
        if (used.contains(c)) {
            return false
        }

        used.add(c)
    }

    return true
}
