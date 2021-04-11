fun getOrder(words: List<String>): List<Char> {
    val graph = Graph()
    for (i in 1 until words.size) {
        val prevName = words[i-1]
        val curName = words[i]
        for (j in 0 until prevName.length.coerceAtMost(curName.length)) {
            if (prevName[j] != curName[j]) {
                graph.addEdge(prevName[j] - 'a', curName[j] - 'a')
                break
            }
        }
    }
    return graph.topologicalSort().map {
        'a' + it
    }
}

fun main() {
    val n = readLine()!!.toInt()
    val names = generateSequence { readLine() }.constrainOnce().take(n).toList()
    try {
        val order = getOrder(names)
        for (c in order) {
            print(c)
        }
        println()
    } catch (e: Graph.CycleFoundException) {
        println("Impossible")
    }

}
