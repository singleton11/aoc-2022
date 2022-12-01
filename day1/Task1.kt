fun main() {
    var maxCarryingFood = 0
    var accumulator = 0
    readResourceAsText("input.txt").lines().forEach {
        if (it == "") {
            if (accumulator > maxCarryingFood) {
                maxCarryingFood = accumulator
            }
            accumulator = 0
        } else {
            accumulator += it.toInt()
        }
    }

    println(maxCarryingFood)
}