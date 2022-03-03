// https://leetcode.com/problems/implement-strstr/
package code.leet

fun strStr(haystack: String, needle: String): Int {
    // haystack = hello
    // needle = ll

    // ascii vs unicode

    if (haystack == needle || needle.isEmpty()) {
        return 0
    }

    if (needle.length > haystack.length)
        return -1

    val needleLength = needle.length - 1
    val needleFirst = needle[0]
    haystack.forEachIndexed { index, char ->
        if (char != needleFirst)
            return@forEachIndexed // mimics continue

        // ensure there are enough chars left in haystack to compare needle
        val remain = haystack.length - index
        if (needleLength > remain)
            return@forEachIndexed // mimics continue

        var allMatch = true

        for (x in 1 until needle.length) {
            if (haystack[x + index] != needle[x]) {
                allMatch = false
                break
            }
        }

        if (allMatch)
            return index
    }

    return -1;

    /*
    var hasMatch = false
    var matchLength = needle.length - 1 // needs to reset on each "found match"

    for (c in haystack) {
        println("c $c")
        if (c == needleFirst) { // found potential match
            hasMatch = true
            // start comparing haystack == needle
            // from this offset to needle.size
            println("match on $c == $needleFirst")
            continue
        } else {
            if (hasMatch) {
                hasMatch = false
            }
        }

    }

    return -1
     */
}
/*

inspect each char of haystack
compare against first first char of needle

for haystack-char in haystack.chars
    if haystack-char == needle-chars.first

        all = true
        compare needle-chars(1..needle-chars.size) <-- skip first

        if (haystack.char

ends up working like
h e l l o
_ _ l l <-- once current haystack char matches needle char, inspect from that point on for the length of needle
^
`skip


brute force quadratic:
1. find first char match between needle & haystack, record offset
2. from offset to haystack.length, ensure each character match

linear:
1. iterate haystack checking for start of needle
- if a match is found
    - inMatch = true
    - found = haystack index

    continue iterating haystack as normal


 */