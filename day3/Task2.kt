fun main() {

    val group = mutableListOf<String>()
    var sum = 0

    readResourceAsText("input.txt").lines().forEach {
        group.add(it)
        if (group.size == 3) {

            val (first, second, third) = group

            sum += priorities[(first.toSet() intersect second.toSet() intersect third.toSet()).first()]!!

            group.clear()
        }
    }

    println(sum)
}