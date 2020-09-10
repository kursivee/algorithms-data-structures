package leetcode.easy.bullsandcows_299

class Solution {
    /*
    bulls = exact match
    cows = right number, wrong pos

    first get the bulls
    itr through secret and guess and see where it matches exact

    new secret mutableList
    new guess mutableList
    itr the guesses and keep a count if secret contains n
    remove from secret list
    */
    fun getHint(secret: String, guess: String): String {
        var bulls = 0
        var cows = 0

        val newSecret = mutableListOf<Char>()
        val newGuess = mutableListOf<Char>()
        for(i in secret.indices) {
            if(secret[i] != guess[i]) {
                newSecret.add(secret[i])
                newGuess.add(guess[i])
            } else bulls++
        }
        for(c in newGuess) {
            if(newSecret.contains(c)) {
                cows++
                newSecret.remove(c)
            }
        }

        return "${bulls}A${cows}B"
    }
}