import java.io.File

fun main() {
    val result = Solution2().checkSafety()

    println(result)
}

class Solution2 {

    fun checkSafety(): Int {
        var safeCount = 0
        File("inputDay2.txt").forEachLine {
            val list: MutableList<Int> = mutableListOf()
            it.split("\\s+".toRegex()).map {
                list.add(it.toInt())
            }
            safeCount = aocDay2(list, safeCount)
        }

        return safeCount
    }

    fun aocDay2(list: List<Int>, safeCount: Int): Int =
        checkSafeDescending(list, safeCount)

    fun checkSafeDescending(list: List<Int>, safeCount: Int): Int {
        val size = list.size
        var isSafe = false
        var localSafeCount = safeCount
        for (i in 0 ..  size - 2) {
            if (list[i] > list[i + 1] && list[i] - list[i + 1] <= 3 ) {
                isSafe = true
            } else if(i == 0 && list[i] < list[i + 1]) {
                localSafeCount = checkSafeAscending(list, localSafeCount)
                isSafe = false
                break
            } else {
                isSafe = false
                break
            }
        }
        if (isSafe) {
            println("isSafe: $isSafe")
            println("localSafeCount: $localSafeCount")
        }
        return if (isSafe) ++localSafeCount else localSafeCount
    }

    fun checkSafeAscending(list: List<Int>, safeCount: Int): Int {
        val size = list.size
        var isSafe = false
        var localSafeCount = safeCount
        for (i in 0 ..  size - 2) {
            if (list[i] < list[i + 1] && list[i + 1] - list[i] <= 3 ) {
                isSafe = true
            } else if(i == 0 && list[i] > list[i + 1]) {
                localSafeCount = checkSafeDescending(list, localSafeCount)
                isSafe = false
                break
            } else {
                isSafe = false
                break
            }
        }
        if (isSafe) {
            println("isSafe: $isSafe")
            println("localSafeCount: $localSafeCount")
        }
        return if (isSafe) ++localSafeCount else localSafeCount
    }
}
