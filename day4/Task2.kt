fun main() {
    val countOverlappingPairs = readResourceAsText("input1.txt").lines().map {
        val (range1, range2) = it.split(",")
        val (range1StartString, range1EndString) = range1.split("-")
        val (range2StartString, range2EndString) = range2.split("-")

        val range1Start = range1StartString.toInt()
        val range2Start = range2StartString.toInt()
        val range1End = range1EndString.toInt()
        val range2End = range2EndString.toInt()

        if (range1End >= range2Start && range1Start < range2End) {
            1
        } else if (range2End >= range1Start && range2Start < range1End) {
            1
        } else if (range1Start <= range2Start && range1End >= range2End) {
            1
        } else if (range2Start <= range1Start && range2End >= range1End) {
            1
        } else {
            0
        }
    }.reduce { acc, i -> acc + i }

    println(countOverlappingPairs)
}