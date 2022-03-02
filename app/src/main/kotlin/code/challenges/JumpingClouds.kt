// https://www.hackerrank.com/challenges/jumping-on-the-clouds-revisited/problem?isFullScreen=true
package code.challenges

const val MOVE_ENERGY = 1
const val THUNDERHEAD_ENERGY = 1

/**
 * @param c clouds
 * @param k jump distance
 */
fun jumpingOnClouds(c: Array<Int>, k: Int): Int {
    var energy = 100
    var i = 0 // i is "current position"

    do {
        i = (i + k) % c.size

        val cloudModifier = if (c[i] == THUNDERHEAD_ENERGY) {
            2
        } else {
            0
        }

        energy -= MOVE_ENERGY + cloudModifier
    } while (i > 0)

    return energy
}

/*
c = array of clouds
e = energy level = 100

hopping game
sequentially numbered clouds - thunderheads or cumulus
character jump cloud to cloud until it reaches start again
jump of size k to cloud[(i+k) % n]

each move -1 energy
c[i] == 0 -> cumulus
c[i] == 1 -> thunderhead which -2 energy

n = number of clouds
k = jump distance

n = 8
k = 2
c = [0, 0, 1, 0, 0, 1, 1, 0]
     ^- 0=cumulus      ^- 1=thunderhead
output 92

                                      ,-(-2) because cloud-type = thunderhead = -2 energy
1. move 0 -> 2, energy: e = 100 - 1 - 2 = 97
2. move 2 -> 4, energy: e = 97 - 1 = 96
3. move 4 -> 6, energy: e = 96 - 1 = 93
4. move 6 -> 0, energy: e = 93 - 1 = 92

> (2+2) % 8
4
> (4+2) % 8
6
> (6+2) % 8
0

energy = 100
i = 0
for moves
    i = i + n // 2
    i = c[(i+k) % n]
    i = c[(0 + 2) % 8]
    cloud = c[i] = 1 = thunderhead
    energy = energy=100 - 1 cloud-type=-2


 */