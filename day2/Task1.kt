enum class Turn(val points: Int, val opponentSign: String, val yourSign: String) {
    Rock(1, "A", "X"),
    Paper(2, "B", "Y"),
    Scissors(3, "C", "Z");

    companion object {
        private val opponentMap = Turn.values().associateBy { it.opponentSign }
        private val yourMap = Turn.values().associateBy { it.yourSign }

        fun opponentTurn(sign: String): Turn = opponentMap[sign]!!
        fun yourTurn(sign: String): Turn = yourMap[sign]!!
    }
}

fun main() {
    val totalScore = readResourceAsText("input.txt").lines().map {
        it.split(" ")
        val (opponentTurnSign, yourTurnSign) = it.split(" ")

        val yourTurn = Turn.yourTurn(yourTurnSign)
        val outcome = when (Turn.opponentTurn(opponentTurnSign)) {
            Turn.Rock -> {
                when (yourTurn) {
                    Turn.Rock -> 3
                    Turn.Paper -> 6
                    Turn.Scissors -> 0
                }
            }

            Turn.Paper -> {
                when (yourTurn) {
                    Turn.Rock -> 0
                    Turn.Paper -> 3
                    Turn.Scissors -> 6
                }
            }

            Turn.Scissors -> {
                when (yourTurn) {
                    Turn.Rock -> 6
                    Turn.Paper -> 0
                    Turn.Scissors -> 3
                }
            }
        }

        yourTurn.points + outcome

    }.reduce { a, b ->
        a + b
    }

    println(totalScore)
}