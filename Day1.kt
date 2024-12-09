import java.io.File

fun main() {
    print("start")
    val result = Solution1a().regex()

    println(result)
}

class Solution1a {

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

        val left = leftLists.sorted()
        val right = rightLists.sorted()
        for (i in 0 .. size - 1) {
            sum += Math.abs(left[i] - right[i]).toLong()
            println("i $i")
            println("sum $i")
        }

        return sum
    }
}
