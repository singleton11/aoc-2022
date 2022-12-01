import java.util.PriorityQueue

fun main() {
    var accumulator = 0

    val minHeap = PriorityQueue(Comparator<Int> { o1, o2 -> o1.compareTo(o2) * -1 })

    readResourceAsText("input.txt").lines().forEach {
        if (it == "") {
            minHeap.add(accumulator)
            accumulator = 0
        } else {
            accumulator += it.toInt()
        }
    }

    println(minHeap.poll() + minHeap.poll() + minHeap.poll())
}