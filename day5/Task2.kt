import java.util.Stack

fun main() {

    val stacks = arrayOfNulls<Stack<Char>>(9)

    for (i in stacks.indices) {
        stacks[i] = Stack()
    }

    var crates = true

    readResourceAsText("input.txt").lines().forEach {
        if (it.length > 1 && it[1] == '1') {
            crates = !crates
            for (stack in stacks) {
                stack!!.reverse()
            }
        } else {
            if (crates) {
                it.forEachIndexed { index, c ->
                    if (c != ' ' && c != '[' && c != ']') {
                        stacks[(index - 1) / 4]!!.push(c)
                    }
                }
            } else {
                // parse moves
                "move (\\d+) from (\\d+) to (\\d+)".toRegex().findAll(it).firstOrNull()?.let { matchResult ->
                    if (matchResult.groupValues.isNotEmpty()) {
                        val (_, count, from, to) = matchResult.groupValues
                        buildList {
                            repeat(count.toInt()) {
                                add(stacks[from.toInt() - 1]!!.pop())
                            }
                        }.reversed().forEach {
                            stacks[to.toInt() - 1]!!.push(it)
                        }
                        println("move $count from $from to $to")
                    }
                }

            }
        }
    }

    val result = buildString {
        for (stack in stacks) {
            append(stack!!.peek())
        }
    }

    println(result)

}