import java.io.File

fun main() {
    print("start")
    val result = Solution1b().regex()

    println(result)
}

class Solution1b {

    fun regex(): Long {
        val leftLists: MutableList<Long> = mutableListOf()
        val rightLists: MutableList<Long> = mutableListOf()
        val regex = "[0-9]{5}\\s?".toRegex()
        val text = File("sample.txt").readText()
        var matchResult = regex.find(text)

        leftLists.add(matchResult!!.value.trim().toLong())
        while (matchResult != null) {
            matchResult = matchResult.next()
            if (matchResult != null) {
                if (rightLists.size < leftLists.size) {
                    rightLists.add(matchResult.value.trim().toLong())
                } else {
                    leftLists.add(matchResult.value.trim().toLong())
                }
            } else {
                break
            }
        }

        return aocDay1(leftLists, rightLists)
    }

    fun aocDay1(leftLists: List<Long>, rightLists: List<Long>): Long {

        val size = leftLists.size
        var sum = 0L

        for (i in 0 .. size - 1) {
            val left = leftLists[i]
            val occurrences = rightLists.count { it == left }
            sum += left * occurrences
            println("left $left")
            println("occurrences $occurrences")
            println("i $i")
            println("sum $sum")
        }

        return sum
    }
}
