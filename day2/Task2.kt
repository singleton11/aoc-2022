enum class Strategy(val sign: String, val points: Int) {
    Loose("X", 0),
    Draw("Y", 3),
    Win("Z", 6);

    companion object {
        private val signMap = Strategy.values().associateBy { it.sign }

        fun value(sign: String): Strategy = signMap[sign]!!
    }
}

fun main() {
    val totalScore = readResourceAsText("input.txt").lines().map {
        it.split(" ")
        val (opponentTurnSign, strategySign) = it.split(" ")

        val strategy = Strategy.value(strategySign)

        val shape = when (Turn.opponentTurn(opponentTurnSign)) {
            Turn.Rock -> {
                when (strategy) {
                    Strategy.Loose -> Turn.Scissors.points
                    Strategy.Draw -> Turn.Rock.points
                    Strategy.Win -> Turn.Paper.points
                }
            }

            Turn.Paper -> {
                when (strategy) {
                    Strategy.Loose -> Turn.Rock.points
                    Strategy.Draw -> Turn.Paper.points
                    Strategy.Win -> Turn.Scissors.points
                }
            }

            Turn.Scissors -> {
                when (strategy) {
                    Strategy.Loose -> Turn.Paper.points
                    Strategy.Draw -> Turn.Scissors.points
                    Strategy.Win -> Turn.Rock.points
                }
            }
        }

        shape + strategy.points

    }.reduce { a, b ->
        a + b
    }

    println(totalScore)
}