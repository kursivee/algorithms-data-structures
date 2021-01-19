package adventofcode.y2020

import adventofcode.util.FileUtil

data class Passport(
    val birthYear: String,
    val issueYear: String,
    val expirationYear: String,
    val height: String,
    val hairColor: String,
    val eyeColor: String,
    val passportId: String,
    val countryId: String
) {
    class Builder {
        var birthYear: String = ""
        var issueYear: String = ""
        var expirationYear: String = ""
        var height: String = ""
        var hairColor: String = ""
        var eyeColor: String = ""
        var passportId: String = ""
        var countryId: String = ""

        fun setValue(key: String, value: String) {
            when(key) {
                "byr" -> birthYear = value
                "iyr" -> issueYear = value
                "eyr" -> expirationYear = value
                "hgt" -> height = value
                "hcl" -> hairColor = value
                "ecl" -> eyeColor = value
                "pid" -> passportId = value
                "cid" -> countryId = value
            }
        }

        fun build(): Passport {
            return Passport(
                birthYear,
                issueYear,
                expirationYear,
                height,
                hairColor,
                eyeColor,
                passportId,
                countryId
            )
        }
    }
}

interface PassportValidator {
    fun validate(passport: Passport): Boolean
}

class Part2Validator: Part1Validator() {
    private val validEyeColors = arrayOf("amb", "blu", "brn", "gry", "grn", "hzl", "oth")

    override fun validate(passport: Passport): Boolean {
        if(!super.validate(passport)) return false
        with(passport) {
            if(birthYear.toInt() !in (1920 .. 2002)) return false
            if(issueYear.toInt() !in (2010 .. 2020)) return false
            if(expirationYear.toInt() !in (2020 .. 2030)) return false
            if(!validateHeight(height)) return false
            if(!validateHairColor(hairColor)) return false
            if(!validEyeColors.contains(eyeColor)) return false
            if(!validatePassportId(passportId)) return false
            return true
        }
    }
    
    private fun validateHeight(height: String): Boolean {
        if(height.contains("cm")) {
            val h = height.replace("cm", "").toInt()
            if(h !in (150 .. 193)) return false
        } else if(height.contains("in")) {
            val h = height.replace("in", "").toInt()
            if(h !in (59 .. 76)) return false
        } else return false
        return true
    }
    
    private fun validateHairColor(hairColor: String): Boolean {
        if(hairColor[0] != '#') return false
        for(c in hairColor.substring(1)) {
            if(!c.isLetterOrDigit()) return false
        }
        return true
    }
    
    private fun validatePassportId(passportId: String): Boolean {
        if(passportId.length != 9) return false
        for(c in passportId) {
            if(!c.isDigit()) return false
        }
        return true
    }
}

open class Part1Validator: PassportValidator {
    override fun validate(passport: Passport): Boolean {
        with(passport) {
            var count = 0
            count += birthYear.validate()
            count += issueYear.validate()
            count += expirationYear.validate()
            count += height.validate()
            count += hairColor.validate()
            count += eyeColor.validate()
            count += passportId.validate()
            return count == 7
        }
    }

    private fun String.validate(): Int {
        return if(isEmpty()) 0 else 1
    }
}

fun main() {
    val list = FileUtil.read("day4.txt").split("\n")
    var builder = Passport.Builder()
    var part1Count = 0
    var part2Count = 0
    val p1 = Part1Validator()
    val p2 = Part2Validator()
    for(item in list) {
        if(item.isEmpty()) {
            val passport = builder.build()
            if(p1.validate(passport)) part1Count++
            if(p2.validate(passport)) part2Count++
            builder = Passport.Builder()
            continue
        }
        item.parse().forEach { (k, v) ->
            builder.setValue(k, v)
        }
    }
    println(part1Count)
    println(part2Count)
}

fun String.parse(): Map<String, String> {
    val lines = split(" ")
    val map = mutableMapOf<String, String>()
    for(item in lines) {
        val parsedItem = item.split(":")
        map[parsedItem[0]] = parsedItem[1]
    }
    return map
}