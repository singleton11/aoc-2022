val priorities = buildMap {
    ('a' .. 'z').forEachIndexed { index, c -> put(c, index + 1) }
    ('A' .. 'Z').forEachIndexed { index, c -> put(c, index + 27) }
}

fun main() {
    val sumOfPriorities = readResourceAsText("input.txt").lines().map {
        val first = it.slice(0 until it.length / 2)
        val second = it.slice(it.length / 2 until it.length)
        (first.toSet() intersect second.toSet()).first()
    }.map {
        priorities[it]!!
    }.reduce { acc, i -> acc + i }

    println(sumOfPriorities)
}